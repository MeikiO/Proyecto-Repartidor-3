package es.susosise.pruebas_springboot.personas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersistenciaPersonas extends JpaRepository<Persona, Long> {

}

//nota: No es necesario proveer una implementación explícita para este interfaz
//      porque ya lo hace automáticamente Spring Boot, proporcionando una implementación basada en SimpleJpaRepository
//      https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html
