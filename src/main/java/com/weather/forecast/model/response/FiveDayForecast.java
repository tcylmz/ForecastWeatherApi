// FiveDayForecastResponse.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.weather.forecast.model.response;

import java.util.List;

public class FiveDayForecast {
    private String cod;
    private long message;
    private List<WeatherWithTime> list;

    public String getCod() {
        return cod;
    }

    public long getMessage() {
        return message;
    }

    public List<WeatherWithTime> getList() {
        return list;
    }
}
