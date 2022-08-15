package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;



@Entity
@Table(name="puntoReparto")
public class PuntoReparto_Pojo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "puntoReparto_id")
    private Long id;
	
	
	private String nombre_cliente;
	private String apellidos_cliente;
	private String tlf1_cliente;
	private String tlf2_cliente;
	private String tlf3_cliente;
	
	@Column(nullable = false, unique = true)
    private String direccion;
	
	private String color_puntero;
	
	
	
	// se pone aqui para ahorrarse conexiones de database
	// que puedan traer errores futuros
	private double coordenadasLatitud;
	private double coordenadasLongitud;
	
	
 
////////////////////////////////////////
/*

 https://www.adictosaltrabajo.com/2020/04/02/hibernate-onetoone-onetomany-manytoone-y-manytomany/  
 
 */    
    @OneToOne
    @JoinColumn(name = "poblacion_id") 
    private Poblacion_Pojo poblacion;
    
    //para el siguiente paso cuando separemos cliente de punto de entrega
    //private Long id_cliente;
    
   
    
//////////////////////////////////////////////////    
    

    public PuntoReparto_Pojo() {
	}

	public PuntoReparto_Pojo(Long id, String nombre_cliente, String apellidos_cliente, String tlf1_cliente,
			String tlf2_cliente, String tlf3_cliente, String direccion, String color_puntero, double coordenadasLatitud,
			double coordenadasLongitud, Poblacion_Pojo poblacion) {
		super();
		this.id = id;
		this.nombre_cliente = nombre_cliente;
		this.apellidos_cliente = apellidos_cliente;
		this.tlf1_cliente = tlf1_cliente;
		this.tlf2_cliente = tlf2_cliente;
		this.tlf3_cliente = tlf3_cliente;
		this.direccion = direccion;
		this.color_puntero = color_puntero;
		this.coordenadasLatitud = coordenadasLatitud;
		this.coordenadasLongitud = coordenadasLongitud;
		this.poblacion = poblacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellidos_cliente() {
		return apellidos_cliente;
	}

	public void setApellidos_cliente(String apellidos_cliente) {
		this.apellidos_cliente = apellidos_cliente;
	}

	public String getTlf1_cliente() {
		return tlf1_cliente;
	}

	public void setTlf1_cliente(String tlf1_cliente) {
		this.tlf1_cliente = tlf1_cliente;
	}

	public String getTlf2_cliente() {
		return tlf2_cliente;
	}

	public void setTlf2_cliente(String tlf2_cliente) {
		this.tlf2_cliente = tlf2_cliente;
	}

	public String getTlf3_cliente() {
		return tlf3_cliente;
	}

	public void setTlf3_cliente(String tlf3_cliente) {
		this.tlf3_cliente = tlf3_cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getColor_puntero() {
		return color_puntero;
	}

	public void setColor_puntero(String color_puntero) {
		this.color_puntero = color_puntero;
	}

	public double getCoordenadasLatitud() {
		return coordenadasLatitud;
	}

	public void setCoordenadasLatitud(double coordenadasLatitud) {
		this.coordenadasLatitud = coordenadasLatitud;
	}

	public double getCoordenadasLongitud() {
		return coordenadasLongitud;
	}

	public void setCoordenadasLongitud(double coordenadasLongitud) {
		this.coordenadasLongitud = coordenadasLongitud;
	}

	public Poblacion_Pojo getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Poblacion_Pojo poblacion) {
		this.poblacion = poblacion;
	}
    

}
