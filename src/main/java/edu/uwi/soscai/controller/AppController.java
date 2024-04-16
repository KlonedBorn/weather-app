package edu.uwi.soscai.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.uwi.soscai.component.DayForecastCell;
import edu.uwi.soscai.model.DayForecast;
import edu.uwi.soscai.model.HourForecast;
import edu.uwi.soscai.model.Condition;
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
    void getWeatherDataByLocation(ActionEvent event) {

    }

    @FXML
    void initialize() {
        List<HourForecast> hourlyForecasts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HourForecast hf = getRandomHourForecast();
            hourlyForecasts.add(hf);
            hourForecast_hbox.getChildren().add(hf.getCard());
            HBox.setHgrow(hf.getCard(), Priority.ALWAYS);
        }
        dayForecast_lv.setCellFactory(cf->new DayForecastCell());
        for (int i = 0; i < 7; i++) {
            DayForecast df = getRandomDayForecast();
            dayForecast_lv.getItems().add(df);
        }
    }

    private DayForecast getRandomDayForecast() {
        Condition[] conditions = Condition.values();
        int conditionIndex = (int) (conditions.length * Math.random());
        Condition condition = conditions[conditionIndex];
        double temperature = 20 + 10 * Math.random() - 5;
        double humidity = Math.random();
        double windSpeed = 10 * Math.random();
        LocalDate date = LocalDate.now();
        return new DayForecast(date, condition, temperature, humidity, windSpeed);
    }

    private static final HourForecast getRandomHourForecast() {
        Condition[] conditions = Condition.values();
        int conditionIndex = (int) (conditions.length * Math.random());
        Condition condition = conditions[conditionIndex];
        double temperature = 20 + 10 * Math.random() - 5;
        double humidity = Math.random();
        double windSpeed = 10 * Math.random();
        LocalTime time = LocalTime.of(8 + (int) (13 * Math.random()),
                (int) (60 * Math.random()));
        return new HourForecast(time, condition, temperature, humidity, windSpeed);
    }

}
