package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.ruta_repartos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;

@Entity
@Table(name="rutas")
public class RutaRepartos_Pojo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ruta_id")
	private Long id;
	
/////////////////////////////////
	/*
	@OneToMany
    @JoinColumn(name="pedido_id")
    private List<Pedido_Pojo> listaPedidos;
	*/
////////////////////////////////	
	
    public RutaRepartos_Pojo() {
    	
    	//this.listaPedidos=new ArrayList<>();
	}
    
	public RutaRepartos_Pojo(Long id, List<Pedido_Pojo> listaPedidos) {
		super();
		this.id = id;
		//this.listaPedidos = listaPedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




}
