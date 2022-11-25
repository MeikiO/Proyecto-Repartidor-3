package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Poblacion_Repository  extends JpaRepository<Poblacion_Pojo, Long> {

	Optional<Poblacion_Pojo> findByNombreLocalizacion(String nombreLocalizacion);

}
