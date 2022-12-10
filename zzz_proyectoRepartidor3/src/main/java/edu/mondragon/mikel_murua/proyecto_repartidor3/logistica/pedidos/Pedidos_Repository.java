package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;

public interface Pedidos_Repository extends JpaRepository<Pedido_Pojo, Long> {
	List<Pedido_Pojo> findByPuntoReparto(PuntoReparto_Pojo puntoReparto);
	List<Pedido_Pojo> findByEstadoPedido(String estadoPedido);
}
