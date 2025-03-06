package ru.alex9043.weatherapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "temp")
    private Double temp;

    @Column(name = "feels_like")
    private Double feelsLike;

}