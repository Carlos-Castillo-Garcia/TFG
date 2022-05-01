package com.app.GestionInmuebles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.TFG")
@ComponentScan("com.app")
public class GestionInmueblesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionInmueblesApplication.class, args);
	}

}
