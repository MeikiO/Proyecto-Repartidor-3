package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;

@Entity
@Table(name="queja")
public class Queja_Pojo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "queja_id")
	private Long id;
	
	private Date fechaQueja;
	
    @OneToOne
    @JoinColumn(name="puntoReparto_id")
	private PuntoReparto_Pojo punto;
	
    @OneToOne
    @JoinColumn(name = "pedido_id") 
    private Pedido_Pojo pedido;
    
	private String clasificacion;
	private String razones;

	public Queja_Pojo() {
	}

	public Queja_Pojo(Long id, Date fechaQueja, PuntoReparto_Pojo punto, Pedido_Pojo pedido, String clasificacion,
			String razones) {
		super();
		this.id = id;
		this.fechaQueja = fechaQueja;
		this.punto = punto;
		this.pedido = pedido;
		this.clasificacion = clasificacion;
		this.razones = razones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaQueja() {
		return fechaQueja;
	}

	public void setFechaQueja(Date date) {
		this.fechaQueja = date;
	}

	public PuntoReparto_Pojo getPunto() {
		return punto;
	}

	public void setPunto(PuntoReparto_Pojo punto) {
		this.punto = punto;
	}

	public Pedido_Pojo getPedido() {
		return pedido;
	}

	public void setPedido(Pedido_Pojo pedido) {
		this.pedido = pedido;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getRazones() {
		return razones;
	}

	public void setRazones(String razones) {
		this.razones = razones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasificacion == null) ? 0 : clasificacion.hashCode());
		result = prime * result + ((fechaQueja == null) ? 0 : fechaQueja.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((punto == null) ? 0 : punto.hashCode());
		result = prime * result + ((razones == null) ? 0 : razones.hashCode());
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
		Queja_Pojo other = (Queja_Pojo) obj;
		if (clasificacion == null) {
			if (other.clasificacion != null)
				return false;
		} else if (!clasificacion.equals(other.clasificacion))
			return false;
		if (fechaQueja == null) {
			if (other.fechaQueja != null)
				return false;
		} else if (!fechaQueja.equals(other.fechaQueja))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (punto == null) {
			if (other.punto != null)
				return false;
		} else if (!punto.equals(other.punto))
			return false;
		if (razones == null) {
			if (other.razones != null)
				return false;
		} else if (!razones.equals(other.razones))
			return false;
		return true;
	}

	
	
}
