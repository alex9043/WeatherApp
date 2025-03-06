package ru.alex9043.weatherapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alex9043.weatherapp.api.OpenWeatherClient;
import ru.alex9043.weatherapp.mapper.WeatherMapper;
import ru.alex9043.weatherapp.model.Weather;
import ru.alex9043.weatherapp.repository.WeatherRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {
    private final OpenWeatherClient client;
    private final WeatherRepository repository;

    public Weather getWeather(Double latitude, Double longitude) {
        return repository.save(WeatherMapper.toEntity(client.getWeather(latitude, longitude)));
    }

    public String getImagePath(String main) {
        log.info("main - {}", main);
        return switch (main) {
            case "Clear" -> "img/clear.webp";
            case "Clouds" -> "img/clouds.webp";
            case "Drizzle", "Rain" -> "img/rain.webp";
            case "Snow" -> "img/snow.webp";
            case "Thunderstorm" -> "img/thunderstorm.webp";
            case "Mist" -> "img/mist.webp";
            default -> "img/base.webp";
        };
    }
}
