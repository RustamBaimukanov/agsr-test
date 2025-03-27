package kz.suneclipse.monitor_sensors.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "sensors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 30, message = "Длина названия вне допустимых рамок.")
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 15, message = "Длина модели выше допустимых рамок.")
    @Column(name = "model")
    private String model;

    @NotNull
    @Positive(message = "Отрицательные значения недопустимы")
    @Column(name = "range_from")
    private Integer rangeFrom;

    @NotNull
    @Positive(message = "Отрицательные значения недопустимы")
    @Column(name = "range_to")
    private Integer rangeTo;

    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "unit")
    private Unit unit;

    @Size(max = 40, message = "Длина местоположения выше допустимых рамок.")
    @Column(name = "location")
    private String location;

    @Size(max = 200, message = "Слишком длинное описание.")
    @Column(name = "description")
    private String description;
}
