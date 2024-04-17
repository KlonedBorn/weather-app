package edu.uwi.soscai.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

import edu.uwi.soscai.api.FreeWeatherConnector;
import edu.uwi.soscai.api.OpenStreetMapConnector;
import edu.uwi.soscai.component.DayForecastCell;
import edu.uwi.soscai.model.AlertForecast;
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
    private HBox alertBox_hbox;

    @FXML
    void getWeatherDataByLocation(ActionEvent event) throws IOException {
        // String cityName = location_tf.getText();
        // OpenStreetMapConnector osmc = new OpenStreetMapConnector();
        // if (osmc.getResponse(cityName)) {
        // double[] coord = osmc.getCoordinate();
        // String address = osmc.getAddress();
        // locationError_lbl.setText(address);
        // Map<String, String> param = Map.of("q", Double.toString(coord[0]) + "," +
        // Double.toString(coord[1]), "lang",
        // "en", "days", "14");
        // try {
        // JSONObject data = FreeWeatherConnector.getForecast(param);
        // showDemo();
        // } catch (JSONException | IOException e) {
        // e.printStackTrace();
        // }
        // } else {
        // locationError_lbl.setText("Couldn't find location: " + cityName);
        // }
        showDemo();
    }

    @FXML
    void initialize() {

    }

    private void showDemo() {
        hourForecast_hbox.getChildren().clear();
        dayForecast_lv.getItems().clear();
        for (int i = 0; i < 6; i++) {
            HourForecast hf = ForecastFactory.getRandomHourForecast();
            hourForecast_hbox.getChildren().add(hf.getCard());
            HBox.setHgrow(hf.getCard(), Priority.ALWAYS);
        }
        dayForecast_lv.setCellFactory(cf -> new DayForecastCell());
        for (int i = 0; i < 14; i++) {
            DayForecast df = ForecastFactory.getRandomDayForecast();
            dayForecast_lv.getItems().add(df);
        }
        for (int i = 0; i < 3; i++) {
            AlertForecast af = ForecastFactory.getRandomAlertForecast();
            alertBox_hbox.getChildren().add(af.getCard());
            HBox.setHgrow(af.getCard(), Priority.ALWAYS);
        }
    }
}