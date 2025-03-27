package kz.suneclipse.monitor_sensors.exceptions;

import kz.suneclipse.monitor_sensors.exceptions.custom_exception.ObjectNotFound;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ObjectNotFound.class})
    private String objectNotFound(final ObjectNotFound ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected String methodValidationException(final MethodArgumentNotValidException ex) {
        return ex.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().get();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected String methodValidationException(final IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
