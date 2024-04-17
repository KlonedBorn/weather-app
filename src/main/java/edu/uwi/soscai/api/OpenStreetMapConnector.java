package edu.uwi.soscai.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class OpenStreetMapConnector {
    private String baseUrl;
    private JSONObject response;

    public OpenStreetMapConnector() {
        this.baseUrl = "https://nominatim.openstreetmap.org/search";
    }

    public OpenStreetMapConnector(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public double[] getCoordinate() throws IOException {
        if (response != null) {
            JSONArray results = response.getJSONArray("results");
            if (!results.isEmpty()) {
                JSONObject result = results.getJSONObject(0);
                return new double[] { result.getDouble("lat"), result.getDouble("lon") };
            }
        }
        return new double[] { 0, 0 };
    }

    public String getAddress() throws IOException {
        if (response != null) {
            JSONArray results = response.getJSONArray("results");
            if (!results.isEmpty()) {
                JSONObject result = results.getJSONObject(0);
                return result.getString("display_name");
            }
        }
        return "";
    }

    public boolean getResponse(String cityName) throws IOException {
        Map<String, String> params = Map.of("q", cityName, "format", "json", "limit", "1");
        response = request(baseUrl, params);
        return response != null;
    }


    /**
     * Send HTTP GET request to the given URL and return response in JSON format
     * 
     * @param url    target URL
     * @param params query parameters
     * @return response in JSON format
     * @throws IOException
     */
    private JSONObject request(String url, Map<String, String> params) throws IOException {
        StringBuilder query = new StringBuilder();
        // Make sure keys and values that have spaces are excaped
        for (Map.Entry<String, String> entry : params.entrySet()) {
            query.append(entry.getKey())
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), "UTF-8"))
                    .append("&");
        }
        query.deleteCharAt(query.length() - 1);

        HttpURLConnection con = (HttpURLConnection) new URL(url + "?" + query).openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to get response from OpenStreetMap. HTTP error code: " + status);
        }

        try (InputStream is = con.getInputStream()) {
            // The response is in JSON format is an array
            String response = IOUtils.toString(is, "UTF-8");
            JSONTokener tokener = new JSONTokener(response);
            return new JSONObject().put("results", tokener.nextValue());
        }
    }

}
