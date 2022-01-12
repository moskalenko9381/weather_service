package test.weather_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "weather_history")
@AllArgsConstructor
@NoArgsConstructor
public class WeatherHistory {
    @Column(name = "weather_date")
    @Basic
    @Id
    private java.time.LocalDate weatherDate;

    @Column(name = "weather_value")
    private String weatherValue;
}
