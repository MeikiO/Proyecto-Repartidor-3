package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores;

import java.util.ArrayList;
import java.util.List;
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

import org.springframework.data.annotation.Transient;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.ruta_repartos.RutaRepartos_Pojo;
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
    
   /* @OneToOne
    @JoinColumn(name = "ruta_id") 
    private RutaRepartos_Pojo ruta;
   */ 
     
    
    @OneToOne
    @JoinColumn(name = "credenciales_id") 
    private UserAccount_Pojo user;
    
    
////////////////////////////////////////

	/*esta lista es para el reparto en el momento, 
	  no se guarda en database, ni tiene relacion con
	  ningun elemento en la database.
	  
	  La usamos unicamente para hacer los repartos
	  
	  Informacion de @transient
	  ->https://stackoverflow.com/questions/64304416/make-certain-fields-in-entity-not-be-saved-to-the-database
	  ->https://javabydeveloper.com/using-transient-in-spring-boot-examples/
    */
    @javax.persistence.Transient
    private List<Pedido_Pojo> listaPedidos;
    
	public Repartidor_Pojo() {
		this.listaPedidos=new ArrayList<>();
	}

	public Repartidor_Pojo(Long id, String nombre, String apellidos, String dni, String tlf, String tlf2, String tlf3,
			String direccion, String gmail, Poblacion_Pojo poblacion, UserAccount_Pojo user,
			List<Pedido_Pojo> listaPedidos) {
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
		
		this.listaPedidos=new ArrayList<>();
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

	public List<Pedido_Pojo> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido_Pojo> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((gmail == null) ? 0 : gmail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaPedidos == null) ? 0 : listaPedidos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
		result = prime * result + ((tlf == null) ? 0 : tlf.hashCode());
		result = prime * result + ((tlf2 == null) ? 0 : tlf2.hashCode());
		result = prime * result + ((tlf3 == null) ? 0 : tlf3.hashCode());
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
		Repartidor_Pojo other = (Repartidor_Pojo) obj;
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
		if (gmail == null) {
			if (other.gmail != null)
				return false;
		} else if (!gmail.equals(other.gmail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaPedidos == null) {
			if (other.listaPedidos != null)
				return false;
		} else if (!listaPedidos.equals(other.listaPedidos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		if (tlf == null) {
			if (other.tlf != null)
				return false;
		} else if (!tlf.equals(other.tlf))
			return false;
		if (tlf2 == null) {
			if (other.tlf2 != null)
				return false;
		} else if (!tlf2.equals(other.tlf2))
			return false;
		if (tlf3 == null) {
			if (other.tlf3 != null)
				return false;
		} else if (!tlf3.equals(other.tlf3))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
}
