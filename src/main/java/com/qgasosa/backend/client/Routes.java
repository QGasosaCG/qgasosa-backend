package com.qgasosa.backend.client;

import java.util.ArrayList;

public class Routes {
    private ArrayList<Legs> legs;

    public ArrayList<Legs> getLegs() {
        return legs;
    }

    public void setLegs(ArrayList<Legs> legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "legs=" + legs.toString() +
                '}';
    }
}
