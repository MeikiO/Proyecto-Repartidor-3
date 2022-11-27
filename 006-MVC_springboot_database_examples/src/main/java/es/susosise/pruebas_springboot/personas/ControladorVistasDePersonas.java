package es.susosise.pruebas_springboot.personas;

import es.susosise.pruebas_springboot.poblaciones.Poblaciones;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class ControladorVistasDePersonas {
    
    @Autowired
    private Personas personas;
    
    @Autowired
    private Poblaciones poblaciones;
    

    @GetMapping("/personas")
    public String redirigirAPaginaConID(Model model) {
        return "redirect:/personas/0";
    }

    @GetMapping("/personas/{id}")
    public String mostrarPaginaDePersonas(@PathVariable String id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("nombreDelUsuario", auth.getName());
        model.addAttribute("cantidadDePersonas", personas.getCuantasHay());
        model.addAttribute("personas", personas.getTodas());
        Long idPersona;
        try {
            idPersona = Long.parseLong(id);
        }catch (NumberFormatException ex) {
            idPersona = (long)0;
        }
        model.addAttribute("persona", personas.buscarPorIdentificador(idPersona));
        model.addAttribute("poblaciones", poblaciones.getTodas());
        return "personas";
    }
    
    @PostMapping("/personas")
    public String procesarAccionesDeLaPaginaDePersonas(String action, @ModelAttribute("persona") Persona persona, Model model) {
        switch (action) {
            case "limpiarDatos":
                return "redirect:/personas/0";
            case "guardar":
                personas.guardar(persona);
                return "redirect:/personas/" + persona.getIdInterno();
            case "eliminar":
                personas.eliminar(persona);
                return "redirect:/personas/0";
            default:
                return "redirect:/personas/0";
        }
    }
    
}
