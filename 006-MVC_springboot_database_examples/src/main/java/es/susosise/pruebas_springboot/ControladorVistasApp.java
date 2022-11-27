package es.susosise.pruebas_springboot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class ControladorVistasApp {
    
    @GetMapping("/login")
    public String mostrarLaPaginaParaIdentificarUsuario(Model model, String error, String logout) {
        model.addAttribute("error", error);
        return "login";
    }
    
    @PostMapping("/logout")
    public String mostrarLaPaginaDeCierre(Model model) {
        return "logout";
    }
    
    @GetMapping("/")
    public String redirigirALaPaginaDeInicioDeLaAplicacion() {
        return "redirect:/personas/0";
    }


}

