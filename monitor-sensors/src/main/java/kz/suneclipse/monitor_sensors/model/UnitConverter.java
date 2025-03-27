package kz.suneclipse.monitor_sensors.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit, String> {

    @Override
    public String convertToDatabaseColumn(Unit unit) {
        if (unit == null) {
            return null;
        }
        return unit.getUnit();
    }

    @Override
    public Unit convertToEntityAttribute(String unit) {
        if (unit == null) {
            return null;
        }

        return Stream.of(Unit.values())
                .filter(c -> c.getUnit().equals(unit))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
