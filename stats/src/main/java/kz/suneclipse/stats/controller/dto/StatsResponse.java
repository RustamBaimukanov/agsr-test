package kz.suneclipse.stats.controller.dto;

import java.util.List;

public record StatsResponse(Long count, List<SensorTypeCount> countByType) {
}
