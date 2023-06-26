package andrewzabur.photo.booth.dto.tax;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class IncomeSummaryDto {

    private Integer monthValue;

    private Integer year;

    private BigDecimal totalIncome;

    private Long quantityOfSoldPackages;

}
