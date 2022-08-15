package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

@Service
@Transactional
public class Pedidos_Service implements DaoServices<Pedido_Pojo>{
	
	private Pedidos_Repository pedidos;
	
	public Pedidos_Service() {
	}

	
	public Pedidos_Service(Pedidos_Repository pedidos) {
		super();
		this.pedidos = pedidos;
	}


	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public Pedido_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(Pedido_Pojo objeto) {
	}

	@Override
	public void actualizar(Pedido_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}
	
	
}
