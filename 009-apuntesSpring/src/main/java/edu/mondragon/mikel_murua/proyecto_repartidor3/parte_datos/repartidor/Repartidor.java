package edu.mondragon.mikel_murua.proyecto_repartidor3.parte_datos.repartidor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.informacion_de_reparto.Poblacion;




//Estate tranquilo, Entity de hibernate es hibernate a palo seco, el de javax, es el 
// jpa y relaciona springboot con hibernate.

@Entity
@Table(name="repartidores")
 public class Repartidor{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_repartidor;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String tlf;
	
	private String username;
	
	/*
	 private Long id_credencial; 
	 
		 -> para la parte de seguridad, usaremos el username.
		 
		  -> no usamos un id_credencial, porque si nos lo tomas 
		  pueden acceder directamente a todo. de esta manera
		  podremos acceder a las credenciales con un get_credencial_by_username()
		  
	 */
	
	/*
		 -> El repartidor no tiene una ruta, la ruta tiene repartidores
		  por eso no lo ponemos aqui
	 */
	
	
	//private List<RegistroReparto> listaReparto;

	
	//es obligatorio que haya un constructor vacio y otro completo.
	
	public Repartidor() {
	}

	public Repartidor(Long id_repartidor, String nombre, String apellidos, String dni, String direccion, String tlf,
			String username) {
		super();
		this.id_repartidor = id_repartidor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.tlf = tlf;
		this.username = username;
	}

	public Long getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(Long id_repartidor) {
		this.id_repartidor = id_repartidor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((id_repartidor == null) ? 0 : id_repartidor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tlf == null) ? 0 : tlf.hashCode());
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
		Repartidor other = (Repartidor) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (id_repartidor == null) {
			if (other.id_repartidor != null)
				return false;
		} else if (!id_repartidor.equals(other.id_repartidor))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tlf == null) {
			if (other.tlf != null)
				return false;
		} else if (!tlf.equals(other.tlf))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Repartidor [id_repartidor=" + id_repartidor + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + ", direccion=" + direccion + ", tlf=" + tlf + ", username=" + username + "]";
	}

	
}
