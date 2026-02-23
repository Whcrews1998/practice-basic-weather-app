package com.whcrews.weather_app.model;

import java.util.List;

public class Location {
    private String name;
    private List<Weather> forecast;

    public Location(String name, List<Weather> forecastList) {
        this.name = name;
        this.forecast = forecastList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getForecast() {
        return forecast;
    }

    public void setForecast(List<Weather> forecast) {
        this.forecast = forecast;
    }

}
