package com.weather.forecast.model.response;

public class WeatherModel {
    private double temp;
    private double tempMin;
    private double tempKf;
    private double humidity;
    private long pressure;
    private double feels_like;
    private double tempMax;

    public double getTemp() {
        return temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempKf() {
        return tempKf;
    }

    public double getHumidity() {
        return humidity;
    }

    public long getPressure() {
        return pressure;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public double getTempMax() {
        return tempMax;
    }
}
