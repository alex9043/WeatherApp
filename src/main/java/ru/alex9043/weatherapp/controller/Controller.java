package ru.alex9043.weatherapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex9043.weatherapp.api.OpenWeatherClient;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final OpenWeatherClient client;

    @GetMapping("/")
    public String getWeather() {
        return client.getWeather(44.34, 10.99);
    }
}
