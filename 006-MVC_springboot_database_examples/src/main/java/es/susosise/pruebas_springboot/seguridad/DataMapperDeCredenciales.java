package es.susosise.pruebas_springboot.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class DataMapperDeCredenciales {
    
    public enum Rol {
        ROLE_CURRELA,
        ROLE_ADMINISTRADOR,
        ROLE_VISITANTE
    }

    public static Credencial pasarDeCredencialDTOaCredencial(CredencialDTO credencialDTO) {
        Credencial credencial = new Credencial();
        credencial.setIdInterno(credencialDTO.idInterno);
        credencial.setEstaActiva(credencialDTO.estaActiva);
        credencial.setNombreDeUsuario(credencialDTO.nombreDeUsuario);
        credencial.setContraseña(credencialDTO.contraseña);
        if (credencialDTO.tieneRolAdministrador) { credencial.asignarleUnRol(Rol.ROLE_ADMINISTRADOR); }
        if (credencialDTO.tieneRolCurrela) { credencial.asignarleUnRol(Rol.ROLE_CURRELA); }
        if (credencialDTO.tieneRolVisitante) { credencial.asignarleUnRol(Rol.ROLE_VISITANTE); }
        return credencial;
    }
    
    public static CredencialDTO pasarDeCredencialACredencialDTO(Credencial credencial) {
        CredencialDTO credencialDTO = new CredencialDTO();
        credencialDTO.idInterno = credencial.getIdInterno();
        credencialDTO.estaActiva = credencial.estaActiva();
        credencialDTO.nombreDeUsuario = credencial.getNombreDeUsuario();
        credencialDTO.contraseña =  credencial.getContraseña();
        for(Rol rol : credencial.getRolesAsignados()) {
            switch (rol) {
                case ROLE_CURRELA:
                    credencialDTO.tieneRolCurrela = true;
                    break;
                case ROLE_ADMINISTRADOR:
                    credencialDTO.tieneRolAdministrador = true;
                    break;
                case ROLE_VISITANTE:
                    credencialDTO.tieneRolVisitante = true;
                    break;
            }
        }
        return credencialDTO;
    }

    
    public static User pasarDeCredencialAUserServiceDetails(Credencial credencial) {
        List<GrantedAuthority> roles = new ArrayList<>();
        for(Rol rol : credencial.getRolesAsignados()) {
            roles.add(new SimpleGrantedAuthority(rol.name()));
        }
        // (username, password, 
        //  enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, 
        //  authorities)
        return new User(credencial.getNombreDeUsuario(), credencial.getContraseña(), 
                        credencial.estaActiva(), credencial.estaActiva(), credencial.estaActiva(), credencial.estaActiva(),
                        roles);
    }
    
}
