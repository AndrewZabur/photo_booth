package andrewzabur.photo.booth.dto.tax;

import andrewzabur.photo.booth.annotation.EnumValueConstraint;
import andrewzabur.photo.booth.annotation.YearConstraint;
import lombok.Data;

import java.time.Month;

@Data
public class TaxCreateDto {

    @EnumValueConstraint(enumClass = Month.class)
    private String month;

    @YearConstraint
    private Integer year;

}
