package ru.alex9043.weatherapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.alex9043.weatherapp.dto.WeatherResponse;
import ru.alex9043.weatherapp.service.WeatherService;

@Route("/")
@CssImport("/styles.css")
public class WeatherView extends VerticalLayout {
    private final WeatherService service;
    private final Div container = new Div();
    private final Div dataContainer = new Div();
    private final Div historyContainer = new Div();
    private final Div fieldsContainer = new Div();
    private final TextField latField = new TextField("Широта");
    private final TextField lonField = new TextField("Долгота");
    private final Button showButton = new Button("Показать погоду!");
    private final H2 header = new H2();
    private final Paragraph p = new Paragraph();
    private final Image image = new Image();

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
                p.setText(response.main().temp().intValue() + " градусов, ощущается как " + response.main().feels_like().intValue());

                image.setSrc(service.getImagePath(response.weather().get(0).main()));
                image.setAlt("Изображение енота");
            } catch (NumberFormatException e) {
                Notification.show("Введите корректные числа");
            }
        });
        lonField.addClassName("lon-field");

        image.setClassName("raccoon-image");

        p.setClassName("weather-text");

        fieldsContainer.add(latField, lonField);
        fieldsContainer.addClassName("fields-container");

        dataContainer.add(fieldsContainer, showButton, header, p, image);
        dataContainer.addClassName("data-container");

        container.add(dataContainer, historyContainer);
        container.addClassName("main-container");

        add(container);
    }
}
