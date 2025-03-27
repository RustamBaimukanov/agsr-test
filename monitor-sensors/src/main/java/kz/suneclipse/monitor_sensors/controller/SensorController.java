package kz.suneclipse.monitor_sensors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kz.suneclipse.monitor_sensors.controller.dto.CreateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.dto.SensorResponse;
import kz.suneclipse.monitor_sensors.controller.dto.UpdateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.mapper.SensorMapper;
import kz.suneclipse.monitor_sensors.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/sensors")
@Tag(name = "Датчики.", description = "API датчиков.")
@RestController
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @Operation(summary = "Добавить новый датчик.",
            description = "Добавляет новый датчик в бд.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Датчик создан."),
                    @ApiResponse(responseCode = "401", description = "Пользователь не авторизован."),
                    @ApiResponse(responseCode = "403", description = "Нет доступа."),
                    @ApiResponse(responseCode = "400", description = "Данные не прошли валидацию.")
            }
    )
    @PostMapping
    @PreAuthorize("hasRole('Administrator')")
    public ResponseEntity<SensorResponse> createSensor(@Valid @RequestBody CreateSensorRequest sensor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(SensorMapper.mapToSensorResponse(sensorService.createSensor(sensor)));
    }

    @Operation(summary = "Обновить датчик.",
            description = "Обновляет датчик по id.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Датчик обновлен."),
                    @ApiResponse(responseCode = "401", description = "Пользователь не авторизован."),
                    @ApiResponse(responseCode = "403", description = "Нет доступа."),
                    @ApiResponse(responseCode = "400", description = "Данные не прошли валидацию.")
            }
    )

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('Administrator')")
    public ResponseEntity<SensorResponse> updateSensor(@PathVariable(name = "id") Integer id,
                                                       @Valid @RequestBody UpdateSensorRequest sensor) {
        return ResponseEntity.ok(SensorMapper.mapToSensorResponse(sensorService.updateSensor(id, sensor)));
    }

    @PreAuthorize("hasAnyRole('Administrator', 'Viewer')")
    @Operation(summary = "Поиск датчиков по имени или модели",
            description = "Получить список датчиков по фильтру или весь список.",
            responses = @ApiResponse(responseCode = "200", description = "Список датчиков получен.")
    )
    @GetMapping
    public ResponseEntity<List<SensorResponse>> getSensors(@RequestParam(name = "filter", required = false) String filter) {
        return ResponseEntity.ok(SensorMapper.mapToSensorResponse(sensorService.getSensors(filter)));
    }

    @PreAuthorize("hasRole('Administrator')")
    @Operation(summary = "Удалить датчик.",
            description = "Удалить датчик по id.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Датчик удален."),
                    @ApiResponse(responseCode = "401", description = "Пользователь не авторизован."),
                    @ApiResponse(responseCode = "403", description = "Нет доступа."),
                    @ApiResponse(responseCode = "400", description = "Удаляемый датчик не обнаружен.")
            }
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeSensor(@PathVariable(name = "id") Integer id) {
        sensorService.removeSensor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Датчик удален.");
    }

}
