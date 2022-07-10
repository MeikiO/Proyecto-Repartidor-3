package edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores;

import org.springframework.stereotype.Service;



@Service //lo marcamos como servicio
public class ServiceRepartidor  {

	public RepartidorPersistenciaX repa;

	// Esta clase sirve exclusivamente para poder hacer uso de los metodos que nos 
	// da el interface de REPARTIDORPERSISTENCIAX. para poder hacer uso de los metodos
	// JpaRepository

	public ServiceRepartidor(RepartidorPersistenciaX repa) {
		super();
		this.repa = repa;
	}
	
	
	/*
	 Aqui estan todos los metodos que puedes utilizar con el interface:
	  
	  -> docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html
	
	 */
	
	public Long contar_elementos() {
		return this.repa.count();
	}
	
    public Object get(String nombreYapellidos) {
        // TODO falta ver como podemos buscar una pesona por su nombre y apellidos
        return null;
    }

    
    public void guardar(Repartidor unaPersona) {
        if (unaPersona.getId_repartidor() != null) {
            // TODO actualizar sus datos ,  /¿lo hace Spring Boot el solo ? ?!?
        } else if (!unaPersona.getNombre().isBlank() && !unaPersona.getApellido().isBlank()) {
            this.repa.save(unaPersona);
        }
    }
    


}
