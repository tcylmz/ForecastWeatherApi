package com.weather.forecast.util;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ApiExceptionHandlerTests {
    private final ApiExceptionHandler globalExceptionHandler = new ApiExceptionHandler();

    @Test
    void handleWeatherServiceException_ReturnsInternalServerError() {
        // Given a WeatherServiceException
        WeatherServiceException ex = new WeatherServiceException("Weather service error");

        // When handling the exception
        ResponseEntity<String> responseEntity = globalExceptionHandler.handleWeatherServiceException(ex);

        // Then the response status should be INTERNAL_SERVER_ERROR (500) and contain the exception message
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Weather service error", responseEntity.getBody());
    }

    @Test
    void handleNotFoundException_ReturnsNotFound() {
        // Given a NotFoundException
        NotFoundException ex = new NotFoundException("Resource not found");

        // When handling the exception
        ResponseEntity<String> responseEntity = globalExceptionHandler.handleNotFoundException(ex);

        // Then the response status should be NOT_FOUND (404) and contain the exception message
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Resource not found", responseEntity.getBody());
    }

    @Test
    void handleUnauthorizedException_ReturnsUnauthorized() {
        // Given an UnauthorizedException
        UnauthorizedException ex = new UnauthorizedException("Unauthorized access");

        // When handling the exception
        ResponseEntity<String> responseEntity = globalExceptionHandler.handleUnauthorizedException(ex);

        // Then the response status should be UNAUTHORIZED (401) and contain the exception message
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertEquals("Unauthorized access", responseEntity.getBody());
    }
}
