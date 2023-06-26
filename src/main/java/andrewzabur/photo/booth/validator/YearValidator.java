package andrewzabur.photo.booth.validator;

import andrewzabur.photo.booth.annotation.YearConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Calendar;

public class YearValidator implements ConstraintValidator<YearConstraint, Integer> {

    private static final int LOWEST_YEAR = 1970;

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {
        if(year == null) {
            return false;
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        context.disableDefaultConstraintViolation();

        if (year < LOWEST_YEAR) {
            String constraintExplanationMessage = "Provided year should not be lower than: " + LOWEST_YEAR;
            context.buildConstraintViolationWithTemplate(constraintExplanationMessage)
                    .addConstraintViolation();
            return false;
        }

        if (year > currentYear) {
            String constraintExplanationMessage = "Provided year should not be higher than current year: " + currentYear;
            context.buildConstraintViolationWithTemplate(constraintExplanationMessage)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
