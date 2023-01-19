package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Estado_Pedido;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedidos_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Service;

@Controller
public class ControladorJ__Repartidor {

	private Repartidor_Repository repartidorRepository;
	private UserAccount_Repository userRepository;
	private Pedidos_Repository pedidoRepository;
	private LineaPedido_Repository lineaRepository;
	
	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
    //todos pueden entrar a todo, pero lo limitamos usando el rol.
    
	public ControladorJ__Repartidor(Repartidor_Repository repartidorRepository, UserAccount_Repository userRepository,
			Pedidos_Repository pedidoRepository, LineaPedido_Repository lineaRepository) {
		super();
		this.repartidorRepository = repartidorRepository;
		this.userRepository = userRepository;
		this.pedidoRepository = pedidoRepository;
		this.lineaRepository = lineaRepository;
	}


	@GetMapping({"/repartidor/entrada"})
    public String redirigirAEntradaRepartidor(Model model) {
    		
		model.addAttribute("pedido_seleccionado",null);
		
		
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();

    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	System.out.println(usuarioLogeado);
    	System.out.println(roles);
 	
        UserAccount_Pojo account=this.userRepository.findByUsername(SecurityContextHolder. getContext(). getAuthentication().getName());   	
        Repartidor_Pojo repartidorLogeado=this.repartidorRepository.findByUser(account);
        
 
        model.addAttribute("nombreDeLaRuta", "Ruta de comprobacion");
	    model.addAttribute("descripcionDeLaRuta", "La primera prueba para algo mas grande");
        
        List<Pedido_Pojo> listaConPedidos=new ArrayList<>();
        
        if(!listaConPedidos.isEmpty()) {
		    for(Pedido_Pojo actual: repartidorLogeado.getListaPedidosRepartidor()) {
		    	if(actual.getEstadoPedido().equals(Estado_Pedido.ESTADO_EN_CAMINO.toString())) {
		    		listaConPedidos.add(actual);        		
		    	}
		    }
	  
		    model.addAttribute("latitud", repartidorLogeado.getListaPedidosRepartidor().stream().findFirst().get().getPuntoReparto().getCoordenadasLatitud());
		    model.addAttribute("longitud", repartidorLogeado.getListaPedidosRepartidor().stream().findFirst().get().getPuntoReparto().getCoordenadasLongitud());
		    model.addAttribute("puntosDeLaRuta", listaConPedidos);
	     }
        else {
        	model.addAttribute("latitud", 0);
 		    model.addAttribute("longitud", 0);
 		    model.addAttribute("puntosDeLaRuta", null);
        }
        
        return "/v_repartidor/inicio_repartidores";
    }





	@GetMapping({"/repartidor/verProductos/{id_pedido}"})
    public String redirigirAEntradaRepartidor(Model model,
    		@PathVariable String id_pedido) {
    	
		
		Pedido_Pojo pedido_del_que_se_requiere_producto=this.pedidoRepository.findById((long) Integer.parseInt(id_pedido)).get();
		model.addAttribute("pedido_seleccionado",pedido_del_que_se_requiere_producto);
		
		
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();

    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	System.out.println(usuarioLogeado);
    	System.out.println(roles);
 	
        UserAccount_Pojo account=this.userRepository.findByUsername(SecurityContextHolder. getContext(). getAuthentication().getName());   	
        Repartidor_Pojo repartidorLogeado=this.repartidorRepository.findByUser(account);
        
        List<Pedido_Pojo> listaConPedidos=new ArrayList<>();
        
        for(Pedido_Pojo actual: repartidorLogeado.getListaPedidosRepartidor()) {
        	if(actual.getEstadoPedido().equals(Estado_Pedido.ESTADO_EN_CAMINO.toString())) {
        		listaConPedidos.add(actual);        		
        	}
        }
      
        model.addAttribute("nombreDeLaRuta", "Ruta de comprobacion");
        model.addAttribute("descripcionDeLaRuta", "La primera prueba para algo mas grande");
        model.addAttribute("latitud", repartidorLogeado.getListaPedidosRepartidor().stream().findFirst().get().getPuntoReparto().getCoordenadasLatitud());
        model.addAttribute("longitud", repartidorLogeado.getListaPedidosRepartidor().stream().findFirst().get().getPuntoReparto().getCoordenadasLongitud());
        model.addAttribute("puntosDeLaRuta", listaConPedidos);
    	
        return "/v_repartidor/inicio_repartidores";
    }

	@GetMapping({"/repartidor/terminarPedido/{id_pedido}"})
    public String terminarPedido(Model model,
    		@PathVariable String id_pedido) {
    	
		Pedido_Pojo pedido_que_termina=this.pedidoRepository.findById((long) Integer.parseInt(id_pedido)).get();
	
		pedido_que_termina.setEstadoPedido(Estado_Pedido.ESTADO_ENTREGADO.toString());

		this.pedidoRepository.save(pedido_que_termina);
		
        return "redirect:/repartidor/entrada";
    }
	
	
}
