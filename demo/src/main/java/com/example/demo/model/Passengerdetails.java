package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Passengerdetails {
    private int id;
    private String Name;
    private String starting;
     private String destination;
     public Passengerdetails()
     {

     }
    public Passengerdetails( int id,String name, String starting, String destination) {
        this.Name = name;
        this.id = id;
        this.starting = starting;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "passengerDetails{" +
                "id='" + id + '\'' +
                ", Name=" + Name +
                ", starting=" + starting +
                ", destination=" + destination +
                '}';
    }

}

