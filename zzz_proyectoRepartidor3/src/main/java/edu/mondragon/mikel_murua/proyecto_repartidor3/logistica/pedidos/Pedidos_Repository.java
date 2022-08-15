package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;

public interface Pedidos_Repository extends JpaRepository<Pedido_Pojo, Long> {

}
