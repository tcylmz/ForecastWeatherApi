package com.weather.forecast.model.response;

public class WeatherWithTime {
    private long dt;
    private String dt_txt;
    private WeatherModel main;

    public long getDt() {
        return dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }


    public WeatherModel getMain() {
        return main;
    }
}
