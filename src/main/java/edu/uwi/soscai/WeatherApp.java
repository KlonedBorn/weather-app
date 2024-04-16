package edu.uwi.soscai;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class WeatherApp extends Application {

    private static final InputStream SYSTEM_PROPERTIES = WeatherApp.class.getResourceAsStream("app.properties");
    private static Properties properties = new Properties();

    @Override
    public void start(Stage stage) throws Exception {
        properties.load(SYSTEM_PROPERTIES);
        stage.setScene(FXMLLoader.load(APP_PATH));
        stage.setTitle("Weather Forecast App " + properties.getProperty("app.version"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Properties getProperties() {
        return properties;
    }

    private static final URL APP_PATH = WeatherApp.class.getResource("view/app.fxml");
}