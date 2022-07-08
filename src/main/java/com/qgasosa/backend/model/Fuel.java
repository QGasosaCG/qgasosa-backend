package com.qgasosa.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "fuel")
    private Set<GasStationFuel> gasStations;

    public Fuel() {
        this.gasStations = new HashSet<>();
    }

    public Fuel(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GasStationFuel> getGasStations() {
        return gasStations;
    }

    public void addGasStation(GasStation gasStation, Double price) {
        this.gasStations.add(new GasStationFuel(gasStation, this, price));
    }
}
