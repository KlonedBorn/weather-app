package edu.uwi.soscai.model;

import java.net.URL;

import edu.uwi.soscai.WeatherApp;
import javafx.scene.image.Image;

public enum Condition {
    SUNNY("Sunny", getWeatherImagePath("sunny-64px")),
    CLOUDY("Cloudy", getWeatherImagePath("cloudy-64px")),
    RAINY("Rainy", getWeatherImagePath("rainy-64px")),
    THUNDERSTORM("Thunderstorm", getWeatherImagePath("thunderstorm-64px"));

    private final URL imgPath;
    private String caption;

    private Condition(String caption, URL imgPath) {
        this.caption = caption;
        this.imgPath = imgPath;
    }

    public String getCaption() {
        return caption;
    }

    public Image getImage() {
        return new Image(imgPath.toExternalForm());
    }

    private static final URL getWeatherImagePath(String name) {
        return WeatherApp.class.getResource("img/weather/" + name + ".png");
    }
}
