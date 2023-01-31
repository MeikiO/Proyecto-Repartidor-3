package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;


public interface PuntoReparto_Repository extends JpaRepository<PuntoReparto_Pojo, Long> {
	PuntoReparto_Pojo findByUser(UserAccount_Pojo user);
}
