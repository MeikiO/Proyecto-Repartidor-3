package es.susosise.pruebas_springboot.personas;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Telefonos {
    
    @Autowired 
    PersistenciaDeTelefonos persistencia;
    
    
    public Optional<Telefono> buscarPorNumero(String numero) {
        return persistencia.findByNumero(numero);
    }

    
    public void guardar(Telefono telefono) {
        persistencia.save(telefono);
    }
    
    public ArrayList<Telefono> getTelefonosParaPruebas() {
        return new ArrayList<>();
    }
    
    public void crearTelefonosParaPruebas() {
        
    }
    
    //TODO pendiente añadir telefonos para pruebas
    
}
