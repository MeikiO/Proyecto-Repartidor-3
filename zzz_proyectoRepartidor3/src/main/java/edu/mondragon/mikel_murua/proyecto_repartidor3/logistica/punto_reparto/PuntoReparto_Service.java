package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

@Service
@Transactional
public class PuntoReparto_Service implements DaoServices<PuntoReparto_Pojo>{

	public PuntoReparto_Repository puntos;

	public PuntoReparto_Service(PuntoReparto_Repository puntos) {
		this.puntos = puntos;
	}

	
	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public PuntoReparto_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(PuntoReparto_Pojo objeto) {
	}

	@Override
	public void actualizar(PuntoReparto_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}
	
	
	
}
