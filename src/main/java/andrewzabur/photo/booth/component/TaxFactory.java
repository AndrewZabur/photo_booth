package andrewzabur.photo.booth.component;

import andrewzabur.photo.booth.dto.tax.IncomeSummaryDto;
import andrewzabur.photo.booth.model.Tax;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Month;

@Component
public class TaxFactory {

    public Tax createTax(IncomeSummaryDto incomeSummaryDto, Double taxRate, BigDecimal tax) {
        final Tax taxEntity = new Tax();
        taxEntity.setMonth(Month.of(incomeSummaryDto.getMonthValue()));
        taxEntity.setYear(incomeSummaryDto.getYear());
        taxEntity.setTaxPercent(taxRate);
        taxEntity.setQuantityOfSoldPackages(incomeSummaryDto.getQuantityOfSoldPackages());
        taxEntity.setTotalIncome(incomeSummaryDto.getTotalIncome());
        taxEntity.setTax(tax);
        return taxEntity;
    }

}
