package com.app.GestionInmuebles;

import com.app.GestionInmuebles.Services.ServiceImpl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GestionInmueblesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionInmueblesApplication.class, args);
	}
}
