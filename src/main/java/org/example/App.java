package org.example;


import org.example.config.SpringConfig;
import org.example.model.City;
import org.example.model.Transport;
import org.example.services.Logistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Transport transport = context.getBean(Logistics.class).getShipping(
                new City("kazan", 800, true, true), 265, 2);
        System.out.println(transport);
//        Logistics logistics = context.getBean(Logistics.class);
//        TransportFactory transportFactory = context.getBean(TransportFactory.class);
//        System.out.println(logistics);
//        System.out.println(transportFactory);
    }
}