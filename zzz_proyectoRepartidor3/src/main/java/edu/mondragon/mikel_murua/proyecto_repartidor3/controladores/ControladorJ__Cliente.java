package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedidos_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;

@Controller
public class ControladorJ__Cliente {

	private PuntoReparto_Repository puntoRepartoRepository;
	private UserAccount_Repository userAccountRepository;
	private Poblacion_Repository poblacionRepository;
	private PasswordEncoder passwordEncoder;
	
	private Pedidos_Repository pedidos_repository;

	public ControladorJ__Cliente(PuntoReparto_Repository puntoRepartoRepository,
			UserAccount_Repository userAccountRepository, Poblacion_Repository poblacionRepository,
			PasswordEncoder passwordEncoder,Pedidos_Repository pedidosRepository) {
		super();
		this.puntoRepartoRepository = puntoRepartoRepository;
		this.userAccountRepository = userAccountRepository;
		this.poblacionRepository = poblacionRepository;
		this.passwordEncoder = passwordEncoder;
		
		this.pedidos_repository=pedidosRepository;
	}

	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
	    //todos pueden entrar a todo, pero lo limitamos usando el rol.
	    
		
	    @GetMapping({"/cliente/entrada"})
	    public String redirigirAEntradaCliente(Model model, String error, String logout) {
	    	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	    	Collection<? extends GrantedAuthority> roles =auth.getAuthorities();

	    	System.out.println(roles);
	    	
	    	System.out.println(auth.getName()); //esto es el usuario logeado
	    	
	    	
	  
	    	//PuntoReparto_Pojo punto=puntoService.findByNombre_cliente(auth.getName());
	    	long id=1;
	    	Optional<PuntoReparto_Pojo> punto=this.puntoRepartoRepository.findById(id);
	    	
	    	
	    	for(int i=1;i<=3;i++) {
	    		Pedido_Pojo pedido=new Pedido_Pojo();
	        	pedido.setObservaciones("Es el "+i);
	        	pedido.setPuntoReparto(punto.get());
	        	this.pedidos_repository.save(pedido); //da error del foreign key al guardar
	    	}
	    	
	    	
	    	
	        return "/v_cliente/entrada_clientes";
	    }
   
}
