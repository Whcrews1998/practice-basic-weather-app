package com.whcrews.weather_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whcrews.weather_app.model.Location;
import com.whcrews.weather_app.model.Weather;

@RestController
public class WeatherController {
    private Location atlanta = new Location("Atlanta", List.of(new Weather("Tuesday", "87F", "Cloudy"),
            new Weather("Wednesday", "67F", "Thunderstorms"), new Weather("Thursday", "80F", "Sunny"),
            new Weather("Friday", "79F", "Sunny"), new Weather("Saturday", "61F", "Sunny")));

    private Location birmingham = new Location("Birmingham", List.of(new Weather("Tuesday", "33F", "Cloudy"),
            new Weather("Wednesday", "28F", "Snowy"), new Weather("Thursday", "18F", "Snow Storm"),
            new Weather("Friday", "-32F", "Quiet"), new Weather("Saturday", "-9999F", "Apocalypse")));

    private Location montgomery = new Location("Montgomery", List.of(new Weather("Tuesday", "70F", "Sunny"),
            new Weather("Wednesday", "73F", "Partially Cloudy"), new Weather("Thursday", "70F", "Cloudy"),
            new Weather("Friday", "66F", "Rainy"), new Weather("Saturday", "72F", "Sunny")));

    private Location[] locations = { atlanta, birmingham, montgomery };

    @GetMapping("/")
    public Location testEndpoint() {
        Location location = new Location("Atlanta", List.of(new Weather("Tuesday", "87F", "Cloudy"),
                new Weather("Wednesday", "67F", "Thunderstorms"), new Weather("Thursday", "80F", "Sunny"),
                new Weather("Friday", "79F", "Sunny"), new Weather("Saturday", "61F", "Sunny")));
        return location;
    }

    @GetMapping("/forecast")
    public ResponseEntity<Location> locationForecast(@RequestParam String location) {
        for (Location val : locations) {
            // Location found.
            if (val.getName().equalsIgnoreCase(location))
                return ResponseEntity.ok(val);
        }

        // Location not found.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
