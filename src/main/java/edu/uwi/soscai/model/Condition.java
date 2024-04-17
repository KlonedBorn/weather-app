package edu.uwi.soscai.model;

import java.net.URL;

import edu.uwi.soscai.WeatherApp;
import javafx.scene.image.Image;

public enum Condition {
    CLEAR("Clear", "Sunny", getWeatherIcon("clear-64px")),
    PARTLY_CLOUDY("Partly cloudy", "Partly cloudy", getWeatherIcon("partially-cloudy-64px")),
    CLOUDY("Cloudy", "Cloudy", getWeatherIcon("cloudy-64px")),
    OVERCAST("Overcast", "Overcast", getWeatherIcon("overcast-64px")),
    MIST("Mist", "Mist", getWeatherIcon("mist-64px")),
    RAIN("Rain", "Rain", getWeatherIcon("rainy-64px")),
    THUNDERSTORM("Thunderstorm", "Thunderstorm", getWeatherIcon("thunderstorm-64px"));

    private final String dayCaption;
    private final String nightCaption;
    private final URL imgPath;

    private Condition(String dayCaption, String nightCaption, URL imgPath) {
        this.dayCaption = dayCaption;
        this.nightCaption = nightCaption;
        this.imgPath = imgPath;
    }

    public String getDayCaption() {
        return dayCaption;
    }

    public String getNightCaption() {
        return nightCaption;
    }

    public Image getImage() {
        return new Image(imgPath.toExternalForm());
    }

    private static final URL getWeatherIcon(String name) {
        return WeatherApp.class.getResource("img/weather/" + name + ".png");
    }
}
