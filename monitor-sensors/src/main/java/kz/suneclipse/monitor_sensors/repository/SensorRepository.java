package kz.suneclipse.monitor_sensors.repository;

import kz.suneclipse.monitor_sensors.model.Sensor;
import kz.suneclipse.monitor_sensors.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    List<Sensor> findAllByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrderByUpdatedDate(String name, String model);

    Long countByType(Type type);
}
