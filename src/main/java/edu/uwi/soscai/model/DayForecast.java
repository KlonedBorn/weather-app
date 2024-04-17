package edu.uwi.soscai.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

public class DayForecast {
    private LocalDate date;
    private Condition condition;
    private double temperature;
    private double humidity;
    private double windSpeed;

    public DayForecast(LocalDate date, Condition condition, double temperature, double humidity,
            double windSpeed) {
        this.date = date;
        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public boolean isToday() {
        return date.equals(LocalDate.now());
    }

    public static DayForecast fromJSON(JSONObject data, int i) {
        System.out.println(data.toString(4));
        JSONArray arr = data.getJSONArray("forecastday");
        LocalDate date = LocalDate.parse(data.getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Condition condition = Condition.valueOf(data.getString("condition"));
        double temperature = data.getDouble("temp");
        double humidity = data.getDouble("humidity");
        double windSpeed = data.getDouble("wind_speed");
        return new DayForecast(date, condition, temperature, humidity, windSpeed);
    }
}