package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos;

import java.awt.Color;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;

@Entity
@Table(name="productos")
public class Producto_Pojo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Long id;
	private String nombre;
	private String precio_producto;
	private String descripcion;
	private double descuento;
	
	public Producto_Pojo() {
	}

	public Producto_Pojo(Long id, String nombre, String precio_producto, String descripcion, double descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio_producto = precio_producto;
		this.descripcion = descripcion;
		this.descuento = descuento;
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

	public String getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(String precio_producto) {
		this.precio_producto = precio_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
}
