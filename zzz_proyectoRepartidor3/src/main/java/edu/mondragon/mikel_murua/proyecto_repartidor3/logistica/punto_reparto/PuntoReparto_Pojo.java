package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto;

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
import javax.persistence.Transient;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;



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
	
	@Column(nullable = false, unique = true)
    private String dni;
	
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
    
   
    @OneToOne
    @JoinColumn(name = "credenciales_id") 
    private UserAccount_Pojo user;
    
	@OneToMany
	@JoinColumn(name="pedido_id")
	//@org.hibernate.annotations.ForeignKey(name = "none")
	//desabilitamos la comprobacion del foreign key de pedidos por que sino nos dara error
	// link-> https://stackoverflow.com/questions/41729709/how-do-i-disable-hibernate-foreign-key-constraint-on-a-bidirectional-association
	private Set<Pedido_Pojo> lista_pedidos;
    
//////////////////////////////////////////////////    
    

    public PuntoReparto_Pojo() {
    	this.lista_pedidos=new HashSet<>();
	}

	public PuntoReparto_Pojo(Long id, String nombre_cliente, String apellidos_cliente, String tlf1_cliente,
			String tlf2_cliente, String tlf3_cliente, String direccion, String dni, String color_puntero,
			double coordenadasLatitud, double coordenadasLongitud, Poblacion_Pojo poblacion, UserAccount_Pojo user,
			Set<Pedido_Pojo> lista_pedidos) {
		super();
		this.id = id;
		this.nombre_cliente = nombre_cliente;
		this.apellidos_cliente = apellidos_cliente;
		this.tlf1_cliente = tlf1_cliente;
		this.tlf2_cliente = tlf2_cliente;
		this.tlf3_cliente = tlf3_cliente;
		this.direccion = direccion;
		this.dni = dni;
		this.color_puntero = color_puntero;
		this.coordenadasLatitud = coordenadasLatitud;
		this.coordenadasLongitud = coordenadasLongitud;
		this.poblacion = poblacion;
		this.user = user;
		this.lista_pedidos = lista_pedidos;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public UserAccount_Pojo getUser() {
		return user;
	}

	public void setUser(UserAccount_Pojo user) {
		this.user = user;
	}

	public Set<Pedido_Pojo> getLista_pedidos() {
		return lista_pedidos;
	}

	public void setLista_pedidos(Set<Pedido_Pojo> lista_pedidos) {
		this.lista_pedidos = lista_pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos_cliente == null) ? 0 : apellidos_cliente.hashCode());
		result = prime * result + ((color_puntero == null) ? 0 : color_puntero.hashCode());
		long temp;
		temp = Double.doubleToLongBits(coordenadasLatitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coordenadasLongitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lista_pedidos == null) ? 0 : lista_pedidos.hashCode());
		result = prime * result + ((nombre_cliente == null) ? 0 : nombre_cliente.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
		result = prime * result + ((tlf1_cliente == null) ? 0 : tlf1_cliente.hashCode());
		result = prime * result + ((tlf2_cliente == null) ? 0 : tlf2_cliente.hashCode());
		result = prime * result + ((tlf3_cliente == null) ? 0 : tlf3_cliente.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		PuntoReparto_Pojo other = (PuntoReparto_Pojo) obj;
		if (apellidos_cliente == null) {
			if (other.apellidos_cliente != null)
				return false;
		} else if (!apellidos_cliente.equals(other.apellidos_cliente))
			return false;
		if (color_puntero == null) {
			if (other.color_puntero != null)
				return false;
		} else if (!color_puntero.equals(other.color_puntero))
			return false;
		if (Double.doubleToLongBits(coordenadasLatitud) != Double.doubleToLongBits(other.coordenadasLatitud))
			return false;
		if (Double.doubleToLongBits(coordenadasLongitud) != Double.doubleToLongBits(other.coordenadasLongitud))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lista_pedidos == null) {
			if (other.lista_pedidos != null)
				return false;
		} else if (!lista_pedidos.equals(other.lista_pedidos))
			return false;
		if (nombre_cliente == null) {
			if (other.nombre_cliente != null)
				return false;
		} else if (!nombre_cliente.equals(other.nombre_cliente))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		if (tlf1_cliente == null) {
			if (other.tlf1_cliente != null)
				return false;
		} else if (!tlf1_cliente.equals(other.tlf1_cliente))
			return false;
		if (tlf2_cliente == null) {
			if (other.tlf2_cliente != null)
				return false;
		} else if (!tlf2_cliente.equals(other.tlf2_cliente))
			return false;
		if (tlf3_cliente == null) {
			if (other.tlf3_cliente != null)
				return false;
		} else if (!tlf3_cliente.equals(other.tlf3_cliente))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	


	
}
