package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.ruta_repartos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;

@Service
@Transactional
public class RutaRepartos_Service implements DaoServices<RutaRepartos_Pojo> {

	public RutaRepartos_Repository ruta;
	
	public RutaRepartos_Service() {
	}
	
	public RutaRepartos_Service(RutaRepartos_Repository ruta) {
		super();
		this.ruta = ruta;
	}

	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public RutaRepartos_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(RutaRepartos_Pojo objeto) {
	}

	@Override
	public void actualizar(RutaRepartos_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}

}
