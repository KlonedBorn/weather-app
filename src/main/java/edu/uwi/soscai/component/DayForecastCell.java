package edu.uwi.soscai.component;

import java.io.IOException;
import java.net.URL;
import java.time.format.TextStyle;
import java.util.Locale;

import edu.uwi.soscai.WeatherApp;
import edu.uwi.soscai.model.DayForecast;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class DayForecastCell extends ListCell<DayForecast> {

    @FXML
    private ImageView condition_iv;

    @FXML
    private Label condition_lbl;

    @FXML
    private Label day_lbl;

    @FXML
    private Label humidity_lbl;

    @FXML
    private Label temperature_lbl;

    @FXML
    private Label windSpeed_lbl;

    private GridPane root;

    public DayForecastCell() {
        try {
            FXMLLoader loader = new FXMLLoader(DAY_FORECAST_CARD_PATH);
            loader.setRoot(new GridPane());
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void updateItem(DayForecast item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setGraphic(null);
        } else {
            day_lbl.setText((item.isToday() ? "Today" : item.getDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault())));
            condition_lbl.setText(item.getCondition().getCaption());
            temperature_lbl.setText(String.format("%.1f°C", item.getTemperature()));
            humidity_lbl.setText(String.format("%.0f%%", item.getHumidity() * 100));
            windSpeed_lbl.setText(String.format("%.1f m/s", item.getWindSpeed()));
            condition_iv.setImage(item.getCondition().getImage());
            condition_iv.setFitWidth(24);
            condition_iv.setFitHeight(24);
            day_lbl.setStyle("-fx-font-weight: " + (item.isToday() ? "bold" : "normal") + ";");
            setGraphic(root);
        }
    }

    private static final URL DAY_FORECAST_CARD_PATH = WeatherApp.class
            .getResource("view/layout/day-forecast-card.fxml");
}