package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;

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
	private String gmail;

////////////////////////////////////////
	
    @OneToOne
    @JoinColumn(name = "poblacion_id") 
    private Poblacion_Pojo poblacion;
         
    
    @OneToOne
    @JoinColumn(name = "credenciales_id") 
    private UserAccount_Pojo user;
    
/*
    @OneToOne
    @JoinColumn(name = "ruta_id") 
    private RutaRepartos_Pojo ruta;
 
 --> de poner pon toda la lista de pedidos que va ha repartir.
 */  
    
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@org.hibernate.annotations.ForeignKey(name = "none")
    @JoinColumn(name="pedido_id")
    private Set<Pedido_Pojo> listaPedidos;
    
 /////////////////////////////////////////
    
    public Repartidor_Pojo() {
    	this.listaPedidos=new HashSet<>();
	}

public Repartidor_Pojo(Long id, String nombre, String apellidos, String dni, String tlf, String tlf2, String tlf3,
		String direccion, String gmail, Poblacion_Pojo poblacion, UserAccount_Pojo user,
		Set<Pedido_Pojo> listaPedidos) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.dni = dni;
	this.tlf = tlf;
	this.tlf2 = tlf2;
	this.tlf3 = tlf3;
	this.direccion = direccion;
	this.gmail = gmail;
	this.poblacion = poblacion;
	this.user = user;
	this.listaPedidos = listaPedidos;
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

public String getGmail() {
	return gmail;
}

public void setGmail(String gmail) {
	this.gmail = gmail;
}

public Poblacion_Pojo getPoblacion() {
	return poblacion;
}

public void setPoblacion(Poblacion_Pojo poblacion) {
	this.poblacion = poblacion;
}

public UserAccount_Pojo getUser() {
	return user;
}

public void setUser(UserAccount_Pojo user) {
	this.user = user;
}

public Set<Pedido_Pojo> getListaPedidos() {
	return listaPedidos;
}

public void setListaPedidos(Set<Pedido_Pojo> listaPedidos) {
	this.listaPedidos = listaPedidos;
}
	

}
