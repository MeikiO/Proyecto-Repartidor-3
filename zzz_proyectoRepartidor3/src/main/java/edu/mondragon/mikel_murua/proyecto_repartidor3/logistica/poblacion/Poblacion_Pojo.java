package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion;

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

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;



@Entity
@Table(name="poblacion")
public class Poblacion_Pojo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "poblacion_id")
	private Long id;
	
	private String codigoPostal;
	private String region;
	private String nombreLocalizacion;
	
	
	public Poblacion_Pojo() {
	}
		

	public Poblacion_Pojo(Long id, String codigoPostal, String region, String nombreLocalizacion) {
		super();
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.region = region;
		this.nombreLocalizacion = nombreLocalizacion;
	}


	public Long getId_poblacion() {
		return id;
	}

	public void setId_poblacion(Long id_poblacion) {
		this.id = id_poblacion;
	}




	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}



	public String getNombreLocalizacion() {
		return nombreLocalizacion;
	}



	public void setNombreLocalizacion(String nombreLocalizacion) {
		this.nombreLocalizacion = nombreLocalizacion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


}
