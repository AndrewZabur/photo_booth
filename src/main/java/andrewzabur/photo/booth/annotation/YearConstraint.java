package andrewzabur.photo.booth.annotation;

import andrewzabur.photo.booth.validator.YearValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearValidator.class)
public @interface YearConstraint {

    String message() default "Invalid year provided.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
