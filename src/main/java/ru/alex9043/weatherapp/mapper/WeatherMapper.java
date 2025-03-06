package ru.alex9043.weatherapp.mapper;

import ru.alex9043.weatherapp.dto.WeatherResponse;
import ru.alex9043.weatherapp.model.Weather;

import java.time.LocalDateTime;

public class WeatherMapper {
    public static Weather toEntity(WeatherResponse response) {
        Weather weather = new Weather();
        weather.setDate(LocalDateTime.now());
        weather.setLongitude(response.coord().lon());
        weather.setLatitude(response.coord().lat());
        weather.setDescription(response.weather().get(0).description());
        weather.setMain(response.weather().get(0).main());
        weather.setTemp(response.main().temp());
        weather.setFeelsLike(response.main().feels_like());
        return weather;
    }
}
