package kz.suneclipse.monitor_sensors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.suneclipse.monitor_sensors.controller.dto.SensorResponse;
import kz.suneclipse.monitor_sensors.controller.dto.StatsResponse;
import kz.suneclipse.monitor_sensors.controller.mapper.SensorMapper;
import kz.suneclipse.monitor_sensors.model.Type;
import kz.suneclipse.monitor_sensors.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/stats")
@Tag(name = "Статистика по датчикам.", description = "Открытое API статистики по датчикам.")
@RestController
@RequiredArgsConstructor
public class StatsController {

    private final SensorService sensorService;

    @Operation(summary = "Количество датчиков",
            description = "Получить количество датчиков в целом и по типам.",
            responses = @ApiResponse(responseCode = "200", description = "Количество получено.")
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatsResponse> getSensorCount() {
        return ResponseEntity.ok(sensorService.getSensorsCount());
    }
}
