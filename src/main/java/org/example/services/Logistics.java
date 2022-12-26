package org.example.services;

import org.example.model.City;
import org.example.model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Модифицировать класс Logistics так, чтобы при отсутствии доступных транспортов фабрикой создавался бы новый транспорт.

@Component
public class Logistics {
    private Transport[] vehicles;
    private TransportFactory transportFactory;

    @Autowired
    public Logistics(Transport[] vehicles, TransportFactory transportFactory) {
        this.vehicles = vehicles;
        this.transportFactory = transportFactory;
    }




    public Transport[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Transport[] vehicles) {
        this.vehicles = vehicles;
    }

    public Transport getShipping(City city, int weight, int hours) {

        Transport profitTransport = null;

        for (Transport vehicle : vehicles) {
            if (isShippingAvailable(city, vehicle, weight, hours)) {
                if (profitTransport == null ){
                    profitTransport = vehicle;
                }
                else if (profitTransport.getCostOfKm() > vehicle.getCostOfKm() ) {
                    profitTransport = vehicle;
                }
            }
        }
        return profitTransport;
    }
    public boolean isShippingAvailable(City city, Transport transport, int weight, int hours) {
        return (!transport.isRepairing()) & (transport.getCapacity() >= weight) &
                (city.getDistanceKm() / transport.getSpeed() <= hours) & (transport.getPrice(city) != 0);
    }

}