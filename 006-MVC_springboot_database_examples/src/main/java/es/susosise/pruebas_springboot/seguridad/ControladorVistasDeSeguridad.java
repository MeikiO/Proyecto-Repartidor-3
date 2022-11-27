package es.susosise.pruebas_springboot.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorVistasDeSeguridad {
    
    @Autowired
    private Credenciales credenciales;
    
    private Long idCredencialEnCurso;
    
    public ControladorVistasDeSeguridad() {
        idCredencialEnCurso = (long)0;
    }
    
    
    @GetMapping("/credenciales")
    public String mostrarPaginaDeCredenciales(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("nombreDelUsuario", auth.getName());
        model.addAttribute("cantidadDeCredenciales", credenciales.getCuantasHay());
        Credencial credencialEnCurso = credenciales.buscarPorIdentificador(idCredencialEnCurso);
        model.addAttribute("credencialDTO", DataMapperDeCredenciales.pasarDeCredencialACredencialDTO(credencialEnCurso));
        return "credenciales";
    }
    
    @PostMapping("/credenciales")
    public String procesarAccionesDeLaPaginaDeCredenciales(String action, @ModelAttribute("credencialDTO") CredencialDTO credencialDTO, Model model) {
        // Disculpas: el interface de usuario no es precisamente el más lógico e intuitivo... pero para hacer unas pruebas...
        switch (action) {
        
            case "mostrarAnterior":
               idCredencialEnCurso--;
               if (idCredencialEnCurso < 1) {
                   if (credenciales.getCuantasHay() == 0) {
                       idCredencialEnCurso = (long)0;
                   } else {
                       idCredencialEnCurso = (long)1;
                   }
               }
               break;

            case "mostrarSiguiente":
                idCredencialEnCurso++;
                if (idCredencialEnCurso > credenciales.getCuantasHay()) { idCredencialEnCurso = (long)credenciales.getCuantasHay();}
                break;

            case "limpiarDatos":
                idCredencialEnCurso = (long)0;
                break;

            case "guardar":
                credenciales.guardar(DataMapperDeCredenciales.pasarDeCredencialDTOaCredencial(credencialDTO));
                idCredencialEnCurso = credencialDTO.idInterno;
                if (idCredencialEnCurso == null) { idCredencialEnCurso = (long)0;}
                break;
                
            case "eliminar":
                credenciales.eliminar(DataMapperDeCredenciales.pasarDeCredencialDTOaCredencial(credencialDTO));
                idCredencialEnCurso = (long)0;
                break;
        }
        
        return "redirect:/credenciales";
    }


}
