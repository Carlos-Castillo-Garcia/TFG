package com.app.GestionInmuebles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GestionInmueblesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionInmueblesApplication.class, args);
    }
}
