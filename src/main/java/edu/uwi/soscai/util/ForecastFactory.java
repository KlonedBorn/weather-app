package edu.uwi.soscai.util;

import java.time.LocalDate;
import java.time.LocalTime;

import edu.uwi.soscai.model.AlertForecast;
import edu.uwi.soscai.model.Condition;
import edu.uwi.soscai.model.DayForecast;
import edu.uwi.soscai.model.HourForecast;

public class ForecastFactory {
    public static final DayForecast getRandomDayForecast() {
        LocalDate date = LocalDate.now().plusDays((long) (30 * Math.random()));
        Condition[] conditions = Condition.values();
        int conditionIndex = (int) (conditions.length * Math.random());
        Condition condition = conditions[conditionIndex];
        double temperature = 20 + 10 * Math.random() - 5;
        double humidity = Math.random();
        double windSpeed = 10 * Math.random();
        return new DayForecast(date, condition, temperature, humidity, windSpeed);
    }

    public static final HourForecast getRandomHourForecast() {
        Condition[] conditions = Condition.values();
        int conditionIndex = (int) (conditions.length * Math.random());
        Condition condition = conditions[conditionIndex];
        double temperature = 20 + 10 * Math.random() - 5;
        double humidity = Math.random();
        double windSpeed = 10 * Math.random();
        LocalTime time = LocalTime.of(8 + (int) (13 * Math.random()),
                (int) (60 * Math.random()));
        return new HourForecast(time, condition, temperature, humidity, windSpeed);
    }

    public static final AlertForecast getRandomAlertForecast() {
        String[] places = {"New Orleans", "Miami", "Houston", "San Juan",
                "Baton Rouge", "Mobile", "Pensacola", "Tampa", "Charleston",
                "Jacksonville", "Atlanta"};
        int placeIndex = (int) (places.length * Math.random());
        String place = places[placeIndex];
        LocalDate date = LocalDate.now();
        Alert[] conditions = new Alert[] {Alert.HURRICANE,
                Alert.FLASH_FLOOD, Alert.HEAVY_RAIN, Alert.THUNDERSTORM,
                Alert.HAIL, Alert.FLOOD, Alert.SNOW, Alert.BLIZZARD};
        int conditionIndex = (int) (conditions.length * Math.random());
        Alert condition = conditions[conditionIndex];
        return new AlertForecast(place, date, condition);
    }
}
