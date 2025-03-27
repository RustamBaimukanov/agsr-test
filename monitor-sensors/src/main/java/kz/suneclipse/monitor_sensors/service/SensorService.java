package kz.suneclipse.monitor_sensors.service;

import kz.suneclipse.monitor_sensors.controller.dto.CreateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.dto.SensorResponse;
import kz.suneclipse.monitor_sensors.controller.dto.StatsResponse;
import kz.suneclipse.monitor_sensors.controller.dto.UpdateSensorRequest;
import kz.suneclipse.monitor_sensors.model.Sensor;
import kz.suneclipse.monitor_sensors.model.Type;

import java.util.List;

public interface SensorService {

    Sensor createSensor(CreateSensorRequest createSensorRequest);

    Sensor updateSensor(Integer id, UpdateSensorRequest updateSensorRequest);

    List<Sensor> getSensors(String filter);

    void removeSensor(Integer id);

    StatsResponse getSensorsCount();
}
