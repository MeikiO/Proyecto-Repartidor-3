package edu.mondragon.mikel_murua.proyecto_repartidor3;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Repository;

@SpringBootApplication
public class ApplicationProyectoRepartidor3 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationProyectoRepartidor3.class, args);
	}

		
}
