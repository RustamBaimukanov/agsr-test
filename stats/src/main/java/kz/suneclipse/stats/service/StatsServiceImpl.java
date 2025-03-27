package kz.suneclipse.stats.service;

import jakarta.transaction.Transactional;
import kz.suneclipse.stats.controller.dto.SensorTypeCount;
import kz.suneclipse.stats.controller.dto.StatsResponse;
import kz.suneclipse.stats.model.Stats;
import kz.suneclipse.stats.model.Type;
import kz.suneclipse.stats.repository.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService{

    private final RestTemplate restTemplate = new RestTemplate();

    private final StatsRepository statsRepository;

    @Scheduled(cron = "0 0 2 * * ?")
    @Transactional
    @Override
    public void retrieveData() {
        String URL = "http://localhost:8080/api/stats";
        System.out.println("TEST");
        StatsResponse response = restTemplate.exchange(URL, HttpMethod.GET, null, StatsResponse.class).getBody();
        Stats stats = Stats.builder()
                .count(response.count())
                .countByHumidity(response.countByType()
                        .stream()
                        .filter(typeCount-> typeCount.type()
                                .equals(Type.HUMIDITY)).findFirst().map(SensorTypeCount::count)
                        .orElse(0L))
                .countByPressure(response.countByType()
                        .stream()
                        .filter(typeCount-> typeCount.type()
                                .equals(Type.PRESSURE)).findFirst().map(SensorTypeCount::count)
                        .orElse(0L))
                .countByVoltage(response.countByType()
                        .stream()
                        .filter(typeCount-> typeCount.type()
                                .equals(Type.VOLTAGE)).findFirst().map(SensorTypeCount::count)
                        .orElse(0L))
                .countByTemperature(response.countByType()
                        .stream()
                        .filter(typeCount-> typeCount.type()
                                .equals(Type.TEMPERATURE)).findFirst().map(SensorTypeCount::count)
                        .orElse(0L))
                .build();
        statsRepository.save(stats);

    }
}
