package andrewzabur.photo.booth.service.impl;

import andrewzabur.photo.booth.component.TaxFactory;
import andrewzabur.photo.booth.dto.tax.IncomeSummaryDto;
import andrewzabur.photo.booth.dto.tax.TaxCreateDto;
import andrewzabur.photo.booth.dto.tax.TaxDto;
import andrewzabur.photo.booth.exception.NoSoldPhotoPackagesException;
import andrewzabur.photo.booth.model.Tax;
import andrewzabur.photo.booth.repository.OrderPackageRepository;
import andrewzabur.photo.booth.repository.TaxRepository;
import andrewzabur.photo.booth.service.TaxService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaxServiceImpl implements TaxService {

    private static final Long ZERO_PACKAGES = 0L;
    private static final Double TAX_RATE = 8.75;
    private static final int SCALE = 2;
    private static final Long TAX_CALCULATION_DIVISOR = 100L;

    private final OrderPackageRepository orderPackageRepository;
    private final TaxRepository taxRepository;
    private final TaxFactory taxFactory;
    private final ObjectMapper mapper;

    @Transactional
    @Override
    public TaxDto calculateTax(TaxCreateDto taxCreateDto) {
        final Month month = Month.valueOf(taxCreateDto.getMonth());

        Optional<Tax> calculatedTax = taxRepository.findByMonthAndYear(month, taxCreateDto.getYear());

        if (calculatedTax.isPresent()) {
            final Tax tax = calculatedTax.get();

            Long currentQuantityOfSoldPackages = orderPackageRepository.countPaidOrderPackages(month.getValue(), taxCreateDto.getYear());

            if (currentQuantityOfSoldPackages.equals(tax.getQuantityOfSoldPackages())) {
                return mapper.convertValue(tax, TaxDto.class);
            }

            final IncomeSummaryDto recalculatedIncomeSummaryDto = taxRepository
                    .calculateIncome(Month.valueOf(taxCreateDto.getMonth()).getValue(), taxCreateDto.getYear());

            tax.setQuantityOfSoldPackages(recalculatedIncomeSummaryDto.getQuantityOfSoldPackages());
            tax.setTotalIncome(recalculatedIncomeSummaryDto.getTotalIncome());
            tax.setTax(calculateTax(recalculatedIncomeSummaryDto.getTotalIncome()));
            return mapper.convertValue(taxRepository.save(tax), TaxDto.class);
        }

        final IncomeSummaryDto incomeSummaryDto = taxRepository
                .calculateIncome(Month.valueOf(taxCreateDto.getMonth()).getValue(), taxCreateDto.getYear());

        if (incomeSummaryDto.getQuantityOfSoldPackages().equals(ZERO_PACKAGES)) {
            throw new NoSoldPhotoPackagesException("There are 0 sold photo packages. Tax can't be calculated.");
        }

        final Tax newTax = taxFactory.createTax(incomeSummaryDto, TAX_RATE, calculateTax(incomeSummaryDto.getTotalIncome()));

        return mapper.convertValue(taxRepository.save(newTax), TaxDto.class);
    }

    private BigDecimal calculateTax(BigDecimal totalIncome) {
        return totalIncome.multiply(BigDecimal.valueOf(TAX_RATE))
                .divide(BigDecimal.valueOf(TAX_CALCULATION_DIVISOR), SCALE, RoundingMode.HALF_UP);
    }

}
