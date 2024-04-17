package edu.uwi.soscai.model;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;

import org.json.JSONObject;

import edu.uwi.soscai.WeatherApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HourForecast {
    private LocalTime time;
    private Condition condition;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private HourForecastCard card;

    public HourForecast(LocalTime time, Condition condition, double temperature, double humidity,
            double windSpeed) {
        this.time = time;
        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.card = new HourForecastCard(this);
    }

    public class HourForecastCard extends VBox {

        @FXML
        private ImageView condition_iv;

        @FXML
        private Label hour_lbl;

        @FXML
        private Label humidity_lbl;

        @FXML
        private Label temperature_lbl;

        @FXML
        private Label windSpeed_lbl;

        private HourForecast parent;

        public HourForecastCard(HourForecast parent) {
            this.parent = parent;
            try {
                FXMLLoader loader = new FXMLLoader(HOUR_FORECAST_CARD_PATH);
                loader.setRoot(new GridPane());
                loader.setController(this);
                getChildren().add(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void initialize() {
            hour_lbl.setText(parent.getTime().toString());
            temperature_lbl.setText(String.format("%.1f°C", parent.getTemperature()));
            humidity_lbl.setText(String.format("%.0f%%", parent.getHumidity() * 100));
            windSpeed_lbl.setText(String.format("%.1f m/s", parent.getWindSpeed()));
            condition_iv.setImage(parent.getCondition().getImage());
        }
    }

    public HourForecastCard getCard() {
        return card;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setCard(HourForecastCard card) {
        this.card = card;
    }

    private static final URL HOUR_FORECAST_CARD_PATH = WeatherApp.class
            .getResource("view/layout/hour-forecast-card.fxml");

    public static HourForecast fromJSON(JSONObject data, int i) {
        System.out.println(data.toString(4));
        LocalTime time = LocalTime.parse(data.getString("FCTTIME")
                .substring(11, 16));
        Condition condition = Condition.valueOf(data.getString("icon"));
        double temperature = data.getDouble("temp");
        double humidity = data.getDouble("humidity");
        double windSpeed = data.getDouble("wspd");
        return new HourForecast(time, condition, temperature, humidity,
                windSpeed);
    }

}