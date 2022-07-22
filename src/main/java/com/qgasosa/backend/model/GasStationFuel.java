package com.qgasosa.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GasStationFuel {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gas_station_id")
    private GasStation gasStation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fuel_id")
    private Fuel fuel;

    private Double price;

    private Date updatedAt;

    public GasStationFuel(GasStation gasStation, Fuel fuel, Double price) {
        this.gasStation = gasStation;
        this.fuel = fuel;
        this.price = price;
        this.updatedAt = new Date();
    }

    public GasStationFuel() {
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public String getFuelName() {
        return fuel.getName();
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
