package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.ruta_repartos.RutaRepartos_Pojo;

@Entity
@Table(name="repartidores")
public class Repartidor_Pojo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "repartidor_id")
	private Long id;
	
	private String nombre;
	private String apellidos;
	
	private String dni;
	private String tlf;
	private String tlf2;
	private String tlf3;
	private String direccion;
	

////////////////////////////////////////
	
    @OneToOne
    @JoinColumn(name = "poblacion_id") 
    private Poblacion_Pojo poblacion;
    
    @OneToOne
    @JoinColumn(name = "ruta_id") 
    private RutaRepartos_Pojo ruta;
    
     
////////////////////////////////////////

	
	public Repartidor_Pojo() {
	}

	
	public Repartidor_Pojo(Long id, String nombre, String apellidos, String dni, String tlf, String tlf2, String tlf3,
			String direccion, Poblacion_Pojo poblacion, RutaRepartos_Pojo ruta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.tlf = tlf;
		this.tlf2 = tlf2;
		this.tlf3 = tlf3;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.ruta = ruta;
	}
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
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
	
	
	public String getTlf() {
		return tlf;
	}
	
	
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	
	
	public String getTlf2() {
		return tlf2;
	}
	
	
	public void setTlf2(String tlf2) {
		this.tlf2 = tlf2;
	}
	
	
	public String getTlf3() {
		return tlf3;
	}
	
	
	public void setTlf3(String tlf3) {
		this.tlf3 = tlf3;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public Poblacion_Pojo getPoblacion() {
		return poblacion;
	}
	
	
	public void setPoblacion(Poblacion_Pojo poblacion) {
		this.poblacion = poblacion;
	}
	
	
	public RutaRepartos_Pojo getRuta() {
		return ruta;
	}
	
	
	public void setRuta(RutaRepartos_Pojo ruta) {
		this.ruta = ruta;
	}

}
