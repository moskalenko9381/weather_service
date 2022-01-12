package test.weather_service.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.weather_service.model.WeatherHistory;

import java.time.LocalDate;

@Repository
public interface WeatherHistoryRepository extends CrudRepository<WeatherHistory, LocalDate> {
}
