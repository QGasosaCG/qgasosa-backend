package com.qgasosa.backend.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "gasStation")
    private Set<GasStationFuel> fuels;

    public GasStation() {
        this.fuels = new HashSet<>();
    }

    public GasStation(String name, Address address) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public int compareTo(GasStation o, Fuel fuel) {
        GasStationFuel toBeCompared = null;
        for (GasStationFuel g: o.fuels) {
            if (g.getFuelName().equals(fuel.getName())) {
                toBeCompared = g;
            }
        }

        for (GasStationFuel g: this.fuels) {
            if (g.getFuelName().equals(fuel.getName())) {
                return g.getPrice().compareTo(toBeCompared.getPrice());
            }
        }
        return 0;
    }
}
