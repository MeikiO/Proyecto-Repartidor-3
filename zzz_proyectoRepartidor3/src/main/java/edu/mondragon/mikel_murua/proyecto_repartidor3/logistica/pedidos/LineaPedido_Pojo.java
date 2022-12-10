package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	int candidad;
	
////////////////////////////////////////
	
    @OneToOne
    @JoinColumn(name = "producto_id")
	Producto_Pojo producto;
	
////////////////////////////////////////
	
    public LineaPedido_Pojo() {
	}

	public LineaPedido_Pojo(Long id, int candidad, Producto_Pojo producto) {
		super();
		this.id = id;
		this.candidad = candidad;
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
	
	public Producto_Pojo getProducto() {
		return producto;
	}
	
	public void setProducto(Producto_Pojo producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + candidad;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		LineaPedido_Pojo other = (LineaPedido_Pojo) obj;
		if (candidad != other.candidad)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	
}
