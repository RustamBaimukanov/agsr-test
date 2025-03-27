package kz.suneclipse.monitor_sensors.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("°C"),
    PERCENT("%");

    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    @JsonValue
    public String getUnit() {
        return unit;
    }

    @JsonCreator
    public static Unit fromValue(String value) {
        for (Unit unit : values()) {
            if (unit.unit.equalsIgnoreCase(value.trim())) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown unit: " + value);
    }
}
