package edu.mondragon.mikel_murua.proyecto_repartidor3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores.ServiceRepartidor;

@Controller
public class Controlador {

	private ServiceRepartidor modeloRepartidor;

	public Controlador(ServiceRepartidor modeloRepartidor) {
		this.modeloRepartidor = modeloRepartidor;
	}

	/*
	 * Cosas Importantes:
	 * 1. Solo hay 1 controlador para toda la aplicacion
	 * 2. MODEL tiene que pasarse OBLIGATORIAMENTE
	 */

	@GetMapping("/") // esta es para la raiz (inicio de aplicacion)
	public String paginaLogin(Model model) {
		// se pasa siempre el modelo a la pagina web que cargamos

		model.addAttribute("nombreEnControlador", "soy un atributo especificado en el controlador");

		// para usar el interface de REPARTIDORPERSISTENCIA X USAMOS EL SERVICE
		model.addAttribute("Numero_de_objetos_database", this.modeloRepartidor.contar_elementos());

		// especificamos que pagina va ha cargar a continuacion (no hace falta poner
		// extension (.html)
		// te lo toma directamente. Y le pasamos el modelo (que se usara como atributo)
		return "login/login";
	}

}
