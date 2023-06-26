package andrewzabur.photo.booth.validator;

import andrewzabur.photo.booth.annotation.EnumValueConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumValueValidator implements ConstraintValidator<EnumValueConstraint, String> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumValueConstraint constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || enumClass == null) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        String constraintExplanationMessage =
                "Invalid value provided. One of the following should be used: " + Arrays.toString(enumClass.getEnumConstants());
        context.buildConstraintViolationWithTemplate(constraintExplanationMessage)
                .addConstraintViolation();

        return Arrays.stream(enumClass.getEnumConstants()).anyMatch(enumVal -> enumVal.name().equals(value));
    }
}
