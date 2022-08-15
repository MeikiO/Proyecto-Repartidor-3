package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

@Service
@Transactional
public class LineaPedido_Service implements DaoServices<LineaPedido_Pojo> {

	private LineaPedido_Repository linea;
	
	public LineaPedido_Service() {
	}
	
	public LineaPedido_Service(LineaPedido_Repository linea) {
		super();
		this.linea = linea;
	}

	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public LineaPedido_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(LineaPedido_Pojo objeto) {
	}

	@Override
	public void actualizar(LineaPedido_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}

}
