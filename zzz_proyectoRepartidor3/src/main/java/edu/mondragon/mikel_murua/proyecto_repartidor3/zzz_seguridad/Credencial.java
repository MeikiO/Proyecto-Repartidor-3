package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name="credencial")
public class Credencial implements UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idInterno;
    
    private boolean estaActivo;
    
    
    private String username;
    private String contrasena;
    
    private ArrayList<GrantedAuthority> listaRoles;
    
    
    public Credencial() {
        
    }
    
    
    
    public Credencial(Long idInterno, boolean estaActivo, String username, String contrasena,
			ArrayList<GrantedAuthority> listaRoles) {
		this.idInterno = idInterno;
		this.estaActivo = estaActivo;
		this.username = username;
		this.contrasena = contrasena;
		this.listaRoles = listaRoles;
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



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public ArrayList<GrantedAuthority> getListaRoles() {
		return listaRoles;
	}



	public void setListaRoles(ArrayList<GrantedAuthority> listaRoles) {
		this.listaRoles = listaRoles;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return username;
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



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
    
    

}
