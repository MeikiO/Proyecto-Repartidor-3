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
	
	
}
