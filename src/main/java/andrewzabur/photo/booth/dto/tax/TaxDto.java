package andrewzabur.photo.booth.dto.tax;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;

@Data
public class TaxDto {

    private Month month;

    private Integer year;

    private Double taxPercent;

    private Long quantityOfSoldPackages;

    private BigDecimal totalIncome;

    private BigDecimal tax;
}
