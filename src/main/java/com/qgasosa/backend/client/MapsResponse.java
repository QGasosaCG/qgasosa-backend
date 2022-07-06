package com.qgasosa.backend.client;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsResponse {
    private ArrayList<Routes> routes;

    public ArrayList<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<Routes> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "Response{" +
                "routes=" + routes.toString() +
                '}';
    }
}
