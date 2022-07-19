package edu.mondragon.mikel_murua.proyecto_repartidor3.parte_datos.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long id_cliente;
	
	
}
