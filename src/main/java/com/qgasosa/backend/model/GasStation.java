package com.qgasosa.backend.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "gasStation")
    private Set<GasStationFuel> fuels;

    public GasStation() {
        this.fuels = new HashSet<>();
    }

    public GasStation(String name, String address) {
        this();
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<GasStationFuel> getFuels() {
        return fuels;
    }

    public void setFuels(Set<GasStationFuel> fuels) {
        this.fuels = fuels;
    }

    public void addFuel(Fuel fuel, Double price) {
        this.fuels.add(new GasStationFuel(this, fuel, price));
    }
}
