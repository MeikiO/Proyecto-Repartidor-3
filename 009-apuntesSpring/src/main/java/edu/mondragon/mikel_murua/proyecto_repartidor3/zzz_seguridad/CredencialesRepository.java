package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.parte_datos.repartidor.Repartidor;

public interface CredencialesRepository extends JpaRepository<Credencial, Long>{

	Optional<Credencial> findByUsername(String username);
	/*
	 -> Optional<Credencial> findBy<Campo para coger en Mayuscrula la primera>(String campo por el que se busca); 
	
	 	+ Documentacion
	 	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	*/
	
}
