package com.weather.forecast.model.response;

public class WeatherForecastResponse {

    private double maxFeelsLike;
    private double maxHumidity;
    private double maxTempMax;
    public double getMaxFeelsLike() {
        return maxFeelsLike;
    }

    public void setMaxFeelsLike(double maxFeelsLike) {
        this.maxFeelsLike = maxFeelsLike;
    }

    public double getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public double getMaxTempMax() {
        return maxTempMax;
    }

    public void setMaxTempMax(double maxTempMax) {
        this.maxTempMax = maxTempMax;
    }
}
