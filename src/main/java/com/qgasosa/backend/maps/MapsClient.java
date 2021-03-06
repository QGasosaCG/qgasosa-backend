package com.qgasosa.backend.maps;

import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStation;

import java.io.IOException;

public interface MapsClient {

    MapsMetricResponse getDistance(String originLatitude, String originLongitude, GasStation gasStation) throws IOException;

}
