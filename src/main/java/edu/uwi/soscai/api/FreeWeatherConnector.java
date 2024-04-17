package edu.uwi.soscai.api;

import edu.uwi.soscai.WeatherApp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import org.json.JSONException;
import org.json.JSONObject;
public class FreeWeatherConnector {
    /**
     * Get current weather
     * 
     * @param param query parameters
     * @return weather data in JSON format
     * @throws JSONException
     * @throws IOException
     */
    public static JSONObject getCurrent(Map<String, String> param) throws JSONException, IOException {
        return request(BASE_URL + "/current.json", param);
    }

    /**
     * Get forecast weather
     * 
     * @param param query parameters
     * @return weather data in JSON format
     * @throws JSONException
     * @throws IOException
     */
    public static JSONObject getForecast(Map<String, String> param) throws JSONException, IOException {
        return request(BASE_URL + "/forecast.json", param);
    }

    private static JSONObject request(String url, Map<String, String> param) throws IOException {
        String query = param.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
        url += "?" + query + "&key=" + API_KEY;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        try (InputStream is = con.getInputStream()) {
            return new JSONObject(IOUtils.toString(is, "UTF-8"));
        }
    }

    private static final String API_KEY = WeatherApp.getApiKey();
    private static final String BASE_URL = "http://api.weatherapi.com/v1";
}