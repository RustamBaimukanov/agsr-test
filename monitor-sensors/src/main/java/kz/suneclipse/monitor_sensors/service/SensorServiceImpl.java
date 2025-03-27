package kz.suneclipse.monitor_sensors.service;

import jakarta.transaction.Transactional;
import kz.suneclipse.monitor_sensors.controller.SensorController;
import kz.suneclipse.monitor_sensors.controller.dto.CreateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.dto.SensorResponse;
import kz.suneclipse.monitor_sensors.controller.dto.UpdateSensorRequest;
import kz.suneclipse.monitor_sensors.controller.mapper.SensorMapper;
import kz.suneclipse.monitor_sensors.exceptions.custom_exception.ObjectNotFound;
import kz.suneclipse.monitor_sensors.model.Sensor;
import kz.suneclipse.monitor_sensors.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensorServiceImpl implements SensorService{

    private final SensorRepository sensorRepository;

    @Override
    @Transactional
    public Sensor createSensor(CreateSensorRequest createSensorRequest) {
        Sensor sensor = SensorMapper.mapToSensor(createSensorRequest);
        sensorRepository.save(sensor);
        return sensor;
    }

    @Override
    @Transactional
    public Sensor updateSensor(Integer id, UpdateSensorRequest updateSensorRequest) {
        Sensor sensor = SensorMapper.mapToSensor(id, updateSensorRequest);
        sensorRepository.save(sensor);
        return sensor;
    }

    @Override
    public List<Sensor> getSensors(String filter) {
        if (filter == null || filter.trim().isEmpty()) return sensorRepository.findAll();
        return sensorRepository.findAllByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrderByUpdatedDate(filter, filter);
    }

    @Override
    @Transactional
    public void removeSensor(Integer id) {
        sensorRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Датчик не найден."));
        sensorRepository.deleteById(id);
    }
}
