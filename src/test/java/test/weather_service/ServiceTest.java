package test.weather_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import test.weather_service.service.WeatherHistoryService;
import static org.aspectj.bridge.MessageUtil.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ServiceTest {
    @Autowired
    WeatherHistoryService weatherHistoryService;

    @Test
    void findOnYandexTest() {
        String test;
        try {
            test = weatherHistoryService.getFromYandex();
            assertTrue(test.contains("−") || test.contains("+"));
        } catch (IOException e) {
            fail("Something is wrong with yandex.ru");
        }
    }
}
