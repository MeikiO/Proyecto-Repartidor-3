package edu.mondragon.mikel_murua.proyecto_repartidor3.repartidores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.cosas_comunes.Poblacion;


//Estate tranquilo, Entity de hibernate es hibernate a palo seco, el de javax, es el 
// jpa y relaciona springboot con hibernate.
@Entity
@Table(name="repartidores")
public class Repartidor{
	
	private Poblacion zona_trabajo;
	private String tlf;
	private String direccion;
	private String dni;
	private String apellido;
	private String nombre;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_repartidor;
	
	//private List<RegistroReparto> listaReparto;

	
	//es obligatorio que haya un constructor vacio y otro completo.
	public Repartidor() {
	}
	
	public Repartidor(String nombre,String apellido, String dni,String direccion
			,String tlf,String poblacion,String username,String password,boolean admin) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.tlf=tlf;
		this.zona_trabajo=Poblacion.valueOf(poblacion);

		
		//this.listaReparto=new ArrayList<>();
	}
	public Repartidor(Long id_repartidor,String nombre,String apellido, String dni,String direccion
			,String tlf,String poblacion,String username,String password,boolean admin,int id_grupo) {
		
		this.id_repartidor=id_repartidor;
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.tlf=tlf;
		this.zona_trabajo=Poblacion.valueOf(poblacion);
	
		//this.listaReparto=new ArrayList<>();
	}


	public Poblacion getZona_trabajo() {
		return zona_trabajo;
	}

	public void setZona_trabajo(Poblacion zona_trabajo) {
		this.zona_trabajo = zona_trabajo;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


public Long getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(Long id_repartidor) {
		this.id_repartidor = id_repartidor;
	}

	/*
	public List<RegistroReparto> getListaReparto() {
		return listaReparto;
	}

	public void setListaReparto(List<RegistroReparto> listaReparto) {
		this.listaReparto = listaReparto;
	}
*/
	@Override
	public String toString() {
		return ""+this.getNombre()+" "+this.getApellido();
	}


	
	public Poblacion getPoblacion() {
		return this.zona_trabajo;
	}
	public void setPoblacion(Poblacion poblacion) {
		this.zona_trabajo=poblacion;
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
		if (id_repartidor != other.id_repartidor)
			return false;
		return true;
	}

}
