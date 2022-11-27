package es.susosise.pruebas_springboot.poblaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.dao.DataIntegrityViolationException;

@Controller
public class ControladorVistasDePoblaciones {
    
    @Autowired
    private Poblaciones poblaciones;
    

    @GetMapping("/poblaciones")
    public String redirigirAPaginaConID(Model model) {
        return "redirect:/poblaciones/0";
    }
    
    @GetMapping("/poblaciones/{id}")
    public String mostrarPaginaDePoblaciones(@PathVariable String id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("nombreDelUsuario", auth.getName());
        model.addAttribute("cantidadDePoblaciones", poblaciones.getCuantasHay());
        model.addAttribute("poblaciones", poblaciones.getTodas());
        Long idPoblacion;
        try {
            idPoblacion = Long.parseLong(id);
        }catch (NumberFormatException ex) {
            idPoblacion = (long)0;
        }
        model.addAttribute("poblacion", poblaciones.buscarPorIdentificador(idPoblacion));
        return "poblaciones";
    }
    
    @PostMapping("/poblaciones")
    public String procesarAccionesDeLaPaginaDePoblaciones(String action, @ModelAttribute("Poblacion") Poblacion poblacion, RedirectAttributes atributosRedirigidos, Model model) {
        switch (action) {
            case "limpiarDatos":
                return "redirect:/poblaciones/0";
            case "guardar":
                poblaciones.guardar(poblacion);
                return "redirect:/poblaciones/" + poblacion.getIdInterno();
            case "eliminar":
                try {
                    poblaciones.eliminar(poblacion);
                    return "redirect:/poblaciones/0";
                } catch (DataIntegrityViolationException ex) {
                    atributosRedirigidos.addFlashAttribute("error", "No se puede eliminar esta población porque está asignada a una o varias personas.");
                }
            default:
                return "redirect:/poblaciones/0";
        }
    }
     
}
