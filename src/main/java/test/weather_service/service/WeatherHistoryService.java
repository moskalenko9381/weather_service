package test.weather_service.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.weather_service.model.WeatherHistory;
import test.weather_service.repo.WeatherHistoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class WeatherHistoryService {

    @Autowired
    private WeatherHistoryRepository weatherHistoryRepository;

    public String getFromYandex() throws IOException {
        URL url = new URL(Reference.getUrl());
        String line;
        String key = "'weather__temp'>";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            while ((line = br.readLine()) != null) {
                if (line.contains(key)) {
                    line = line.substring(line.indexOf(key));
                    int indexDegree = line.indexOf("°");
                    line = line.substring(line.indexOf(key) + key.length(), indexDegree + 1);
                    break;
                }
            }
        }
        log.debug("Temperature today: " + line);
        return line;
    }

    public String findInDatabase() {
        Optional<WeatherHistory> weatherToday = weatherHistoryRepository.findById(LocalDate.now());
        String temp;
        if (weatherToday.isEmpty()) {
            try {
                temp = getFromYandex();
            } catch (IOException e) {
                log.error("Oops! Mistake while reading yandex.ru");
                return null;
            }
            WeatherHistory newHistory = new WeatherHistory(LocalDate.now(), temp);
            weatherHistoryRepository.save(newHistory);
            return newHistory.getWeatherValue();
        }
        return weatherToday.get().getWeatherValue();
    }

    public String getFromYandexUsingJsoup() throws IOException {
        Document doc = Jsoup.connect(Reference.getUrl()).get();
        Elements temp = doc.select(".weather__temp");
        return temp.get(0).ownText();
    }
}
