package es.susosise.pruebas_springboot.personas;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class Personas {
    
    private PersistenciaPersonas personas;
    
    public Personas(PersistenciaPersonas personas) {
        this.personas = personas;
    }

    public Integer getCuantasHay() {
        return personas.findAll().size();
    }

    public List<Persona> getTodas() {
        return personas.findAll();
    }
    
    public Object get(Long idInterno) {
        Optional<Persona> persona = personas.findById(idInterno);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new Persona();
        }
    }

    public Object get(String nombreYapellidos) {
        // TODO falta ver como podemos buscar una pesona por su nombre y apellidos
        return null;
    }

    
    public void guardar(Persona unaPersona) {
        if (unaPersona.getIdInterno() != null) {
            // TODO actualizar sus datos ,  /¿lo hace Spring Boot el solo ? ?!?
        } else if (!unaPersona.getNombre().isBlank() && !unaPersona.getApellidos().isBlank()) {
            personas.save(unaPersona);
        }
    }
    
    

}
