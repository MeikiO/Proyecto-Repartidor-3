package es.susosise.pruebas_springboot.seguridad;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import es.susosise.pruebas_springboot.poblaciones.Poblacion;
import es.susosise.pruebas_springboot.seguridad.DataMapperDeCredenciales.Rol;

@Service
public class Credenciales {

    @Autowired
    private PersistenciaDeCredenciales persistencia;
    
    public Credenciales(PersistenciaDeCredenciales persistencia) {
        this.persistencia = persistencia;
    }
    

    public Long getCuantasHay() {
        return persistencia.count();
    }
    
    public Optional<Credencial> buscarPorNombreDeUsuario(String nombre) {
        return persistencia.findByNombreDeUsuario(nombre);
    }
    
    
    public Credencial buscarPorIdentificador(Long idInterno) {
        Optional<Credencial> credencial = persistencia.findById(idInterno);
        if (credencial.isPresent()) {
            return credencial.get();
        }else {
            return new Credencial();
        }
    }
    
    @Secured("ROLE_ADMINISTRADOR")
    public void guardar(Credencial credencial) {
        if (!credencial.getNombreDeUsuario().isBlank() 
            && !credencial.getContraseña().isBlank()) {
            persistencia.save(credencial);
        }
    }
    
    @Secured("ROLE_ADMINISTRADOR")
    public void eliminar(Credencial credencial) {
        persistencia.delete(credencial);
    }
    
    
    
    public void crearCredencialesParaPruebas() {
        if(buscarPorNombreDeUsuario("pruebas").isEmpty()) {
            Credencial credencial = new Credencial();
            credencial.setNombreDeUsuario("pruebas");
            credencial.setContraseña("mko");
            credencial.setEstaActiva(true);
            credencial.asignarleUnRol(Rol.ROLE_CURRELA);
            guardar(credencial);
        }
        if(buscarPorNombreDeUsuario("pruebasAdministrador").isEmpty()) {
            Credencial credencial = new Credencial();
            credencial.setNombreDeUsuario("pruebasAdministrador");
            credencial.setContraseña("zaq");
            credencial.setEstaActiva(true);
            credencial.asignarleUnRol(Rol.ROLE_CURRELA);
            credencial.asignarleUnRol(Rol.ROLE_ADMINISTRADOR);
            guardar(credencial);
        }
        if(buscarPorNombreDeUsuario("pruebasVisitante").isEmpty()) {
            Credencial credencial = new Credencial();
            credencial.setNombreDeUsuario("pruebasVisitante");
            credencial.setContraseña("123");
            credencial.setEstaActiva(true);
            credencial.asignarleUnRol(Rol.ROLE_VISITANTE);
            guardar(credencial);
        }

    }
    
}
