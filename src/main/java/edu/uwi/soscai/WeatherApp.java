package edu.uwi.soscai;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class WeatherApp extends Application {

    private static final InputStream SYSTEM_PROPERTIES = WeatherApp.class.getResourceAsStream("app.properties");
    private static Stage stage;
    private Properties props;

    @Override
    public void start(Stage stage) throws Exception {
        props = new Properties();
        props.load(SYSTEM_PROPERTIES);
        WeatherApp.stage = stage;
        stage.setScene(FXMLLoader.load(APP_PATH));
        stage.setTitle("Weather Forecast App " + props.getProperty("app.version"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final URL APP_PATH = WeatherApp.class.getResource("view/app.fxml");
}
