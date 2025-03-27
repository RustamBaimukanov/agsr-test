package kz.suneclipse.monitor_sensors.controller.dto;

import java.util.List;

public record StatsResponse(Long count, List<SensorTypeCount> countByType) {
}
