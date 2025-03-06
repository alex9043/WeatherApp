package ru.alex9043.weatherapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alex9043.weatherapp.api.OpenWeatherClient;
import ru.alex9043.weatherapp.dto.WeatherResponse;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final OpenWeatherClient client;

    public WeatherResponse getWeather(Double latitude, Double longitude) {
        return client.getWeather(latitude, longitude);
    }

    public String getImagePath(String main) {
        return switch (main) {
            case "Clear" -> "img/clear.webp";
            case "Clouds" -> "img/clouds.webp";
            case "Rain" -> "img/rain.webp";
            case "Snow" -> "img/snow.webp";
            case "Thunderstorm" -> "img/thunderstorm.webp";
            case "Mist" -> "img/mist.webp";
            default -> "img/base.webp";
        };
    }
}
