package com.weather.forecast.service;

import com.weather.forecast.model.response.FiveDayForecast;
import com.weather.forecast.model.response.WeatherWithTime;
import com.weather.forecast.util.DateUtil;
import com.weather.forecast.util.ReceiveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import com.weather.forecast.model.response.WeatherForecastResponse;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class WeatherForecastService {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.baseurl}")
    private String baseUrl;

    @Value("${openweather.timeout}")
    private int timeOut;
    private final ReceiveUtil receiveUtil;

    @Autowired
    public WeatherForecastService(ReceiveUtil receiveUtil) {
        this.receiveUtil = receiveUtil;
    }

    public WeatherForecastResponse getForecastByCityName(String cityName) {
        String url = getRequestUrl() + "&q=" + cityName;
        return getWeather(url);
    }
    public WeatherForecastResponse getWeather(String url) {
        WeatherForecastResponse weatherForecastResponse = new WeatherForecastResponse();
        Mono<FiveDayForecast> weatherMono = fetchWeather(url);
        //gets response
        FiveDayForecast response  = weatherMono.block(Duration.ofSeconds(timeOut));

        Double maxHumidity = Double.MIN_VALUE;
        Double maxFeelLike = Double.MIN_VALUE;
        Double maxTempMax = Double.MIN_VALUE;
        if (response != null && response.getList() != null) {
            for (WeatherWithTime item: response.getList()) {
                LocalDateTime weatherTime = DateUtil.getAsDate(item.getDt_txt());

                if (DateUtil.isDayLaterFromCurrentDay(weatherTime, 2)) {
                    if (maxHumidity < item.getMain().getHumidity()) {
                        maxHumidity = item.getMain().getHumidity();
                    }
                    if (maxFeelLike < item.getMain().getFeels_like()) {
                        maxFeelLike = item.getMain().getFeels_like();
                    }
                    if (maxTempMax < item.getMain().getTempMax()) {
                        maxTempMax = item.getMain().getTempMax();
                    }
                }
            }

            weatherForecastResponse.setMaxFeelsLike(maxFeelLike);
            weatherForecastResponse.setMaxHumidity(maxHumidity);
            weatherForecastResponse.setMaxTempMax(maxHumidity);
        }
        return weatherForecastResponse;
    }

    public Mono<FiveDayForecast> fetchWeather(String url) {
        ParameterizedTypeReference<FiveDayForecast> responseType = new ParameterizedTypeReference<FiveDayForecast>() {};
        return receiveUtil.fetchData(url, responseType);
    }

    private String getRequestUrl() {
        return baseUrl + "?appid=" + apiKey;
    }
}

