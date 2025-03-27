package kz.suneclipse.stats.controller.dto;


import kz.suneclipse.stats.model.Type;

public record SensorTypeCount(Type type, Long count) {
}
