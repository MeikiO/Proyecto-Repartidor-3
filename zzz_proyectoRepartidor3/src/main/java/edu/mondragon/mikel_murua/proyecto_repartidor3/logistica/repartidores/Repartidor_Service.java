package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

public class Repartidor_Service implements DaoServices<Repartidor_Pojo> {

	private Repartidor_Repository repartidor;
	
	public Repartidor_Service(Repartidor_Repository repartidor) {
		super();
		this.repartidor = repartidor;
	}
	
	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public Repartidor_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(Repartidor_Pojo objeto) {
	}

	@Override
	public void actualizar(Repartidor_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}

}
