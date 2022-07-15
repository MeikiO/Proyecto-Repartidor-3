package edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorAccionesRepartidores {

	public ServiceRepartidor repartidores;
	private Long idDeLaPersonaEnCurso;
	
	public ControladorAccionesRepartidores(ServiceRepartidor repartidor) {
		this.repartidores=repartidor;
		this.idDeLaPersonaEnCurso=(long)0;
	}
	
	/* -------------CON FORMULARIO---------------
	 * 
		-> GET le pasamos la informacion a la pagina.
			se hace mediante Model modeL
    			usando : model.addAttribute()
			
		-> mediante POST recibimos los datos que nos mandan informacion
		desde la pagina web
			- @ModelAttribute("persona") Persona persona  -> recibimos el objeto formado en formulario
			- String action  -> recibimos la accion realizada
	 * */
	
	
	
	
    @GetMapping({"/cargar_un_repartidor/"})
    public String cargarDatosRepartidor(Model model, String error) {
    	
    	model.addAttribute("cantidadDeRepartidores",this.repartidores.numero_de_elementos_en_database());
    	model.addAttribute("repartidor", this.repartidores.buscarPorID(idDeLaPersonaEnCurso));
        return "/repartidor/registroRepartidor";
    }
    
    @PostMapping("/repartidor/")
    public String procesarAccionesDeLaPaginaDeInicio(String action, @ModelAttribute("repartidor") Repartidor repartidor, Model model) {
      
    	switch (action) {
			case "mostrarAnterior" :
			{
				idDeLaPersonaEnCurso = this.idDeLaPersonaEnCurso - 1;
				if (idDeLaPersonaEnCurso < 1 ) {
					idDeLaPersonaEnCurso = (long) this.repartidores.numero_de_elementos_en_database();
		        }
				
				break;
			}
			case "mostrarSiguiente" :
			{
			   idDeLaPersonaEnCurso = idDeLaPersonaEnCurso + 1;
	            if (idDeLaPersonaEnCurso > (this.repartidores.numero_de_elementos_en_database())) {
	                idDeLaPersonaEnCurso = (long) 1;
	            }
				
				break;
			}
			case "limpiarDatos" :
			{
				idDeLaPersonaEnCurso = (long) 0;
				
				break;
			}
			case "guardar" :
			{
				this.repartidores.registrarEnDatabase(repartidor);
				break;
			}
			case "editar" :
			{
				Long id2=this.idDeLaPersonaEnCurso;
				Repartidor dummy=new Repartidor();
				dummy=repartidor;
				
				
				//this.repartidores.borrar(idDeLaPersonaEnCurso);
				this.repartidores.actualizar(dummy);
				break;
			}
			case "borrar" :
			{
				this.repartidores.borrarElemento(idDeLaPersonaEnCurso);		
				break;
			}
			
			default:{
				break;
			}
				
		}
    	
    
        return "redirect:/cargar_un_repartidor/";
    }
    
	
}
