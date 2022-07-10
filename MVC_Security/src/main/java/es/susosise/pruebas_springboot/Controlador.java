package es.susosise.pruebas_springboot;

import es.susosise.pruebas_springboot.personas.Persona;
import es.susosise.pruebas_springboot.personas.Personas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class Controlador {
    
    private Personas personas;
    private Long idDeLaPersonaEnCurso;
    
    public Controlador(Personas personas) {
        this.personas = personas;
        idDeLaPersonaEnCurso = (long) 0;
    }
    
    
    @GetMapping("/login")
    public String mostrarLaPaginaParaIdentificarUsuario(Model model, String error, String logout) {
        model.addAttribute("error", error);
        return "login";
    }
    
    @PostMapping("/logout")
    public String mostrarLaPaginaDeCierre(Model model) {
        return "logout";
    }
    
    @GetMapping({"/"})
    public String redirigirALaPaginaDeInicio() {
        return "redirect:/pruebas_springboot/";
    }
    
    @GetMapping({"/pruebas_springboot"})
    public String mostrarPaginaDeInicio(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("nombreDelUsuario", auth.getName());
        model.addAttribute("cantidadDePersonas", personas.getCuantasHay());
        model.addAttribute("persona", personas.get(idDeLaPersonaEnCurso));
        return "paginadeinicio";
    }
    
    @PostMapping("/persona")
    public String procesarAccionesDeLaPaginaDeInicio(String action, @ModelAttribute("persona") Persona persona, Model model) {
        // TODO esto son todavia experimentos y pruebas ; no sé si es o no una manera correcta de procesar acciones.
        if (action.equals("mostrarAnterior")) {
            idDeLaPersonaEnCurso = idDeLaPersonaEnCurso - 1;
            if (idDeLaPersonaEnCurso < 1 ) {
                idDeLaPersonaEnCurso = (long) personas.getCuantasHay();
            }
        }else if (action.equals("mostrarSiguiente")) {
            idDeLaPersonaEnCurso = idDeLaPersonaEnCurso + 1;
            if (idDeLaPersonaEnCurso > (personas.getCuantasHay() )) {
                idDeLaPersonaEnCurso = (long) 1;
            }
        }else if (action.equals("limpiarDatos")) {
            idDeLaPersonaEnCurso = (long) 0;
        }else if (action.equals("guardar")) {
            personas.guardar(persona);
        }
        return "redirect:/pruebas_springboot/";
    }
    
}
