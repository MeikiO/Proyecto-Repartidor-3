package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores.Repartidor;
import edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores.ServiceRepartidor;

@Controller
public class ControladorServicioUsuarios {


	/*
	 * Cosas Importantes:
	   2. MODEL tiene que pasarse OBLIGATORIAMENTE
	 
	  	3. Los programas se activan solo cuando se accede al URL que tiene cada funcion.  localhost:8080/  -> activa el primero {/}
	  		-> por eso el cambio de ventanas se hace por html cambiando a la pagina correspondendiente, al hacer el cambio
	  			se activa la funcion del controlador que hace refencia a ese URL  . 	 
	 */

	
	@GetMapping("/crearUsuario") 
	public Usuario crearUsuario(Model model, String error, String logout) {
        
		Usuario usuario=new Usuario();
		
		
		return usuario ;
	}
	
	
	
	
	

}
