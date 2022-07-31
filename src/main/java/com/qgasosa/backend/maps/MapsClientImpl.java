package com.qgasosa.backend.maps;

import com.google.gson.Gson;
import com.qgasosa.backend.exception.common.InternalErrorException;
import com.qgasosa.backend.maps.response.MapsResponse;
import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class MapsClientImpl implements MapsClient {

    private final Logger logger = LogManager.getLogger(MapsClientImpl.class);

    @Value("${api-key}")
    private String API_KEY;

    private String baseUrl;

    public MapsClientImpl() {
        this.baseUrl = "https://maps.googleapis.com/maps/api/directions/json";
    }

    public MapsMetricResponse getDistance(String originLatitude, String originLongitude, GasStation gasStation) throws IOException {
        URL url = this.buildURL(originLatitude, originLongitude, gasStation);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        MapsResponse response = this.getDistanceResponse(connection);
        return response.getDistance();
    }

    private MapsResponse getDistanceResponse(HttpURLConnection connection) throws IOException {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        Gson gson = new Gson();
        try {
            MapsResponse response = gson.fromJson(inputStream, MapsResponse.class);
            if (response.fail()) throw new InternalErrorException(response.toString());

            return response;
        } catch (Exception e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    private URL buildURL(String originLatitude, String originLongitude, GasStation gasStation) throws MalformedURLException {
        String originCoordinates = String.format("%s,%s", originLatitude, originLongitude);
        String destinationCoordinates = URLEncoder.encode(gasStation.getAddress().getLocation(), StandardCharsets.UTF_8);
        return new URL(this.baseUrl + "?origin=" + originCoordinates + "&destination=" + destinationCoordinates + "&key=" + this.API_KEY);
    }
}
