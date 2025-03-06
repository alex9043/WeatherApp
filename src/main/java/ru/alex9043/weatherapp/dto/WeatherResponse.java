package ru.alex9043.weatherapp.dto;

import java.util.List;

public record WeatherResponse(List<Weather> weather, Main main, Coord coord) {
    public record Weather(String main, String description) {
    }

    public record Main(Double temp, Double feels_like) {
    }

    public record Coord(Double lon, Double lat) {
    }
}
