package ru.alex9043.weatherapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex9043.weatherapp.model.Weather;

import java.util.UUID;

public interface WeatherRepository extends JpaRepository<Weather, UUID> {
}