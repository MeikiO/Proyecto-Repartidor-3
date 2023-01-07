package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.ruta_repartos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Pojo;

@Entity
@Table(name="rutas")
public class RutaRepartos_Pojo {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ruta_id")
	private Long id;
	
/////////////////////////////////
	
	@OneToMany
    @JoinColumn(name="pedido_id")
    private Set<Pedido_Pojo> listaPedidos;
    
    @OneToOne
    @JoinColumn(name = "repartidor_id") 
    private Repartidor_Pojo repartidor;
	
////////////////////////////////	
	
    public RutaRepartos_Pojo() {
    	this.listaPedidos= new HashSet<>();
	}

	public RutaRepartos_Pojo(Long id, Set<Pedido_Pojo> listaPedidos, Repartidor_Pojo repartidor) {
		super();
		this.id = id;
		this.listaPedidos = listaPedidos;
		this.repartidor = repartidor;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Pedido_Pojo> getListaPedidos() {
		return listaPedidos;
	}
	
	public void setListaPedidos(Set<Pedido_Pojo> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public Repartidor_Pojo getRepartidor() {
		return repartidor;
	}
	
	public void setRepartidor(Repartidor_Pojo repartidor) {
		this.repartidor = repartidor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaPedidos == null) ? 0 : listaPedidos.hashCode());
		result = prime * result + ((repartidor == null) ? 0 : repartidor.hashCode());
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
		RutaRepartos_Pojo other = (RutaRepartos_Pojo) obj;
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
		if (repartidor == null) {
			if (other.repartidor != null)
				return false;
		} else if (!repartidor.equals(other.repartidor))
			return false;
		return true;
	}

}
