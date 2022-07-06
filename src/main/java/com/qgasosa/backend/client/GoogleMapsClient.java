package com.qgasosa.backend.client;

import com.google.gson.Gson;
import com.qgasosa.backend.model.GasStation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class GoogleMapsClient {
    @Value("${api-key}")
    private String API_KEY;

    private String baseUrl;

    public GoogleMapsClient() {
        this.baseUrl = "https://maps.googleapis.com/maps/api/directions/json";
    }

    public Integer getDistance(String originLatitude, String originLongitude, GasStation gasStation) throws IOException {
        URL url = new URL(baseUrl + "?origin=" + originLatitude + "," + originLongitude +
                "&destination=" + gasStation.getAddress().getCoordinates() + "&key=" + API_KEY);

        HttpURLConnection connection = getConnection(url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        Gson gson = new Gson();
        MapsResponse response = gson.fromJson(in, MapsResponse.class);

        return response.getRoutes().get(0).getLegs().get(0).getDistance().getValue();

    }

    private HttpURLConnection getConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoOutput(true);

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());

        out.flush();
        out.close();

        return connection;
    }
}
