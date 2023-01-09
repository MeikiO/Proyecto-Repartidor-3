package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
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
	
	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
    //todos pueden entrar a todo, pero lo limitamos usando el rol.
    
	
	public ControladorJ__Repartidor(Repartidor_Repository repartidorRepository, UserAccount_Repository userRepository) {
		super();
		this.repartidorRepository = repartidorRepository;
		this.userRepository = userRepository;
	}  


	@GetMapping({"/repartidor/entrada"})
    public String redirigirAEntradaRepartidor(Model model) {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();

    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	System.out.println(usuarioLogeado);
    	System.out.println(roles);
 	
        UserAccount_Pojo account=this.userRepository.findByUsername(SecurityContextHolder. getContext(). getAuthentication().getName());   	
        Repartidor_Pojo repartidorLogeado=this.repartidorRepository.findByUser(account);
        
        List<PuntoReparto_Pojo> listaConpuntosReparto=new ArrayList<>();
        
        for(Pedido_Pojo actual: repartidorLogeado.getListaPedidos()) {
        	listaConpuntosReparto.add(actual.getPuntoReparto());
        }

        model.addAttribute("nombreDeLaRuta", "Ruta de comprobacion");
        model.addAttribute("descripcionDeLaRuta", "La primera prueba para algo mas grande");
        model.addAttribute("latitud", repartidorLogeado.getListaPedidos().stream().findFirst().get().getPuntoReparto().getCoordenadasLatitud());
        model.addAttribute("longitud", repartidorLogeado.getListaPedidos().stream().findFirst().get().getPuntoReparto().getCoordenadasLongitud());
        model.addAttribute("puntosDeLaRuta", listaConpuntosReparto);
    	
        return "/v_repartidor/inicio_repartidores";
    }


	
}
