package edu.uwi.soscai.model;

import org.json.JSONObject;

public class Forecast {
    private double feelslikeC;
    private double uv;
    private String lastUpdated;
    private double feelslikeF;
    private int windDegree;
    private long lastUpdatedEpoch;
    private boolean isDay;
    private double precipIn;
    private String windDir;
    private double gustMph;
    private double tempC;
    private double pressureIn;
    private double gustKph;
    private double tempF;
    private double precipMm;
    private int cloud;
    private double windKph;
    private Condition condition;
    private double windMph;
    private double visKm;
    private int humidity;
    private double pressureMb;
    private double visMiles;

    public void load(JSONObject json) {
        this.feelslikeC = json.optDouble("feelslike_c");
        this.uv = json.optDouble("uv");
        this.lastUpdated = json.optString("last_updated");
        this.feelslikeF = json.optDouble("feelslike_f");
        this.windDegree = json.optInt("wind_degree");
        this.lastUpdatedEpoch = json.optLong("last_updated_epoch");
        this.isDay = json.optBoolean("is_day");
        this.precipIn = json.optDouble("precip_in");
        this.windDir = json.optString("wind_dir");
        this.gustMph = json.optDouble("gust_mph");
        this.tempC = json.optDouble("temp_c");
        this.pressureIn = json.optDouble("pressure_in");
        this.gustKph = json.optDouble("gust_kph");
        this.tempF = json.optDouble("temp_f");
        this.precipMm = json.optDouble("precip_mm");
        this.cloud = json.optInt("cloud");
        this.windKph = json.optDouble("wind_kph");
        this.condition = Condition.valueOf(json.optString("condition"));
        this.windMph = json.optDouble("wind_mph");
        this.visKm = json.optDouble("vis_km");
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    public long getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    public void setLastUpdatedEpoch(long lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean isDay) {
        this.isDay = isDay;
    }

    public double getPrecipIn() {
        return precipIn;
    }

    public void setPrecipIn(double precipIn) {
        this.precipIn = precipIn;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public double getGustMph() {
        return gustMph;
    }

    public void setGustMph(double gustMph) {
        this.gustMph = gustMph;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public double getGustKph() {
        return gustKph;
    }

    public void setGustKph(double gustKph) {
        this.gustKph = gustKph;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public double getWindKph() {
        return windKph;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getWindMph() {
        return windMph;
    }

    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }

    public double getVisKm() {
        return visKm;
    }

    public void setVisKm(double visKm) {
        this.visKm = visKm;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(double visMiles) {
        this.visMiles = visMiles;
    }

}
