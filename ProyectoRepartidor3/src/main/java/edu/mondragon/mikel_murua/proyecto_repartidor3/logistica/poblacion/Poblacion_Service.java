package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo.DaoServices;


@Service
@Transactional
public class Poblacion_Service implements DaoServices<Poblacion_Pojo> {

	public Poblacion_Repository poblaciones;
	
	public Poblacion_Service(Poblacion_Repository poblaciones) {
		this.poblaciones = poblaciones;
	}

	
	@Override
	public Long numero_de_elementos_en_database() {
		return null;
	}

	@Override
	public Poblacion_Pojo buscarPorID(Long id) {
		return null;
	}

	@Override
	public void registrarEnDatabase(Poblacion_Pojo objeto) {
	}

	@Override
	public void actualizar(Poblacion_Pojo objeto) {
	}

	@Override
	public void borrarElemento(Long id) {
	}

}
