package kz.suneclipse.monitor_sensors.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import kz.suneclipse.monitor_sensors.model.Type;
import kz.suneclipse.monitor_sensors.model.Unit;
import lombok.Builder;

@Builder
public record SensorResponse(
        Integer id,
        String name,
        String model,
        Range range,
        Type type,
        Unit unit,
        String location,
        String description) {
}
