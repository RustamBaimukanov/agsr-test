package kz.suneclipse.monitor_sensors.controller.mapper;

import kz.suneclipse.monitor_sensors.controller.dto.CreateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.dto.Range;
import kz.suneclipse.monitor_sensors.controller.dto.SensorResponse;
import kz.suneclipse.monitor_sensors.controller.dto.UpdateSensorRequest;
import kz.suneclipse.monitor_sensors.model.Sensor;

import java.util.List;
import java.util.stream.Stream;

public class SensorMapper {

    public static Sensor mapToSensor(CreateSensorRequest createSensorRequest) {
        return Sensor.builder()
                .name(createSensorRequest.name())
                .model(createSensorRequest.model())
                .type(createSensorRequest.type())
                .unit(createSensorRequest.unit())
                .rangeFrom(createSensorRequest.range().from())
                .rangeTo(createSensorRequest.range().to())
                .location(createSensorRequest.location())
                .description(createSensorRequest.description())
                .build();
    }

    public static Sensor mapToSensor(Integer id, UpdateSensorRequest updateSensorRequest) {
        return Sensor.builder()
                .id(id)
                .name(updateSensorRequest.name())
                .model(updateSensorRequest.model())
                .type(updateSensorRequest.type())
                .unit(updateSensorRequest.unit())
                .rangeFrom(updateSensorRequest.range().from())
                .rangeTo(updateSensorRequest.range().to())
                .location(updateSensorRequest.location())
                .description(updateSensorRequest.description())
                .build();
    }

    public static SensorResponse mapToSensorResponse(Sensor sensor) {
        return SensorResponse.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .model(sensor.getModel())
                .type(sensor.getType())
                .unit(sensor.getUnit())
                .range(Range.builder()
                        .from(sensor.getRangeFrom())
                        .to(sensor.getRangeTo())
                        .build())
                .location(sensor.getLocation())
                .description(sensor.getDescription())
                .build();
    }

    public static List<SensorResponse> mapToSensorResponse(List<Sensor> sensor) {
        return sensor.stream().map(SensorMapper::mapToSensorResponse).toList();
    }
}
