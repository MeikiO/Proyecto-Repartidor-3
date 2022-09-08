package edu.mondragon.mikel_murua.proyecto_repartidor3;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorJ__Repartidor {

	public ControladorJ__Repartidor() {
	}
	
	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
    //todos pueden entrar a todo, pero lo limitamos usando el rol.
    
	
    @GetMapping({"/repartidor/entrada"})
    public String redirigirAEntradaRepartidor() {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	System.out.println(roles);
    	
        return "/v_repartidor/inicio_repartidores";
    }
	
}
