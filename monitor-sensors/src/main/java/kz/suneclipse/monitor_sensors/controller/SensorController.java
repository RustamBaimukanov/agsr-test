package kz.suneclipse.monitor_sensors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kz.suneclipse.monitor_sensors.controller.dto.CreateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.dto.SensorResponse;
import kz.suneclipse.monitor_sensors.controller.dto.UpdateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.filter.SensorFilter;
import kz.suneclipse.monitor_sensors.controller.mapper.SensorMapper;
import kz.suneclipse.monitor_sensors.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/sensors")
@Tag(name = "Датчики.", description = "API датчиков.")
@RestController
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    //TODO добавить детальное описание вроде статусов
    @Operation(summary = "Добавить новый датчик.",
            description = "Добавляет новый датчик в бд."
    )
    @PostMapping
    public ResponseEntity<SensorResponse> createSensor(@Valid @RequestBody CreateSensorRequest sensor) {
        return ResponseEntity.ok(SensorMapper.mapToSensorResponse(sensorService.createSensor(sensor)));
    }

    @Operation(summary = "Обновить датчик.",
            description = "Обновляет датчик по id."
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<SensorResponse> updateSensor(@PathVariable Integer id,
                                                       @Valid @RequestBody UpdateSensorRequest sensor) {
        return ResponseEntity.ok(SensorMapper.mapToSensorResponse(sensorService.updateSensor(id, sensor)));
    }

    @Operation(summary = "Поиск датчиков по имени или модели")
    @GetMapping
    public ResponseEntity<List<SensorResponse>> getSensors(SensorFilter filter) {
        return ResponseEntity.ok(SensorMapper.mapToSensorResponse(sensorService.getSensors(filter)));
    }

}
