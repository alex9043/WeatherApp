package ru.alex9043.weatherapp.dto;

import java.util.List;

public record WeatherResponse(String name, List<Weather> weather, Main main) {
    public record Weather(String main, String description) {
    }

    public record Main(Double temp, Double feels_like) {
    }
}
