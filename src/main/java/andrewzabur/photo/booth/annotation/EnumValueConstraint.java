package andrewzabur.photo.booth.annotation;

import andrewzabur.photo.booth.validator.EnumValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
public @interface EnumValueConstraint {
    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid value provided.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
