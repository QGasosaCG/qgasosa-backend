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

    private String placeId;

    @OneToMany(mappedBy = "gasStation")
    private Set<GasStationFuel> fuels;

    public GasStation() {
        this.fuels = new HashSet<>();
    }

    public GasStation(String name, String address, String placeId) {
        this();
        this.name = name;
        this.address = address;
        this.placeId = placeId;
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

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
