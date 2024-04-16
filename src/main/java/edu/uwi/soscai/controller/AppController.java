package edu.uwi.soscai.controller;

import java.util.ArrayList;
import java.util.List;

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
    void getWeatherDataByLocation(ActionEvent event) {

    }

    @FXML
    void initialize() {
        showDemo();
    }

    private void showDemo() {
        List<HourForecast> hourlyForecasts = new ArrayList<>();
        hourForecast_hbox.getChildren().clear();
        dayForecast_lv.getItems().clear();
        for (int i = 0; i < 6; i++) {
            HourForecast hf = ForecastFactory.getRandomHourForecast();
            hourlyForecasts.add(hf);
            hourForecast_hbox.getChildren().add(hf.getCard());
            HBox.setHgrow(hf.getCard(), Priority.ALWAYS);
        }
        dayForecast_lv.setCellFactory(cf -> new DayForecastCell());
        for (int i = 0; i < 14; i++) {
            DayForecast df = ForecastFactory.getRandomDayForecast();
            dayForecast_lv.getItems().add(df);
        }
    }
}