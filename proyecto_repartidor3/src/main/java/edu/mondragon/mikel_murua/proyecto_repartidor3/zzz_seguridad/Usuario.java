package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class Usuario implements UserDetails {
    @Id
    private Long idInterno;
    
    private boolean estaActivo;
    private String nombre;
    private String contraseña;
    
    public Usuario() {
        
    }
    
    public Usuario(Long idInterno, boolean estaActivo, String nombre, String contraseña) {
        this.idInterno = idInterno;
        this.estaActivo = estaActivo;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }


    public Long getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = new BCryptPasswordEncoder().encode(contraseña);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return estaActivo;
    }

    @Override
    public boolean isAccountNonLocked() {
        return estaActivo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return estaActivo;
    }

    @Override
    public boolean isEnabled() {
        return estaActivo;
    }
    
    

}
