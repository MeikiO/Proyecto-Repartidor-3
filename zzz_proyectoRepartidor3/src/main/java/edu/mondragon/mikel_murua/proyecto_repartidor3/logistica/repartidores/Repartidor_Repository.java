package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;

public interface Repartidor_Repository extends JpaRepository<Repartidor_Pojo,Long> {
	Repartidor_Pojo findByUser(UserAccount_Pojo user);
}
