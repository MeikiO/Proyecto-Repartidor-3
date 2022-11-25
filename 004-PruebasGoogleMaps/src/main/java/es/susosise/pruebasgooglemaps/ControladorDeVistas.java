package es.susosise.pruebasgooglemaps;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class ControladorDeVistas {
    
    @Autowired
    private ManejoDeRutas rutas;
    
     
    @CrossOrigin
    @GetMapping("pruebasParaAprenderGoogleMaps")
    public String mostrarLaPaginaDeInicio(Model model) {
        Ruta ruta = rutas.getRutaParaPruebas();
        model.addAttribute("nombreDeLaRuta", ruta.getNombre());
        model.addAttribute("descripcionDeLaRuta", ruta.getDescripcion());
        model.addAttribute("latitud", ruta.getRecorrido().get(0).getLatitud());
        model.addAttribute("longitud", ruta.getRecorrido().get(0).getLongitud());
        model.addAttribute("puntosDeLaRuta", ruta.getRecorrido());
        return "pruebasGoogleMaps";
    }
    
 

}

