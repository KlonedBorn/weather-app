package edu.uwi.soscai.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.uwi.soscai.WeatherApp;
import edu.uwi.soscai.component.DayForecastCell;
import edu.uwi.soscai.model.DayForecast;
import edu.uwi.soscai.model.HourForecast;
import edu.uwi.soscai.util.ForecastFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AppController {
    @FXML
    private ListView<DayForecast> dayForecast_lv;

    @FXML
    private HBox hourForecast_hbox;

    @FXML
    private Label locationError_lbl;

    @FXML
    private TextField location_tf;

    @FXML
    private Label version_lbl;

    @FXML
    private Label lastUpdate_lbl;

    @FXML
    void getWeatherDataByLocation(ActionEvent event) {

    }

    @FXML
    void initialize() {
        version_lbl.setVisible(false);
        List<HourForecast> hourlyForecasts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HourForecast hf = ForecastFactory.getRandomHourForecast();
            hourlyForecasts.add(hf);
            hourForecast_hbox.getChildren().add(hf.getCard());
            HBox.setHgrow(hf.getCard(), Priority.ALWAYS);
        }
        dayForecast_lv.setCellFactory(cf -> new DayForecastCell());
        for (int i = 0; i < 7; i++) {
            DayForecast df = ForecastFactory.getRandomDayForecast();
            dayForecast_lv.getItems().add(df);
        }
        version_lbl.setText(WeatherApp.getProperties().getProperty("app.version"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        lastUpdate_lbl.setText("(Last update: " + formatter.format(LocalTime.now()) + ")");
    }
}