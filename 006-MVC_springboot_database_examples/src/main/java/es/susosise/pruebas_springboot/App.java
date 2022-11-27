package es.susosise.pruebas_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import es.susosise.pruebas_springboot.actividades.Actividades;
import es.susosise.pruebas_springboot.personas.Personas;
import es.susosise.pruebas_springboot.personas.Telefonos;
import es.susosise.pruebas_springboot.poblaciones.Poblaciones;
import es.susosise.pruebas_springboot.seguridad.Credenciales;


@SpringBootApplication
public class App {
    public static final Logger logger = LoggerFactory.getLogger(App.class);
    
	public static void main(String[] args) {
	    logger.info("Arrancando la aplicación...");
	    SpringApplication.run(App.class, args);
	}
	
	
	@Bean
	public CommandLineRunner llenarLaBaseDeDatosConLosDatosDePrueba(
	        Credenciales credenciales, 
	        Poblaciones poblaciones,
	        Telefonos telefonos,
	        Personas personas,
	        Actividades actividades) {
	    return args -> {
	        credenciales.crearCredencialesParaPruebas();
	        poblaciones.crearPoblacionesParaPruebas();
	        telefonos.crearTelefonosParaPruebas();
	        personas.crearPersonasParaPruebas(poblaciones, telefonos);
	        actividades.crearActividadesParaPruebas(personas);
	    };
	}

}
