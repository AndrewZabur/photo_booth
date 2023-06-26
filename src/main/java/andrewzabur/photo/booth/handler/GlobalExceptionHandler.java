package andrewzabur.photo.booth.handler;

import andrewzabur.photo.booth.exception.NoSoldPhotoPackagesException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                Objects.requireNonNull(
                        Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage()));
    }

    @ExceptionHandler(NoSoldPhotoPackagesException.class)
    public ProblemDetail handleNoSoldPhotoPackages(NoSoldPhotoPackagesException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
    }
}
