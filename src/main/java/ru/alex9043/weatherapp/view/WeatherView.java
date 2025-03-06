package ru.alex9043.weatherapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.alex9043.weatherapp.api.OpenWeatherClient;
import ru.alex9043.weatherapp.dto.WeatherResponse;

@Route("/")
public class WeatherView extends VerticalLayout {
    private final OpenWeatherClient client;
    private final TextField latField = new TextField("Широта");
    private final TextField lonField = new TextField("Долгота");
    private final Button showButton = new Button("Показать погоду!");
    private final Paragraph p = new Paragraph();

    public WeatherView(OpenWeatherClient client) {
        this.client = client;
        setupUi();
    }

    private void setupUi() {
        showButton.addClickListener(event -> {
            try {
                double lat = Double.parseDouble(latField.getValue());
                double lon = Double.parseDouble(lonField.getValue());
                WeatherResponse response = client.getWeather(lat, lon);
                p.setText(response.weather().get(0).description() + " " + response.main().temp() + " " + response.main().feels_like());
            } catch (NumberFormatException e) {
                Notification.show("Введите корректные числа");
            }
        });

        add(showButton, latField, lonField, p);
    }
}
