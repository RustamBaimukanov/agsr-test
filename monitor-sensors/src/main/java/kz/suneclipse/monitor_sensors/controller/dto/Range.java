package kz.suneclipse.monitor_sensors.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record Range(
        @NotNull
        @Positive(message = "Отрицательные значения недопустимы")
        Integer from,

        @NotNull
        @Positive(message = "Отрицательные значения недопустимы")
        Integer to) {
}
