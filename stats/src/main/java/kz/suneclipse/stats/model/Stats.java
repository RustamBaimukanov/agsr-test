package kz.suneclipse.stats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "count")
    private Long count;

    @Column(name = "count_by_pressure")
    private Long countByPressure;

    @Column(name = "count_by_voltage")
    private Long countByVoltage;

    @Column(name = "count_by_humidity")
    private Long countByHumidity;

    @Column(name = "count_by_temperature")
    private Long countByTemperature;

    @Column(name = "download_date")
    private LocalDate downloadDate;

    @PrePersist
    protected void onCreate() {
        this.downloadDate = LocalDate.now();
    }
}
