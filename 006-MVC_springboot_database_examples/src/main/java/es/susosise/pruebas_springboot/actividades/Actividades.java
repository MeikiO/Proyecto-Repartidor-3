package es.susosise.pruebas_springboot.actividades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.susosise.pruebas_springboot.personas.Personas;

@Service
public class Actividades {
    
    @Autowired
    private PersistenciaDeActividades persistencia;

    
    public Optional<Actividad> buscarPorTitulo(String titulo) {
        return persistencia.findByTitulo(titulo);
    }
    
    public void guardar(Actividad actividad) {
        persistencia.save(actividad);
    }

    
    public List<Actividad> getActividadesParaPruebas() {
        ArrayList<Actividad> actividadesParaPruebas = new ArrayList<>();
        Optional<Actividad> actividad01 = buscarPorTitulo("Paseo campestre de pruebasYexperimentos");
        if (actividad01.isPresent()) {
            actividadesParaPruebas.add(actividad01.get());
        }
        return actividadesParaPruebas;
    }
    
    public void crearActividadesParaPruebas(Personas personas) {
        if(buscarPorTitulo("Paseo campestre de pruebasYexperimentos").isEmpty()) {
            Actividad actividad = new Actividad();
            actividad.setTitulo("Paseo campestre de pruebasYexperimentos");
            actividad.setDescripcion("Un idílico recorrido por los prados que bordean el rio Drwasf, con merienda sobre el cesped en la ermita de Santa Dewos.");
            actividad.setDia("miercoles 24 Junio");
            actividad.setHora("10:00");
            actividad.setLugarDePartida("frente al ambulatorio");
            actividad.setParticipantes(new HashSet<>(personas.getPersonasParaPruebas()));
            guardar(actividad);
        }
    }

    //TODO pendiente añadir mas actividades para pruebas
    
}
