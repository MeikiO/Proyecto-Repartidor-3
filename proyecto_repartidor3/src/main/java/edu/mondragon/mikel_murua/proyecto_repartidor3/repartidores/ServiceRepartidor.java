package edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores;

import java.util.Optional;

import javax.transaction.Transaction;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;




@Service //lo marcamos como servicio
public class ServiceRepartidor implements DaoServices<Repartidor> {

	public RepositoryRepartidor repa;

	// Esta clase sirve exclusivamente para poder hacer uso de los metodos que nos 
	// da el interface de REPOSITORYREPARTIDOR. para poder hacer uso de los metodos
	// JpaRepository

	public ServiceRepartidor(RepositoryRepartidor repa) {
		super();
		this.repa = repa;
	}
	
	
	/*
	 Aqui estan todos los metodos que puedes utilizar con el interface:
	  
	  -> docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html
	
	 */
	


	@Override
	public Long numero_de_elementos_en_database() {
		return this.repa.count();
	}


	@Override
	public Repartidor buscarPorID(Long id) {
		//Objeto Optional -> sirve para definir y automatizar el null
    	// y sirve para comprobar si esta o no esta.
        Optional<Repartidor> persona = this.repa.findById(id);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new Repartidor();
        }
	}


	@Override
	public void registrarEnDatabase(Repartidor objeto) {
	     if (objeto.getId_repartidor() != null) {
	            // TODO actualizar sus datos ,  /¿lo hace Spring Boot el solo ? ?!?
	        } else if (!objeto.getNombre().isBlank() && !objeto.getApellido().isBlank()) {
	            this.repa.save(objeto);
	        }
	}


	@Override
	public void actualizar(Repartidor objeto) {
	  	   if (objeto.getId_repartidor() != null) {
	    		  
    		   /*
    		    Para actualizar usa save, para entender esto hay que saber estas 2 cosas:
    		    + Spring boot no guarda y accede directamente a la database, 
    		    lo hace en un cache que tiene, y todos los cambios los vuelca hay, antes de pasarlos a database.
    		    
    		    + Por esta misma razon, si el pojo (entidad) ha sido previamente buscada con
    		    findId(), queda registro de ello y en vez de guardar un nuevo elemento, actualiza el existente
    		    cuando hacemo save().
    		    
    		    */
    		   //this.repa.deleteById(unaPersona.getId_repartidor());
    	       this.repa.save(objeto);
    	   }
	}


	@Override
	public void borrarElemento(Long id) {
		  Optional<Repartidor> persona = this.repa.findById(id);
          if (persona.isPresent()) {
              this.repa.deleteById(id);
          } 
	}




}
