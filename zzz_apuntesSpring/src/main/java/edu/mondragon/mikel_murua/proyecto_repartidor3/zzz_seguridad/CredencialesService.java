package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;


import java.util.Optional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.parte_datos.repartidor.Repartidor;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

public class CredencialesService implements DaoServices<Credencial> {

	public CredencialesRepository credenciales;

	public CredencialesService() {
	}
	
	public CredencialesService(CredencialesRepository user) {
		this.credenciales = user;
	}

	@Override
	public Long numero_de_elementos_en_database() {
		return this.credenciales.count();
	}

	@Override
	public Credencial buscarPorID(Long id) {
		//Objeto Optional -> sirve para definir y automatizar el null
    	// y sirve para comprobar si esta o no esta.
        Optional<Credencial> persona = this.credenciales.findById(id);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new Credencial();
        }
	}

	
	public Credencial buscarPorUsername(String username) {
		//Objeto Optional -> sirve para definir y automatizar el null
    	// y sirve para comprobar si esta o no esta.
        Optional<Credencial> persona = this.credenciales.findByUsername(username);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new Credencial();
        }
	}
	

	@Override
	public void registrarEnDatabase(Credencial objeto) {
	     if (objeto.getIdInterno() != null) {
	            // TODO actualizar sus datos ,  /¿lo hace Spring Boot el solo ? ?!?
	        } else if (!objeto.getUsername().isBlank() && !objeto.getPassword().isBlank()) {
	            this.credenciales.save(objeto);
	        }
	}

	@Override
	public void actualizar(Credencial objeto) {
	 	   if (objeto.getIdInterno() != null & !objeto.getUsername().isBlank() && !objeto.getPassword().isBlank()) {
	    		  
    		   /*
    		    Para actualizar usa save, para entender esto hay que saber estas 2 cosas:
    		    + Spring boot no guarda y accede directamente a la database, 
    		    lo hace en un cache que tiene, y todos los cambios los vuelca hay, antes de pasarlos a database.
    		    
    		    + Por esta misma razon, si el pojo (entidad) ha sido previamente buscada con
    		    findId(), queda registro de ello y en vez de guardar un nuevo elemento, actualiza el existente
    		    cuando hacemo save().
    		    
    		    */
    		   //this.repa.deleteById(unaPersona.getId_repartidor());
    	       this.credenciales.save(objeto);
    	   }
	}

	@Override
	public void borrarElemento(Long id) {
	}

	// Esta clase sirve exclusivamente para poder hacer uso de los metodos que nos 
	// da el interface de REPOSITORYREPARTIDOR. para poder hacer uso de los metodos
	// JpaRepository

	

}
