package com.whcrews.weather_app.model;

public class Weather {
    private String dayOfWeek;
    private String temperature;
    private String weatherCondition;

    public Weather(String dayOfWeek, String temp, String condition) {
        this.dayOfWeek = dayOfWeek;
        this.temperature = temp;
        this.weatherCondition = condition;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

}
