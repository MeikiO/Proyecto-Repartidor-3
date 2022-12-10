package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;

@Entity
@Table(name="lineapedidos")
public class LineaPedido_Pojo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "lineapedido_id")
	private Long id;
	
	private int candidad;

	
////////////////////////////////////////
	
	@ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido_Pojo pedido;
	
	
    @OneToOne
    @JoinColumn(name = "producto_id")
	Producto_Pojo producto;
	
////////////////////////////////////////
	
    public LineaPedido_Pojo() {
	}

	public LineaPedido_Pojo(Long id, int candidad, Pedido_Pojo pedido, Producto_Pojo producto) {
	super();
	//this.id = id;
	this.candidad = candidad;
	this.pedido = pedido;
	this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCandidad() {
		return candidad;
	}

	public void setCandidad(int candidad) {
		this.candidad = candidad;
	}

	public Pedido_Pojo getPedido() {
		return pedido;
	}

	public void setPedido(Pedido_Pojo pedido) {
		this.pedido = pedido;
	}

	public Producto_Pojo getProducto() {
		return producto;
	}

	public void setProducto(Producto_Pojo producto) {
		this.producto = producto;
	}

	

	
}
