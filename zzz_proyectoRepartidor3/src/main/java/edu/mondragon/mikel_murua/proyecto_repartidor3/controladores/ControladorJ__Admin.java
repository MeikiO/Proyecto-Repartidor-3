package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Estado_Pedido;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedido_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.Pedidos_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.Queja_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.Queja_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas.ConvertirDireccionACoordenadas;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas.Coordenadas;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.Roles;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;

@Controller
public class ControladorJ__Admin {

	private Pedidos_Repository pedidos_repository;
	private PuntoReparto_Repository punto_reparto_repository;
	private Repartidor_Repository repartidor_repository;
	private Queja_Repository queja_repository;
	private LineaPedido_Repository linea_repository;
	private Poblacion_Repository poblacionRepository;

	private UserAccount_Repository userAccountRepository;
	private PasswordEncoder passwordEncoder;
	


	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
    //todos pueden entrar a todo, pero lo limitamos usando el rol.


	public ControladorJ__Admin(Pedidos_Repository pedidos_repository, PuntoReparto_Repository punto_reparto_repository,
			Repartidor_Repository repartidor_repository, Queja_Repository queja_repository,
			LineaPedido_Repository linea_repository, Poblacion_Repository poblacionRepository,
			UserAccount_Repository userAccountRepository, PasswordEncoder passwordEncoder) {
		super();
		this.pedidos_repository = pedidos_repository;
		this.punto_reparto_repository = punto_reparto_repository;
		this.repartidor_repository = repartidor_repository;
		this.queja_repository = queja_repository;
		this.linea_repository = linea_repository;
		this.poblacionRepository = poblacionRepository;
		this.userAccountRepository = userAccountRepository;
		this.passwordEncoder = passwordEncoder;
	}


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
    		
    		if(actual!=Estado_Pedido.ESTADO_HACIENDO_EL_PEDIDO) {
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
    	
    	Set<LineaPedido_Pojo> listaLinea = this.linea_repository.findByReferenciaAPedido(pedido);
    	pedido.setListaLineas(listaLinea);
     	model.addAttribute("pedido",pedido);
    	
     	model.addAttribute("puntoReparto", pedido.getPuntoReparto());
    	
 
    	
        return "/v_admin/consultar_pedidos";
    }
    
    
    
  
    @GetMapping({"/admin/consultarRepartidores"})
    public String consultarRepartidores(Model model) {
    	
    	List<Repartidor_Pojo>listaRepartidores=this.repartidor_repository.findAll();
    	model.addAttribute("listaRepartidores", listaRepartidores);
    	
        return "/v_admin/consultar_repartidores";
    }
    
    
    @GetMapping({"/admin/crearRepartidor"})
    public String crearRepartidor(Model model) {
    	
    	System.out.println("A crear");
    	
    	model.addAttribute("repartidor",new Repartidor_Pojo());
    	
		
		List<Poblacion_Pojo> poblaciones=this.poblacionRepository.findAll();
		
		model.addAttribute("listaPoblaciones", poblaciones);
		
    	
    	
        return "/v_admin/formulario_repartidor";
    }
    
    
    
    @GetMapping({"/admin/editarRepartidor/{id}"})
    public String editarRepartidor(@PathVariable String id,Model model) {
    	
    	System.out.println("A editar");
    	long id_mandado=Integer.parseInt(id);
    	
    	model.addAttribute("repartidor",this.repartidor_repository.findById(id_mandado).get());
	
		List<Poblacion_Pojo> poblaciones=this.poblacionRepository.findAll();
		
		model.addAttribute("listaPoblaciones", poblaciones);
		
        return "/v_admin/formulario_repartidor";
    }
    
    
    @PostMapping({"/admin/procesarRepartidor"})
    public String procesarRepartidor(Model model,
    @ModelAttribute("repartidor") Repartidor_Pojo repartidor,
	@RequestParam("username") String username, @RequestParam("password") String password,
	@RequestParam("poblacion_formulario") String poblacion_elegida) {
    		
    	System.out.println(repartidor);
    	System.out.println(poblacion_elegida);

		try {
			Optional<Poblacion_Pojo> miPoblacion=this.poblacionRepository.findByNombreLocalizacion(poblacion_elegida);
			UserAccount_Pojo user=null;
			
			if(repartidor.getId()!=null) {
				Optional<Repartidor_Pojo> repartidorAnterior = this.repartidor_repository.findById(repartidor.getId());
				user=repartidorAnterior.get().getUser();
				repartidor.setId(repartidorAnterior.get().getId());
			}
			else {
				user=new UserAccount_Pojo();
			}
						
			UserAccount_Pojo userAccount=this.formulary_credentials_processing(username,password,Roles.ROLE_TRABAJADOR.name(),user);

			this.formulary_repartidor_processing(miPoblacion.get(),userAccount,repartidor);
	        
		} 
		finally {
			System.out.println("Repartidor creado----------");
		}
    	
    	
        return "redirect:/admin/consultarRepartidores";
    }
        
    @GetMapping({"/admin/desactivar_Repartidor/{id}"})
    public String desactivarRepartidor(@PathVariable String id,Model model) {
    	
    	long id_mandado=Integer.parseInt(id);
    	
    	Optional<Repartidor_Pojo> elegido=this.repartidor_repository.findById(id_mandado);
    	
    	if(!elegido.isEmpty()) {	

    		UserAccount_Pojo credencial = this.userAccountRepository.findByUsername(elegido.get().getUser().getUsername());
    		
    		credencial.setEstaActivo(false);
    		
    		this.userAccountRepository.save(credencial);
    	}
    	
        return "redirect:/admin/consultarRepartidores";
    }
    
    @GetMapping({"/admin/activar_Repartidor/{id}"})
    public String activarRepartidor(@PathVariable String id,Model model) {
    	
    	long id_mandado=Integer.parseInt(id);
    	
    	Optional<Repartidor_Pojo> elegido=this.repartidor_repository.findById(id_mandado);
    	
    	if(!elegido.isEmpty()) {	

    		UserAccount_Pojo credencial = this.userAccountRepository.findByUsername(elegido.get().getUser().getUsername());
    		
    		credencial.setEstaActivo(true);
    		
    		this.userAccountRepository.save(credencial);
    	}
    	
        return "redirect:/admin/consultarRepartidores";
    }
    
    
    
    
    @GetMapping({"/admin/consultarClientes"})
    public String consultarClientes(Model model) {
    	
    	model.addAttribute("listaClientes",this.punto_reparto_repository.findAll());
        
    	return "/v_admin/consultar_clientes";
    }
    
    
    
    @GetMapping({"/admin/desactivar_Cliente/{id}"})
    public String desactivarCliente(@PathVariable String id,Model model) {
    	
    	long id_mandado=Integer.parseInt(id);
    	
    	Optional<PuntoReparto_Pojo> elegido=this.punto_reparto_repository.findById(id_mandado);
    	  
    	if(!elegido.isEmpty()) {	

    		UserAccount_Pojo credencial = this.userAccountRepository.findByUsername(elegido.get().getUser().getUsername());
    		
    		credencial.setEstaActivo(false);
    		
    		this.userAccountRepository.save(credencial);
    	}
    	
    	return "redirect:/admin/consultarClientes";
    }
    
    @GetMapping({"/admin/activar_Cliente/{id}"})
    public String activarCliente(@PathVariable String id,Model model) {
    	
    	long id_mandado=Integer.parseInt(id);
    	
    	Optional<PuntoReparto_Pojo> elegido=this.punto_reparto_repository.findById(id_mandado);
    	  
    	if(!elegido.isEmpty()) {	

    		UserAccount_Pojo credencial = this.userAccountRepository.findByUsername(elegido.get().getUser().getUsername());
    		
    		credencial.setEstaActivo(true);
    		
    		this.userAccountRepository.save(credencial);
    	}
    	
    	return "redirect:/admin/consultarClientes";
    }
    
    
    @GetMapping({"/admin/editarCliente/{id}"})
    public String editarCliente(@PathVariable String id,Model model) {
    	
    	System.out.println("A editar cliente");
    	long id_mandado=Integer.parseInt(id);
    	
    	model.addAttribute("cliente",this.punto_reparto_repository.findById(id_mandado).get());
	
		List<Poblacion_Pojo> poblaciones=this.poblacionRepository.findAll();
		
		model.addAttribute("listaPoblaciones", poblaciones);
		
        return "/v_admin/formulario_cliente";
    }
    
    @PostMapping({"/admin/procesarCliente"})
    public String procesarCliente(Model model,
    @ModelAttribute("cliente") PuntoReparto_Pojo cliente,
	@RequestParam("username") String username, @RequestParam("password") String password,
	@RequestParam("poblacion_formulario") String poblacion_elegida) {
    		
    	System.out.println(cliente);
    	System.out.println(poblacion_elegida);

		try {
			Optional<Poblacion_Pojo> miPoblacion=this.poblacionRepository.findByNombreLocalizacion(poblacion_elegida);
			UserAccount_Pojo user=null;
			
			if(cliente.getId()!=null) {
				Optional<PuntoReparto_Pojo> clienteAnterior = this.punto_reparto_repository.findById(cliente.getId());				
				user=clienteAnterior.get().getUser();
				cliente.setId(clienteAnterior.get().getId());
			}
			else {
				user=new UserAccount_Pojo();
			}
			
			UserAccount_Pojo userAccount=this.formulary_credentials_processing(username,password,Roles.ROLE_CLIENTE.name(),user);
			
			
			ConvertirDireccionACoordenadas conversor=new ConvertirDireccionACoordenadas();
			
			Coordenadas coordenadasCliente= conversor.realizarConsultaDeCoordenada(cliente.getDireccion(),miPoblacion.get());
		
			//Coordenadas coordenadasCliente= new Coordenadas(0,0);
			
			
			this.formulary_cliente_processing(miPoblacion.get(),userAccount,cliente,coordenadasCliente);
	        
		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		finally {
			System.out.println("Repartidor creado----------");
		}
    	
    	
        return "redirect:/admin/consultarClientes";
    }
    
    
    
	private UserAccount_Pojo formulary_credentials_processing(
		String username, String password,String role, UserAccount_Pojo userAccount_Pojo) {
	
		
		userAccount_Pojo.setUsername(username);
		userAccount_Pojo.setContrasena(passwordEncoder.encode(password));
		userAccount_Pojo.setEstaActivo(true);
        
        ArrayList<GrantedAuthority> listaRoles= new ArrayList<>();
        listaRoles.add(new SimpleGrantedAuthority(role));
        
        userAccount_Pojo.setListaRoles(listaRoles);
        
        userAccountRepository.save(userAccount_Pojo);
        
        return userAccount_Pojo;
	}
	
	private void formulary_repartidor_processing(Poblacion_Pojo poblacion_Pojo, UserAccount_Pojo userAccount,
			Repartidor_Pojo repartidor) {
		Repartidor_Pojo a_registrar=repartidor;
		
		a_registrar.setPoblacion(poblacion_Pojo);
		a_registrar.setUser(userAccount);
		
		this.repartidor_repository.save(a_registrar);
	}

	private void formulary_cliente_processing(Poblacion_Pojo poblacion_Pojo, UserAccount_Pojo userAccount,
			PuntoReparto_Pojo cliente, Coordenadas coordenadasCliente) {
	
		PuntoReparto_Pojo a_registrar=cliente;
		
		a_registrar.setPoblacion(poblacion_Pojo);
		a_registrar.setUser(userAccount);
		a_registrar.setCoordenadasLatitud(coordenadasCliente.getCoordenadasLatitud());
		a_registrar.setCoordenadasLongitud(coordenadasCliente.getCoordenadasLongitud());
		
		this.punto_reparto_repository.save(a_registrar);
	}

    
    
	@GetMapping({"/admin/consultarQuejas"})
    public String consultarQuejas(Model model) {
	 	List<Pedido_Pojo> listaPedidos=this.pedidos_repository.findAll();
    	
    	List<Queja_Pojo> listaQuejas=new ArrayList<>();
    	for(Pedido_Pojo actual:listaPedidos) {
    		if(actual.getQueja()!=null) {
    			listaQuejas.add(actual.getQueja());
    		}		
    	}
    	
    	model.addAttribute("lista_quejas", listaQuejas);
    	
        return "/v_admin/consultar_quejas";
    }
    
	
	@GetMapping("/admin/ver/{id}")
	public String verPedido(@PathVariable String id,Model model, String error, String logout) {
	    
    	Optional<Pedido_Pojo> pedido=this.pedidos_repository.findById((long) Integer.parseInt(id));
    	Set<LineaPedido_Pojo> lista=this.linea_repository.findByReferenciaAPedido(pedido.get());
    	pedido.get().setListaLineas(lista);
    	model.addAttribute("pedido", pedido.get());
	 
    	return "/v_admin/consultar_quejas_pedido";
   }
	
	
	
	
	
	
	@GetMapping({"/admin/asignarPedidos"})
	public String asignarPedidos(Model model) {
		
		List<Repartidor_Pojo> listaRepartidoresActivos = new ArrayList<>();
		
		for(Repartidor_Pojo actual:this.repartidor_repository.findAll()) {
			if(actual.getUser().isEstaActivo()) {
				listaRepartidoresActivos.add(actual);
			}
		}

	   	model.addAttribute("lista_repartidores", listaRepartidoresActivos);
	 		   	
		
		Map<String,List<Pedido_Pojo>> mapaPedidosEstados=this.extraerMapaNecesario();
    	model.addAttribute("mapa", mapaPedidosEstados);
    	
    	model.addAttribute("repartidor_elegido", null);

    	
	    return "/v_admin/asignar_pedidos";
	}
	
	
	@PostMapping({"/admin/procesarAsignacionRepartidor"})
	public String asignarRepartidor (
			@RequestParam("idRepartidor") String id_repartidor,
			Model model) {

		System.out.println(id_repartidor);
		
		long repartidorId=0;
	
		try {
			repartidorId=Integer.parseInt(id_repartidor);
		
			Repartidor_Pojo repartidorCargado=this.repartidor_repository.findById(repartidorId).get();
	    	model.addAttribute("repartidor_elegido", repartidorCargado );
	    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		List<Repartidor_Pojo> listaRepartidoresActivos = new ArrayList<>();
		
		for(Repartidor_Pojo actual:this.repartidor_repository.findAll()) {
			if(actual.getUser().isEstaActivo()) {
				listaRepartidoresActivos.add(actual);
			}
		}

	   	model.addAttribute("lista_repartidores", listaRepartidoresActivos);
	 		   	
		Map<String,List<Pedido_Pojo>> mapaPedidosEstados=this.extraerMapaNecesario();
    	model.addAttribute("mapa", mapaPedidosEstados);
    	
    	  	
	    return "/v_admin/asignar_pedidos";
	}
    
	
	@PostMapping({"/admin/procesarAsignacion"})
	public String asignarPedido_a_repartidor (Model model,
		@RequestParam("idPedido") String id_pedido){
		
		System.out.println(id_pedido);
	
		long pedidoId=0;	
		
		try {
			pedidoId=Integer.parseInt(id_pedido);
			this.cambiarEstadoPedido(Estado_Pedido.ESTADO_EN_ESPERA_DE_EMPEZAR_REPARTO, pedidoId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	    return "redirect:/admin/asignarPedidos";
	}
    
	
	@PostMapping({"/admin/procesarDesagsignacion"})
	public String DesasignarPedido_a_repartidor (Model model,
		@RequestParam("idPedido") String id_pedido){
		System.out.println(id_pedido);
		
		long pedidoId=0;	
		
		try {
			pedidoId=Integer.parseInt(id_pedido);
			this.cambiarEstadoPedido(Estado_Pedido.ESTADO_EN_ESPERA_DE_MANDAR, pedidoId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	    return "redirect:/admin/asignarPedidos";
	}
	
	public void cambiarEstadoPedido(Estado_Pedido estado,long pedidoId) {
    	Pedido_Pojo pedidoSeleccionado=this.pedidos_repository.findById(pedidoId).get();  	
       	pedidoSeleccionado.setEstadoPedido(estado.toString());
    	this.pedidos_repository.save(pedidoSeleccionado);
	}
	
	
	@PostMapping({"/admin/terminarAsignacion"})
	public String terminarAsignacion(@RequestParam("repartidor_que_va_ha_repartir") String id_repartidor) {
		
		System.out.println(id_repartidor);
		
		long id_repartidorSeleccionado=Integer.parseInt(id_repartidor);
		
		Repartidor_Pojo repartidorMandado=this.repartidor_repository.findById(id_repartidorSeleccionado).get();
		
		Map<String,List<Pedido_Pojo>> mapaPedidosEstados=this.extraerMapaNecesario();
    	Set<Pedido_Pojo> setDePedidos=new HashSet<>();
		
		for(Pedido_Pojo actual: mapaPedidosEstados.get(Estado_Pedido.ESTADO_EN_ESPERA_DE_EMPEZAR_REPARTO.toString())) {
			
			Set<LineaPedido_Pojo> lineaPedidoQueTiene = this.linea_repository.findByReferenciaAPedido(actual);
			actual.setListaLineas(lineaPedidoQueTiene);
			actual.setEstadoPedido(Estado_Pedido.ESTADO_EN_CAMINO.toString());
			actual.setRepartidorEncargado(repartidorMandado);
			this.pedidos_repository.save(actual);
			
			setDePedidos.add(actual);
		}
		
		repartidorMandado.setListaPedidosRepartidor(setDePedidos);
		this.repartidor_repository.save(repartidorMandado);

		
		return "redirect:/admin/entrada";
	}
	
}
