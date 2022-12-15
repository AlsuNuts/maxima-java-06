package org.example.services;

import org.example.model.*;
import org.springframework.stereotype.Component;

public class TransportFactory {
    public Transport getTransport(City city, int weight, int hours){
        final String PLANE_NAME = "самолет";
        final float PLANE_COST_OF_KM = 58.9f;
        final String SHIP_NAME = "баржа";
        final float SHIP_COST_OF_KM = 12.7f;
        final String TRUCK_NAME = "грузовик";
        final float TRUCK_COST_OF_KM= 13.4f;

        int roundedSpeed = city.getDistanceKm()/hours;
        int transportWeight = (weight % 500 != 0) ? weight/500 * 500 + 500 : weight;
        //System.out.println(transportWeight);
        int transportSpeed = (roundedSpeed % 10 != 0) ? roundedSpeed/10 * 10 + 10 : roundedSpeed;
        System.out.println(transportSpeed);
        if (transportSpeed<40 && city.isOnWater()){
            return new Ship(SHIP_NAME, transportWeight, transportSpeed, SHIP_COST_OF_KM);
        }
        if (transportSpeed>120 && city.hasAirport()){
            return new Plane(PLANE_NAME, transportWeight, transportSpeed, PLANE_COST_OF_KM);
        }
        return new Truck(TRUCK_NAME, transportWeight, transportSpeed, TRUCK_COST_OF_KM);
    }
}