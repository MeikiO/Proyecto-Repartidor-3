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

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pedidos")
public class Pedido_Pojo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Long id;
	
	private String estado_pedido;
	
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
	
    @OneToOne
    @JoinColumn(name = "puntoReparto_id") 
    private PuntoReparto_Pojo puntoReparto;
	
    
    /* Al guardar los pedidos con todos los linea de pedido da el 
     error:object references an unsaved transient instance - save the transient instance before flushing: edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Pojo
     
     +Para arreglar eso guardamos todo en cascada.
     
     Link de referencia:
     ->https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/ 

     */
    
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="lineapedido_id")
    private List<LineaPedido_Pojo> listaLineas;
	
    
//////////////////////////////////////////////////
	
	public Pedido_Pojo() {
		this.listaLineas=new ArrayList<>();
	}


	public Pedido_Pojo(Long id, String estado_pedido, String observaciones, PuntoReparto_Pojo puntoReparto,
			List<LineaPedido_Pojo> listaLineas) {
		super();
		this.id = id;
		this.estado_pedido = estado_pedido;
		this.observaciones = observaciones;
		this.puntoReparto = puntoReparto;
		this.listaLineas = listaLineas;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEstado_pedido() {
		return estado_pedido;
	}


	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
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


	public List<LineaPedido_Pojo> getListaLineas() {
		return listaLineas;
	}


	public void setListaLineas(List<LineaPedido_Pojo> listaLineas) {
		this.listaLineas = listaLineas;
	}
	
}