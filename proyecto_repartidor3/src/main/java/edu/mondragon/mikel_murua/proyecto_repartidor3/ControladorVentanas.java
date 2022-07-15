package edu.mondragon.mikel_murua.proyecto_repartidor3;

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
public class ControladorVentanas {

	public ServiceRepartidor repartidores;
	private Long idDeLaPersonaEnCurso;
	
	public ControladorVentanas(ServiceRepartidor modeloRepartidor) {
		this.repartidores = modeloRepartidor;
		this.idDeLaPersonaEnCurso= (long) 0;
	}

	/*
	 * Cosas Importantes:
	   2. MODEL tiene que pasarse OBLIGATORIAMENTE
	 
	  	3. Los programas se activan solo cuando se accede al URL que tiene cada funcion.  localhost:8080/  -> activa el primero {/}
	  		-> por eso el cambio de ventanas se hace por html cambiando a la pagina correspondendiente, al hacer el cambio
	  			se activa la funcion del controlador que hace refencia a ese URL  . 	 
	 */

	
	
	/*
	    con SPRING SECURITY,  si hacemos llamada a cualquier URL de nuestra pagina web. Interceptara la llamada
	    
	    y cargara la ventana de login ( esto esta definido en Seguridad-> SecurityConfiguration  ) y despues de registrarse
	    
	    nos cargara la pagina web que habiamos llamado al inicio.
	    
	    -> ejemplo:  llama a          localhost8080/          -> primero carga el login y cuando entremos entrara a ventana inicio.
	  
	 */
	
	
	@GetMapping("/login") 
	public String paginaLogin(Model model, String error, String logout) {
        
		model.addAttribute("error", error);
       
   
		// se pasa siempre el modelo a la pagina web que cargamos

		model.addAttribute("nombreEnControlador", "soy un atributo especificado en el controlador");
		// para usar el interface de REPARTIDORPERSISTENCIA X USAMOS EL SERVICE
		model.addAttribute("Numero_de_objetos_database", this.repartidores.numero_de_elementos_en_database());

		
		// especificamos que pagina va ha cargar a continuacion (no hace falta poner
		// extension (.html)
		// te lo toma directamente. Y le pasamos el modelo (que se usara como atributo)
		
		return "login/login";
	}

	
    @GetMapping({"/"})
    public String redirigirALaPaginaDeInicio() {
        return "index";
    }
	
    
    
    
    
   
    
    
    
    
}
