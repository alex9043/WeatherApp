package ru.alex9043.weatherapp.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.alex9043.weatherapp.dto.WeatherResponse;

@Component
@RequiredArgsConstructor
public class OpenWeatherClient {
    private final RestTemplate restTemplate;
    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherResponse getWeather(double latitude, double longitude) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&lang=ru&units=metric", latitude, longitude, apiKey);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
