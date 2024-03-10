package com.weather.forecast.controller;

import com.weather.forecast.model.request.WeatherForecastRequest;
import com.weather.forecast.model.response.WeatherForecastResponse;
import com.weather.forecast.service.WeatherForecastService;
import com.weather.forecast.util.NotFoundException;
import com.weather.forecast.util.UnauthorizedException;
import com.weather.forecast.util.WeatherServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherForecastController {
    private final WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherForecastController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @PostMapping(path = "/by-cityname")
    public ResponseEntity<?> getForecastByCityName(@RequestBody WeatherForecastRequest request) {
        WeatherForecastResponse weatherForecastResponse = weatherForecastService.getForecastByCityName(request.getCityName());
        try {
            if (weatherForecastResponse != null) {
                return ResponseEntity.ok(weatherForecastResponse);
            }
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (UnauthorizedException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (WeatherServiceException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return new ResponseEntity<String>("Unexpected request",HttpStatus.BAD_REQUEST);
    }
}
