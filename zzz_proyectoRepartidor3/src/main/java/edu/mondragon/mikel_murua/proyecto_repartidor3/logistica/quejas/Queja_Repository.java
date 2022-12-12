package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;


public interface Queja_Repository extends JpaRepository<Queja_Pojo, Long> {

}
