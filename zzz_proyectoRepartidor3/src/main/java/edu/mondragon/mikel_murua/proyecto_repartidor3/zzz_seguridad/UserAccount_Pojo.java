package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="credencial")
public class UserAccount_Pojo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "credenciales_id")
	private Long idInterno;
    
    private boolean estaActivo;
    
    @Column(nullable = false, unique = true)
    private String username;
    private String contrasena;
    
    private ArrayList<GrantedAuthority> listaRoles;
    
    public UserAccount_Pojo() {
	}
    
   
	public UserAccount_Pojo(Long idInterno, boolean estaActivo, String username, String contrasena,
			ArrayList<GrantedAuthority> listaRoles) {
		super();
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


	public ArrayList<GrantedAuthority> getListaRoles() {
		return listaRoles;
	}


	public void setListaRoles(ArrayList<GrantedAuthority> listaRoles) {
		this.listaRoles = listaRoles;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + (estaActivo ? 1231 : 1237);
		result = prime * result + ((idInterno == null) ? 0 : idInterno.hashCode());
		result = prime * result + ((listaRoles == null) ? 0 : listaRoles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount_Pojo other = (UserAccount_Pojo) obj;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (estaActivo != other.estaActivo)
			return false;
		if (idInterno == null) {
			if (other.idInterno != null)
				return false;
		} else if (!idInterno.equals(other.idInterno))
			return false;
		if (listaRoles == null) {
			if (other.listaRoles != null)
				return false;
		} else if (!listaRoles.equals(other.listaRoles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


    

}
