package kz.suneclipse.monitor_sensors.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kz.suneclipse.monitor_sensors.model.Type;
import kz.suneclipse.monitor_sensors.model.Unit;

public record UpdateSensorRequest(
        @NotNull
        @Size(min = 3, max = 30, message = "Длина названия вне допустимых рамок.")
        String name,

        @NotNull
        @Size(max = 15, message = "Длина модели выше допустимых рамок.")
        String model,

        @Valid
        Range range,

        @NotNull
        @Enumerated(EnumType.STRING)
        Type type,

        @Enumerated(EnumType.STRING)
        Unit unit,

        @Size(max = 40, message = "Длина местоположения выше допустимых рамок.")
        String location,

        @Size(max = 200, message = "Слишком длинное описание.")
        String description) {


}
