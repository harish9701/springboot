package com.example.demo.model;
import org.springframework.stereotype.Component;

@Component
public class StationAssign {
    private String station;
    private int value;

    public StationAssign() {
    }

    public StationAssign(String station, int value) {
        this.station = station;
        this.value = value;
    }

    public void assignStation(String station) {
        this.station = station;
    }

    public void giveValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return station + " " + value;
    }

    // Getters and Setters
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

