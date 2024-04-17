package edu.uwi.soscai.model;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.uwi.soscai.WeatherApp;
import edu.uwi.soscai.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class AlertForecast {
    private String area;
    private String event;
    private LocalDate effective;
    private AlertForecastCard card;

    public AlertForecast(String area, LocalDate effective, Alert event) {
        this.area = area;
        this.event = event.name();
        this.effective = effective;
        this.card = new AlertForecastCard(this);
    }

    public LocalDate getEffective() {
        return effective;
    }

    public void setEffective(LocalDate effective) {
        this.effective = effective;
    }

    // public static AlertForecast fromJSON(JSONObject json) {
    // AlertForecast alert = new AlertForecast();

    // alert.setHeadline(json.getString("headline"));
    // DateTimeFormatter formatter =
    // DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    // alert.setEffective(LocalDate.parse(json.getString("effective"),
    // formatter));
    // alert.setExpires(LocalDate.parse(json.getString("expires"), formatter));
    // alert.setDesc(json.getString("description"));
    // String instruction = json.getString("instruction");
    // instruction = instruction.replaceAll("\\n", " ");
    // alert.setInstruction(instruction);

    // return alert;
    // }

    public AlertForecastCard getCard() {
        return card;
    }

    public class AlertForecastCard extends GridPane {
        @FXML
        private Label area_lbl;

        @FXML
        private Label date_lbl;

        @FXML
        private Label event_lbl;

        public AlertForecastCard(AlertForecast alertForecast) {
            try {
                FXMLLoader loader = new FXMLLoader(ALERT_CARD_PATH);
                loader.setRoot(this);
                loader.setController(this);
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void initialize() {
            area_lbl.setText(area);
            date_lbl.setText(effective.format(DateTimeFormatter.ofPattern("MMM d, yyyy")));
            event_lbl.setText(event);
        }
    }

    private static final URL ALERT_CARD_PATH = WeatherApp.class.getResource("view/layout/alert-card.fxml");
}
