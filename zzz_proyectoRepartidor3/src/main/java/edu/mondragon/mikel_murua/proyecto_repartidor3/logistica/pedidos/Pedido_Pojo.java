package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.Queja_Pojo;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pedidos")
public class Pedido_Pojo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Long id;
	
	private String estadoPedido;
	
	private String observaciones;
	
////////////////////////////////////////
	
	
	/*
	 Para hacer la relacion correctamente, en vez de 
	 dejar que hibernate compile la relacion Tabla_id,
	 
	 en las clases ponemos el (@Column(name = "producto_id"))
	 y le hacemos referencia a este. Lo cual facilita el contacto.
	 
	 
	 NOTA ADICIONAL:
	 
	 -> Las relaciones en database(hibernate te hace las 2 direcciones automaticamente)
	 pero nosotros tenemos que definir 1 a 1 la que vallamos a necesitar
	 
	 
	 Ejemplo:
	 
	 Pedidos          Productos
	 
	 (1) -------------->(N) 
	 
	 + 1 pedido tiene N productos dentro de el
	 -> nos sirve para saber que lleva un pedido
	 
	 
	Pedidos          Productos
	 
	 (1)<--------------(N) 
	 
	 + todos los productos disponibles van asignados a un pedido
	 -> sirve para hacer estadisticas de que productos son los mas pedidos
	   
	 
	 De estas 2 conexiones de database que hibernate te hace de forma automatica
	 para nuestra aplicacion solo nos interesa la primera. 1:N

	  y es la que hemos aplicado abajo.
	  
	  la otra no la hemos puesto.
	  
	  
	  
	 -> PD: El sitio de origen de la flecha  Pedidos--> Producto 
	 		la notacion  @OneToMany se pone en Pedidos, si es al contrario
	 		se pondria en Producto.
	  
	 */
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "puntoReparto_id") 
    private PuntoReparto_Pojo puntoReparto;
	
    
    /* Al guardar los pedidos con todos los linea de pedido da el 
     error:object references an unsaved transient instance - save the transient instance before flushing: edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Pojo
     
     +Para arreglar eso guardamos todo en cascada.
     
     Link de referencia:
     ->https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/ 

     */
    
   
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="lineapedido_id")
    //@org.hibernate.annotations.ForeignKey(name = "none")
  	//desabilitamos la comprobacion del foreign key de pedidos por que sino nos dara error
  	// link-> https://stackoverflow.com/questions/41729709/how-do-i-disable-hibernate-foreign-key-constraint-on-a-bidirectional-association
  	
    private Set<LineaPedido_Pojo> listaLineas;
	
   
    private double precio_total;
    
    @OneToOne
    @JoinColumn(name = "queja_id") 
    private Queja_Pojo queja;
    
//////////////////////////////////////////////////
	
	public Pedido_Pojo() {
		this.listaLineas=new HashSet<>();
		this.precio_total=0;
	}

	public Pedido_Pojo(Long id, String estadoPedido, String observaciones, PuntoReparto_Pojo puntoReparto,
			Set<LineaPedido_Pojo> listaLineas, double precio_total, Queja_Pojo queja) {
		super();
		this.id = id;
		this.estadoPedido = estadoPedido;
		this.observaciones = observaciones;
		this.puntoReparto = puntoReparto;
		this.listaLineas = listaLineas;
		this.precio_total = precio_total;
		this.queja = queja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public PuntoReparto_Pojo getPuntoReparto() {
		return puntoReparto;
	}

	public void setPuntoReparto(PuntoReparto_Pojo puntoReparto) {
		this.puntoReparto = puntoReparto;
	}

	public Set<LineaPedido_Pojo> getListaLineas() {
		return listaLineas;
	}

	public void setListaLineas(Set<LineaPedido_Pojo> listaLineas) {
		this.listaLineas = listaLineas;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}

	public Queja_Pojo getQueja() {
		return queja;
	}

	public void setQueja(Queja_Pojo queja) {
		this.queja = queja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoPedido == null) ? 0 : estadoPedido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaLineas == null) ? 0 : listaLineas.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio_total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((puntoReparto == null) ? 0 : puntoReparto.hashCode());
		result = prime * result + ((queja == null) ? 0 : queja.hashCode());
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
		Pedido_Pojo other = (Pedido_Pojo) obj;
		if (estadoPedido == null) {
			if (other.estadoPedido != null)
				return false;
		} else if (!estadoPedido.equals(other.estadoPedido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaLineas == null) {
			if (other.listaLineas != null)
				return false;
		} else if (!listaLineas.equals(other.listaLineas))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (Double.doubleToLongBits(precio_total) != Double.doubleToLongBits(other.precio_total))
			return false;
		if (puntoReparto == null) {
			if (other.puntoReparto != null)
				return false;
		} else if (!puntoReparto.equals(other.puntoReparto))
			return false;
		if (queja == null) {
			if (other.queja != null)
				return false;
		} else if (!queja.equals(other.queja))
			return false;
		return true;
	}

	
}