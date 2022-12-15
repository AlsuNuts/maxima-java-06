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
    public TransportFactory transportFactory(){
        return new TransportFactory();
    }
    @Bean
    public Transport transport() {
        return new Transport() { //idea так вывела (почему?)
            @Override
            public String name() {
                return null;
            }
        };
    }
}