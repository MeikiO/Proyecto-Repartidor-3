package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;


import java.util.Arrays;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;
import jdk.jshell.spi.ExecutionControl.UserException;


@Service
@Transactional
public class CredencialesService implements  DaoServices<UserAccount_Pojo>{

	
	public CredencialesRepository credenciales;

	
	public CredencialesService(CredencialesRepository user) {
		this.credenciales = user;
	}

	
	@Override
	public Long numero_de_elementos_en_database() {
		return this.credenciales.count();
	}

	@Override
	public UserAccount_Pojo buscarPorID(Long id) {
		//Objeto Optional -> sirve para definir y automatizar el null
    	// y sirve para comprobar si esta o no esta.
        Optional<UserAccount_Pojo> persona = this.credenciales.findById(id);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new UserAccount_Pojo();
        }
	}



	
	@Override
	public void registrarEnDatabase(UserAccount_Pojo objeto) {
			if (!objeto.getUsername().isBlank() && !objeto.getContrasena().isBlank()) {
	            this.credenciales.save(objeto);
	        }
	}

	@Override
	public void actualizar(UserAccount_Pojo objeto) {
	 	   if (objeto.getIdInterno() != null & !objeto.getUsername().isBlank() && !objeto.getContrasena().isBlank()) {
	    		  
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

	
    private boolean userExists(String username) {
        return this.credenciales.findByUsername(username) != null;
    }



}
