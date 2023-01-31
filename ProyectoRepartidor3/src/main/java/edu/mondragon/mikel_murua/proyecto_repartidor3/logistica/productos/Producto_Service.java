package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

@Service
@Transactional
public class Producto_Service  implements DaoServices<Producto_Pojo>{

	private Producto_Repository repositorio;
	
	public Producto_Service(Producto_Repository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public Producto_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(Producto_Pojo objeto) {
	}

	@Override
	public void actualizar(Producto_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}

}
