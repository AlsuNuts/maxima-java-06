package org.example.config;

import com.sun.jdi.connect.Transport;
import org.example.services.Logistics;
import org.example.services.TransportFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "org.example")
public class SpringConfig {

    @Bean("transportFactory")
    @Scope("prototype") //указывает, что бин имеет определенную область действия
    public TransportFactory transportFactory(){
        return new TransportFactory();
    }
}