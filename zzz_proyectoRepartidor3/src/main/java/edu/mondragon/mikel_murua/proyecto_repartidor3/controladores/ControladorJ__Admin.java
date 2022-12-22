package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Estado_Pedido;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedidos_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.Queja_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Repository;

@Controller
public class ControladorJ__Admin {

	private Pedidos_Repository pedidos_repository;
	private PuntoReparto_Repository punto_reparto_repository;
	private Repartidor_Repository repartidor_repository;
	private Queja_Repository queja_repository;
	private LineaPedido_Repository linea_repository;
	
	
	public ControladorJ__Admin(Pedidos_Repository pedidos_repository, PuntoReparto_Repository punto_reparto_repository,
			Repartidor_Repository repartidor_repository, Queja_Repository queja_repository,
			LineaPedido_Repository linea_repository) {
		super();
		this.pedidos_repository = pedidos_repository;
		this.punto_reparto_repository = punto_reparto_repository;
		this.repartidor_repository = repartidor_repository;
		this.queja_repository = queja_repository;
		this.linea_repository = linea_repository;
	}

	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
    //todos pueden entrar a todo, pero lo limitamos usando el rol.
    
	
    @GetMapping({"/admin/entrada"})
    public String redirigirAVentanaDeAdmin(Model model) {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	System.out.println(roles);
    	
    	model.addAttribute("num_pedidos",this.pedidos_repository.count());
    	model.addAttribute("num_clientes",this.punto_reparto_repository.count());
    	model.addAttribute("num_repartidores",this.repartidor_repository.count());
    	model.addAttribute("num_quejas",this.queja_repository.count());	
    	
        return "/v_admin/panel_control_admin";
    }
    
    
    public Map<String,List<Pedido_Pojo>> extraerMapaNecesario(){
    	Map<String,List<Pedido_Pojo>> mapaPedidosEstados=new HashMap<>();
    	
    	//para enseñarlo agrupado
    	
    	for(Estado_Pedido actual:Estado_Pedido.values()) {
    		
    		if(actual!=Estado_Pedido.ESTADO_HACIENDO_EL_PEDIDO && actual!=Estado_Pedido.ESTADO_EN_ESPERA_DE_EMPEZAR_REPARTO) {
    			List<Pedido_Pojo> listaExtraida=this.pedidos_repository.findByEstadoPedido(actual.toString());
    			mapaPedidosEstados.put(actual.toString(), listaExtraida);
    		}
    	}
    	
    	return mapaPedidosEstados;
    }
    
    @GetMapping({"/admin/consultarPedidos"})
    public String consultarPedidos(Model model) {
    	   	
    	Map<String,List<Pedido_Pojo>> mapaPedidosEstados=this.extraerMapaNecesario();
    	model.addAttribute("mapa", mapaPedidosEstados);
    	
       	/*Los links usados
		   	 -> para usar maps en los templates:
		   	 https://stackoverflow.com/questions/28621301/how-to-use-map-getkey-in-thymeleaf-broadleaf-ecom
		   	 
		   	 -> Para usar if, y elses:
		   	 https://stackoverflow.com/questions/13494078/how-to-do-if-else-in-thymeleaf
		*/
 
    	model.addAttribute("pedido",null);
    	model.addAttribute("puntoReparto", null);
    	
    	
        return "/v_admin/consultar_pedidos";
    }
    
    @GetMapping({"/admin/verPedido/{id}"})
    public String consultarPedidos(@PathVariable String id,Model model) {
    	
    	Map<String,List<Pedido_Pojo>> mapaPedidosEstados=this.extraerMapaNecesario();
    	model.addAttribute("mapa", mapaPedidosEstados);
    	
    	long id_pedido=(long)Integer.parseInt(id);
    	
    	Optional<Pedido_Pojo> pedidoSeleccionado = this.pedidos_repository.findById(id_pedido);
    	Pedido_Pojo pedido=pedidoSeleccionado.get();
    	
    	Set<LineaPedido_Pojo> listaLinea = this.linea_repository.findByPedido_id(id_pedido);
    	pedido.setListaLineas(listaLinea);
     	model.addAttribute("pedido",pedido);
    	
     	model.addAttribute("puntoReparto", pedido.getPuntoReparto());
    	
 
    	
        return "/v_admin/consultar_pedidos";
    }
    
    
    
    @GetMapping({"/admin/consultarClientes"})
    public String consultarClientes(Model model) {
    	
        return "/v_admin/consultar_clientes";
    }
    
    @GetMapping({"/admin/consultarRepartidores"})
    public String consultarRepartidores(Model model) {
    	
        return "/v_admin/consultar_repartidores";
    }
    
    @GetMapping({"/admin/consultarQuejas"})
    public String consultarQuejas(Model model) {
    	
        return "/v_admin/consultar_quejas";
    }
    
    @GetMapping({"/admin/asignarPedidos"})
    public String asignarPedidos(Model model) {
    	
        return "/v_admin/asignar_pedidos";
    }
    
}
