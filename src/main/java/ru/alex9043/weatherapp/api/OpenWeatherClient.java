package ru.alex9043.weatherapp.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenWeatherClient {
    private final RestTemplate restTemplate;
    @Value("${openweather.api.key}")
    private String apiKey;

    public String getWeather(double latitude, double longitude) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s", latitude, longitude, apiKey);
        log.info("url - {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}
