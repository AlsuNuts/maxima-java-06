package org.example.model;

import org.example.model.City;
import org.example.model.Transport;

public class Ship extends Transport {
    public Ship(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }
    @Override
    public float getPrice(City city){
        return (!city.isOnWater() ? 0f : getCostOfKm() * city.getDistanceKm());
    }
}