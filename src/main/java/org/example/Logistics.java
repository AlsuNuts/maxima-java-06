package org.example;

import org.springframework.stereotype.Component;

@Component
public class Logistics {
    private Transport [] vehicles;

    public Logistics(Transport ... vehicles) {

        this.vehicles = vehicles;
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Transport[] vehicles) {
        this.vehicles = vehicles;
    }

    public Transport getShipping(City city, int weight, int hours) {

        Transport profitTransport = null;

        for (Transport vehicle : vehicles) { //(int i = 0; i < vehicles().length(); i++)
            if (isShippingAvailable(city, vehicle, weight, hours)) {
                if (profitTransport == null ){
                    profitTransport = vehicle;
                }
                else if (profitTransport.getCostOfKm() > vehicle.getCostOfKm() ) { //хотела избежать else if конструкции, но мне так идея подсказала
                    profitTransport = vehicle;
                }
            }
        }
        return profitTransport;
    }
    public boolean isShippingAvailable(City city, Transport transport, int weight, int hours) {
        return (!transport.isRepairing()) & (transport.getCapacity() >= weight) & (city.getDistanceKm() / transport.getSpeed() <= hours) & (transport.getPrice(city) != 0);
    }

}