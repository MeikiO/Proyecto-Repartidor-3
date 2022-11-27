package es.susosise.organizacion_mvc_springboot;

import es.susosise.pruebas_springboot.seguridad.Credencial;
import es.susosise.pruebas_springboot.seguridad.DataMapperDeCredenciales.Rol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CredencialTests {
    
    @Test
    void sePuedenAsignarRolesAUnaCredencial() {
        Credencial credencial = new Credencial();
        assertEquals(0, credencial.getCantidadDeRolesQueTieneAsignados());
        credencial.asignarleUnRol(Rol.ROLE_CURRELA);
        assertEquals(1, credencial.getCantidadDeRolesQueTieneAsignados());
        assertTrue(credencial.getRolesAsignados().contains(Rol.ROLE_CURRELA));
    }
    
    @Test
    void noSeAsignanRolesDuplicadosAUnaCredencial() {
        Credencial credencial = new Credencial();
        assertEquals(0, credencial.getCantidadDeRolesQueTieneAsignados());
        credencial.asignarleUnRol(Rol.ROLE_CURRELA);
        assertEquals(1, credencial.getCantidadDeRolesQueTieneAsignados());
        credencial.asignarleUnRol(Rol.ROLE_CURRELA);
        assertEquals(1, credencial.getCantidadDeRolesQueTieneAsignados());
    }


    @Test
    void sePuedenRetirarRolesAUnaCredencial() {
        Credencial credencial = new Credencial();
        assertEquals(0, credencial.getCantidadDeRolesQueTieneAsignados());
        credencial.asignarleUnRol(Rol.ROLE_CURRELA);
        credencial.asignarleUnRol(Rol.ROLE_ADMINISTRADOR);
        assertEquals(2, credencial.getCantidadDeRolesQueTieneAsignados());
        
        credencial.retirarleUnRol(Rol.ROLE_CURRELA);
        assertEquals(1, credencial.getCantidadDeRolesQueTieneAsignados());
        assertFalse(credencial.getRolesAsignados().contains(Rol.ROLE_CURRELA));
        
        credencial.retirarleUnRol(Rol.ROLE_ADMINISTRADOR);
        assertEquals(0, credencial.getCantidadDeRolesQueTieneAsignados());
    }
    
    @Test
    void noPasaNadaSiSeIntentaRetirarUnRolQueLaCredencialNoTieneAsignado() {
        Credencial credencial = new Credencial();
        assertEquals(0, credencial.getCantidadDeRolesQueTieneAsignados());
        
        credencial.retirarleUnRol(Rol.ROLE_CURRELA);
        assertEquals(0, credencial.getCantidadDeRolesQueTieneAsignados());
        
        credencial.asignarleUnRol(Rol.ROLE_ADMINISTRADOR);
        assertEquals(1, credencial.getCantidadDeRolesQueTieneAsignados());
        credencial.retirarleUnRol(Rol.ROLE_CURRELA);
        assertEquals(1, credencial.getCantidadDeRolesQueTieneAsignados());
    }

    
}
