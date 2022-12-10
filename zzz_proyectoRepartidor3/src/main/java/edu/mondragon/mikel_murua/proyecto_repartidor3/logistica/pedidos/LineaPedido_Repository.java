package edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaPedido_Repository extends JpaRepository<LineaPedido_Pojo, Long> {
	Set<LineaPedido_Pojo> findByPedido_id(Long pedido_id);
}
