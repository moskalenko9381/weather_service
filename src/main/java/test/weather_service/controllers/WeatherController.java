package test.weather_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.weather_service.service.WeatherHistoryService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherHistoryService weatherHistoryService;

    @GetMapping
    public String read() {
        return weatherHistoryService.findInDatabase() != null ? weatherHistoryService.findInDatabase()
                : "Mistake in Yandex page!";
    }
}
