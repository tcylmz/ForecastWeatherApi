package com.weather.forecast;

import com.weather.forecast.model.response.WeatherForecastResponse;
import com.weather.forecast.service.WeatherForecastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherForecastApiApplicationTests {

    @Test
    public void main() {
        WeatherForecastApplication.main(new String[] {});
    }

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Test
    public void getWeatherForecastByCityNameTest() {
        WeatherForecastResponse weatherForecastResponse = weatherForecastService.getForecastByCityName("London");
        Assertions.assertNotNull(weatherForecastResponse);
        Assertions.assertTrue(weatherForecastResponse.getMaxTempMax() > 0); //It will change constantly so, should be bigger than 0
    }
}
