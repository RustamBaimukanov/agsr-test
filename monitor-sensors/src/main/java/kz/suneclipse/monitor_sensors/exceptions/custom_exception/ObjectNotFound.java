package kz.suneclipse.monitor_sensors.exceptions.custom_exception;

public class ObjectNotFound extends RuntimeException{

    private final String message;

    public ObjectNotFound(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
