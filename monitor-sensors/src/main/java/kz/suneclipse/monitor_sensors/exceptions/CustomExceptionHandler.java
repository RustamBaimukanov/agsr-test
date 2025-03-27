package kz.suneclipse.monitor_sensors.exceptions;

import kz.suneclipse.monitor_sensors.exceptions.custom_exception.ObjectNotFound;
import org.springframework.http.HttpStatus;
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
}
