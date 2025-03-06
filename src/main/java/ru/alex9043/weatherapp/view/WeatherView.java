package ru.alex9043.weatherapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.alex9043.weatherapp.dto.WeatherResponse;
import ru.alex9043.weatherapp.service.WeatherService;

@Route("/")
public class WeatherView extends VerticalLayout {
    private final WeatherService service;
    private final TextField latField = new TextField("Широта");
    private final TextField lonField = new TextField("Долгота");
    private final Button showButton = new Button("Показать погоду!");
    private final H2 header = new H2();
    private final Paragraph p = new Paragraph();

    public WeatherView(WeatherService service) {
        this.service = service;
        setupUi();
    }

    private void setupUi() {
        showButton.addClickListener(event -> {
            try {
                double lat = Double.parseDouble(latField.getValue());
                double lon = Double.parseDouble(lonField.getValue());
                WeatherResponse response = service.getWeather(lat, lon);
                header.setText(response.weather().get(0).description());
                p.setText(response.main().temp() + " градусов, ощущается как " + response.main().feels_like());
            } catch (NumberFormatException e) {
                Notification.show("Введите корректные числа");
            }
        });

        add(latField, lonField, showButton, header, p);
    }
}
