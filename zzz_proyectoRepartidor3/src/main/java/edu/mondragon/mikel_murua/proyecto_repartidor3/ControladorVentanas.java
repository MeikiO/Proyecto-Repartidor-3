package edu.mondragon.mikel_murua.proyecto_repartidor3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Service;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.MyUserDetailService;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.Roles;


@Controller
public class ControladorVentanas {

	
	 private final UserAccount_Repository userAccountRepository;
	 private final PasswordEncoder passwordEncoder;
	
	 
	public ControladorVentanas(UserAccount_Repository userAccountRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userAccountRepository = userAccountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	
    @GetMapping({"/"})
    public String redirigirALaPaginaDeInicio() {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	/*
    	 Explicacion principal:
    	 	+ Funciones
    	 	-> https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot
    	  
    	  
    	  	el OBJECT PRINCIPAL -> toma el usuario de MyusersDetailService es objeto User, ya que no te coge la autoridad si no lo es
    	  	-> si usamos Credentials todos los datos los recibimos en OBJECT y no podemos utilizar ni los datos ni las funicones de SecurityContextHolder
    	  
    	 */
    	
    	//La diferenciacion de usuarios por rol, se hace en SecurityConfiguration.
    	

        return "index";
    }
	
	
	@GetMapping("/register") 
	public String registrarUser(Model model, String error, String logout) {
        
		System.out.println("Prueba para ver si pasa");
		return "registration";
	}

	
	@PostMapping("/register/procesar")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
	        
    	
    	UserAccount_Pojo userAccount = new UserAccount_Pojo();
        userAccount.setUsername(username);
        userAccount.setContrasena(passwordEncoder.encode(password));
        userAccount.setEstaActivo(true);
        
        ArrayList<GrantedAuthority> listaRoles= new ArrayList<>();
        listaRoles.add(new SimpleGrantedAuthority(Roles.ROLE_ADMIN.name()));
        
        
        userAccount.setListaRoles(listaRoles);
        
        userAccountRepository.save(userAccount);
        
        return "index";
    }

	/*
	 * Cosas Importantes:
	   2. MODEL tiene que pasarse OBLIGATORIAMENTE
	 
	  	3. Los programas se activan solo cuando se accede al URL que tiene cada funcion.  localhost:8080/  -> activa el primero {/}
	  		-> por eso el cambio de ventanas se hace por html cambiando a la pagina correspondendiente, al hacer el cambio
	  			se activa la funcion del controlador que hace refencia a ese URL  . 	 
	 */

	
	
	/*
	    con SPRING SECURITY,  si hacemos llamada a cualquier URL de nuestra pagina web. Interceptara la llamada
	    
	    y cargara la ventana de login ( esto esta definido en Seguridad-> SecurityConfiguration  ) y despues de registrarse
	    
	    nos cargara la pagina web que habiamos llamado al inicio.
	    
	    -> ejemplo:  llama a          localhost8080/          -> primero carga el login y cuando entremos entrara a ventana inicio.
	  
	 */
	
	
	@GetMapping("/login") 
	public String paginaLogin(Model model, String error, String logout) {
        
		model.addAttribute("error", error);
       
   
		// se pasa siempre el modelo a la pagina web que cargamos

		model.addAttribute("nombreEnControlador", "soy un atributo especificado en el controlador");
		// para usar el interface de REPARTIDORPERSISTENCIA X USAMOS EL SERVICE
		//model.addAttribute("Numero_de_objetos_database", this.repartidores.numero_de_elementos_en_database());

		
		// especificamos que pagina va ha cargar a continuacion (no hace falta poner
		// extension (.html)
		// te lo toma directamente. Y le pasamos el modelo (que se usara como atributo)
		
		return "login/login";
	}

	
    @PostMapping("/logout")
    public String mostrarLaPaginaDeCierre(Model model) {
        return "logout";
    }
    
    
    
    //La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
    //todos pueden entrar a todo, pero lo limitamos usando el rol.
    
    @GetMapping({"/admin/entrada"})
    public String redirigirAVentanaDeAdmin() {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	System.out.println(roles);
    	
        return "/v_admin/panel_control_admin";
    }
    
    

   
    @GetMapping({"/repartidor/entrada"})
    public String redirigirAEntradaRepartidor() {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	System.out.println(roles);
    	
        return "/v_repartidor/inicio_repartidores";
    }
    
    
    
    
   
    @GetMapping({"/cliente/entrada"})
    public String redirigirAEntradaCliente() {
    	
    	Object usuarioLogeado = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
    	
    	
    	Collection<? extends GrantedAuthority> roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    	
    	System.out.println(roles);
    	
        return "/v_cliente/entrada_clientes";
    }
   
    
 
    
}
