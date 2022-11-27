package es.susosise.pruebas_springboot.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.susosise.pruebas_springboot.actividades.Actividad;
import es.susosise.pruebas_springboot.poblaciones.Poblaciones;


@Service
public class Personas {
    
    @Autowired
    private PersistenciaDePersonas persistencia;
    
    public Long getCuantasHay() {
        return persistencia.count();
    }

    public List<Persona> getTodas() {
        return persistencia.findAll();
    }
    
    public Optional<Persona> buscarPorNombreYApellidos(String nombre, String apellidos) {
        return persistencia.findByNombreAndApellidos(nombre, apellidos);
    }
    
    public Object buscarPorIdentificador(Long idInterno) {
        Optional<Persona> persona = persistencia.findById(idInterno);
        if (persona.isPresent()) {
            return persona.get();
        } else {
            return new Persona();
        }
    }
    
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void guardar(Persona persona) {
        if (!persona.getNombre().isBlank() 
            && !persona.getApellidos().isBlank()) {
            persistencia.save(persona);
        }
    }
    
    //@Secured({"ROLE_CURRELA, ROLE_ADMINISTRADOR"})
    public void eliminar(Persona persona) {
        persistencia.delete(persona);
    }
 
    
    public List<Persona> getPersonasParaPruebas() {
        ArrayList<Persona> personasParaPruebas = new ArrayList<>();
        Optional<Persona> persona01 = buscarPorNombreYApellidos("nombrePruebas01", "apellidosPruebas01");
        if (persona01.isPresent()) {
            personasParaPruebas.add(persona01.get());
        }
        return personasParaPruebas;
    }
    
    public void crearPersonasParaPruebas(Poblaciones poblaciones, Telefonos telefonos) {
        if(buscarPorNombreYApellidos("nombrePruebas01", "apellidosPruebas01").isEmpty()) {
            Persona persona = new Persona();
            persona.setNombre("nombrePruebas01");
            persona.setApellidos("apellidosPruebas01");
            persona.setDni_cedula_pasaporte_o_similar("documentoPruebas01");
            persona.setPoblacion(poblaciones.getPoblacionParaPruebas());
            ArrayList<Telefono> telefonosDeContacto = new ArrayList<>();
            persona.setTelefonos(telefonos.getTelefonosParaPruebas());
            guardar(persona);
        }
        //TODO pendiente añadir mas personas para pruebas
    }
   

}
