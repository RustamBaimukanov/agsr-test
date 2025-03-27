package kz.suneclipse.monitor_sensors.controller.dto;

import kz.suneclipse.monitor_sensors.model.Type;

public record SensorTypeCount(Type type, Long count) {
}
