package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.Authentication;
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
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.productos.Producto_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.punto_reparto.PuntoReparto_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.ClasificacionQuejas;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.Queja_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.quejas.Queja_Repository;
import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.repartidores.Repartidor_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.Roles;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_seguridad.UserAccount_Repository;


@Controller
public class ControladorJ__Cliente {

	private PuntoReparto_Repository puntoRepartoRepository;
	private UserAccount_Repository userAccountRepository;
	private Poblacion_Repository poblacionRepository;
	private PasswordEncoder passwordEncoder;
	
	private Pedidos_Repository pedidos_repository;
	private Producto_Repository productos_repository;
	private LineaPedido_Repository lineaProductos_repository;
	private Queja_Repository queja_repository;



	//La restriccion entrada de los usuarios por rol, se hace en SecurityConfiguration.
	    //todos pueden entrar a todo, pero lo limitamos usando el rol.
	    

    public ControladorJ__Cliente(PuntoReparto_Repository puntoRepartoRepository,
			UserAccount_Repository userAccountRepository, Poblacion_Repository poblacionRepository,
			PasswordEncoder passwordEncoder, Pedidos_Repository pedidos_repository,
			Producto_Repository productos_repository, LineaPedido_Repository lineaProductos_repository,
			Queja_Repository queja_repository) {
		super();
		this.puntoRepartoRepository = puntoRepartoRepository;
		this.userAccountRepository = userAccountRepository;
		this.poblacionRepository = poblacionRepository;
		this.passwordEncoder = passwordEncoder;
		this.pedidos_repository = pedidos_repository;
		this.productos_repository = productos_repository;
		this.lineaProductos_repository = lineaProductos_repository;
		this.queja_repository = queja_repository;
	}



	@GetMapping({"/cliente/entrada"})
    public String redirigirAEntradaCliente(Model model, String error, String logout) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UserAccount_Pojo logged_user= this.userAccountRepository.findByUsername(auth.getName());
    	PuntoReparto_Pojo punto=this.puntoRepartoRepository.findByUser(logged_user);
    	
    	
    	List<Pedido_Pojo> listaPedidos=this.pedidos_repository.findByPuntoReparto(punto);
    	
    	model.addAttribute("listaPedidos", listaPedidos);
    	
    	
        return "/v_cliente/entrada_clientes.html";
    }
    
    

	@GetMapping({"/cliente/ensenarLayoutDemo"})
    public String enseñarLayoutDemo(Model model, String error, String logout) {
    	
        return "/zzz-pruebas_layouts/pagina_prueba1";
    }
	    
	    
	        
    @PostMapping("/cliente/procesarAcciones")
	public String procesarAccion(String action, @ModelAttribute("pedido") Pedido_Pojo pedido_seleccionado, Model model) {
    
    	System.out.println(action);
    	String id="";
    	String split[]=action.split("/");
    	action=split[0];
    	if(action.equals("ver") || action.equals("queja")) {
    		id=split[1];    		
    	}
    	
	    switch (action) {
            //en la entrada_clientes, los botones de la tabla
	    	case "ver":
            	return "redirect:/cliente/ver/"+id;
            case "queja":
                return "redirect:/cliente/hacer_una_queja/"+id;
                
            //en el layout_cliente, todas las acciones
            case "hacer_pedido":
            	return "redirect:/cliente/hacer_pedido";
            
            case "procesar_pedido":
            	return "redirect:/cliente/entrada";
            
            	
            case "ver_todas_las_quejas":
            	return "redirect:/cliente/ver_todas_las_quejas";

                
            default:
                return "redirect:/cliente/entrada";
        }
    }
	 
    
    @GetMapping({"/cliente/hacer_pedido"})
    public String hacerPedido(Model model, String error, String logout) {
    	
    	List<Producto_Pojo> listaProductos=this.productos_repository.findAll();
    	
    	model.addAttribute("listaProductos", listaProductos);
    	
    	
    	/*
		Para arreglar el problema de que solo se podia poner 1
		
		- Aqui se carga el user

    	 */
    
    	Pedido_Pojo pedido=new Pedido_Pojo();
    	pedido=this.cargarPedidoEncursoDeUserLogeado();
    	
    	/*
			Y las lineas de pedido se tratan de forma separada
			- y cuando se necesiten se cargan de database 
			y se le asignan al pedido concreto
			
			+Nota: NO SE PUEDE GUARDAR PEDIDO, SI SE LE ASIGNAN LINEA PEDIDO.
			
    	 */
    	
    	
    	Set<LineaPedido_Pojo> lista=this.lineaProductos_repository.findByReferenciaAPedido(pedido);
    	pedido.setListaLineas(lista);
 
    	pedido.setPrecio_total(this.calcularPrecioTotal(lista));
		
    	
    	/*Para pasar un nuevo objeto tenemos 
    	 * que pasarlo por aqui ya inicializado en los atribute
    	 	--> https://stackoverflow.com/questions/8781558/neither-bindingresult-nor-plain-target-object-for-bean-name-available-as-request 
    	 */
    	model.addAttribute("pedido", pedido);
        model.addAttribute("linea_pedido", new LineaPedido_Pojo());
    	
        return "/v_cliente/Formulario_Pedido";
    }
    
    
    
    
	private Pedido_Pojo cargarPedidoEncursoDeUserLogeado() {

    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UserAccount_Pojo logged_user= this.userAccountRepository.findByUsername(auth.getName());
    	PuntoReparto_Pojo punto=this.puntoRepartoRepository.findByUser(logged_user);
    	
    	
    	//buscar en pedido, cual tiene estado [ ESTADO_HACIENDO_EL_PEDIDO ]
    	List<Pedido_Pojo> todos_los_pedidos_en_curso=this.pedidos_repository.findByEstadoPedido(Estado_Pedido.ESTADO_HACIENDO_EL_PEDIDO.toString());
    	boolean tiene_pedido_en_curso=false;
    	Pedido_Pojo pedido=new Pedido_Pojo();
    	
    	if(!todos_los_pedidos_en_curso.isEmpty()) {		
    		for(Pedido_Pojo actual: todos_los_pedidos_en_curso) {
    			if(actual.getPuntoReparto().getUser().equals(logged_user)) {
    				pedido=actual;
    				tiene_pedido_en_curso=true;
    			}
    		}    		
    	}
    	

    	if(!tiene_pedido_en_curso) {
    		pedido.setEstadoPedido(Estado_Pedido.ESTADO_HACIENDO_EL_PEDIDO.toString());
    		pedido.setPuntoReparto(punto);
    		pedido.setId((long) 0);
    		pedido.setRepartidorEncargado(null);

    		this.pedidos_repository.save(pedido);
    	}
		return pedido;
	}

	@PostMapping("/cliente/procesarLinea")
	public String register(
			@RequestParam("producto_formulario") String productoElegido,
			@RequestParam("candidad") String cantidad) {
	        
		/*
			- Aqui solo se guarda 1 linea de pedido.			
		*/
		
    	
    	System.out.println(productoElegido);
    	System.out.println(cantidad);
 
    	Pedido_Pojo pedido=this.cargarPedidoEncursoDeUserLogeado();
    
    	LineaPedido_Pojo una_linea=new LineaPedido_Pojo();
    	Producto_Pojo producto=this.productos_repository.findByNombre(productoElegido);
    	una_linea.setProducto(producto);
    	una_linea.setReferenciaAPedido(pedido);
    	String[] contenido_cantidad=cantidad.split("[,]");
    	una_linea.setCandidad(Integer.parseInt(contenido_cantidad[1]));
    	
    	Set<LineaPedido_Pojo> listaLineas = this.lineaProductos_repository.findByReferenciaAPedido(pedido);
    	
    	listaLineas.add(una_linea);
    	pedido.setListaLineas(listaLineas);	
    	this.pedidos_repository.save(pedido);
    	//this.lineaProductos_repository.save(una_linea); 
    	
    	
        return "redirect:/cliente/hacer_pedido";
        
        /* Al guardar los pedidos con todos los linea de pedido da el 
        error:object references an unsaved transient instance - save the transient instance before flushing: edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Pojo
        
        +Para arreglar eso guardamos todo en cascada.
        
        Link de referencia:
        ->https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/ 

		y ponemos el cascade en el @One to many de [listaProductos ]

        */    	

    	/*
    	 Para que no haya problemas de id ni integridad referencial
    	 -> https://stackoverflow.com/questions/25636091/org-hibernate-persistentobjectexception-detached-entity-passed-to-persist-excep 
    	 quitamos el id auto generated.identity, para crearlo nosotros a mano.
    	 */
    	
    	/*
    	 	Al final, al modificar linea pedido, para que tuviera la referencia
    	 	de pedido_id en la database, solo ha sido asignarle el id de pedido.
    	 	
    	 	Con eso ya lo podemos tratar aparte, guardarlo el solo y cargarlo
    	 	cuando sea necesario, para enseñarlo.
    	 */
    	
    }
	 
	
	private double calcularPrecioTotal(Set<LineaPedido_Pojo> lista) {
		double value=0;
		for(LineaPedido_Pojo actual:lista) {	
			Integer precio=Integer.parseInt(actual.getProducto().getPrecio_producto());
			int n_cantidad=actual.getCandidad();
			double descuento=actual.getProducto().getDescuento();
	
			value=value+(precio*n_cantidad-(precio*n_cantidad*(descuento/100)));			
		}
		
		return value;
	}

	
	
	
	@PostMapping("/cliente/eliminarLinea/{id}")
	public String borrarLineaProducto(
			@PathVariable String id) {
		
		Long id_lineaABorrar=(long) Integer.parseInt(id);
		
		Optional<LineaPedido_Pojo> linea=this.lineaProductos_repository.findById(id_lineaABorrar);	
		if(!linea.isEmpty()) {			
			this.lineaProductos_repository.delete(linea.get());	
		}
		
		return "redirect:/cliente/hacer_pedido";
	}
	
	
	@PostMapping("/cliente/terminarPedido")
	public String terminarPedido(
			@RequestParam("observaciones") String observaciones) {
	        
		/*
		  	 Daba problemas, porque no puedes guardar 2 entidades a la vez.
		  	 Cada una se tiene que guardar por separado.
		  	 -> lineaPedido por su lado
		  	 -> pedido por su lado.
		 */
		

    	System.out.println(observaciones);
    	
    	Pedido_Pojo pedido=this.cargarPedidoEncursoDeUserLogeado();
    	pedido.setEstadoPedido(Estado_Pedido.ESTADO_EN_ESPERA_DE_MANDAR.toString());
    	pedido.setObservaciones(observaciones);
    	
     	Set<LineaPedido_Pojo> lista=this.lineaProductos_repository.findByReferenciaAPedido(pedido);
     	//En este caso utilizamos las linea producto
     	//solo para calcular precio total
     	//no los asignamos a pedido
    	pedido.setPrecio_total(this.calcularPrecioTotal(lista));
		
    	java.util.Date date = new java.util.Date();    
	    System.out.println(date);   
	    	
	    pedido.setFechaPedido(date);
    	
    	this.pedidos_repository.save(pedido);
		
        return "redirect:/cliente/entrada";
    }
   
	
	
	
	 @GetMapping("/cliente/ver/{id}")
	public String verPedido(@PathVariable String id,Model model, String error, String logout) {
	    
	    	Optional<Pedido_Pojo> pedido=this.pedidos_repository.findById((long) Integer.parseInt(id));
	    	Set<LineaPedido_Pojo> lista=this.lineaProductos_repository.findByReferenciaAPedido(pedido.get());
	    	pedido.get().setListaLineas(lista);
	    	model.addAttribute("pedido", pedido.get());
		 
	    	return "v_cliente/ver_cliente";
    }
   
	 
	 @GetMapping("/cliente/hacer_una_queja/{id}")
		public String hacerQueja(@PathVariable String id,Model model, String error, String logout) {	    
	
		 
		 	model.addAttribute("id_pedido", id);
	    	
	    	Queja_Pojo queja=new Queja_Pojo();
	    	model.addAttribute("queja", queja);
	    	
	   
	    	List<String> tiposQuejas=new ArrayList<>();
	    	ClasificacionQuejas[] clasificacion=ClasificacionQuejas.values();
	    	for(int i=0;i<clasificacion.length;i++) {
	    		tiposQuejas.add(clasificacion[i].toString());
	    	}
	    
	    	model.addAttribute("tiposQuejas",tiposQuejas);
	    	
	    	return "v_cliente/queja_cliente";
	 }
	 
	 
	
	 @PostMapping("/cliente/terminarQueja/{id}")
		public String terminarQueja(
				@PathVariable String id,
				@RequestParam("clasificacion") String clasificacion,
				@RequestParam("razones") String razones) {
		 
		 	System.out.println(clasificacion);
		 	System.out.println(razones);
			System.out.println(id);
			
			Optional<Pedido_Pojo> pedido=this.pedidos_repository.findById((long) Integer.parseInt(id));
	    	
		
	     	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	UserAccount_Pojo logged_user= this.userAccountRepository.findByUsername(auth.getName());
	    	PuntoReparto_Pojo punto=this.puntoRepartoRepository.findByUser(logged_user);
	    	
	    	
	    	Queja_Pojo queja=new Queja_Pojo();
	    	queja.setPedido(pedido.get());
	    	queja.setClasificacion(clasificacion);
	    	queja.setRazones(razones);
	    	
	        java.util.Date date = new java.util.Date();    
	        System.out.println(date);   
	    	
	        queja.setFechaQueja(date);
	  
	        this.queja_repository.save(queja);
	    	
	        pedido.get().setQueja(queja);
	        this.pedidos_repository.save(pedido.get());
			
	        return "redirect:/cliente/entrada";
	    }
	 
	 
	 
	 @GetMapping({"/cliente/ver_todas_las_quejas"})
	    public String verTodasLasQuejas(Model model, String error, String logout) {
	    	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	UserAccount_Pojo logged_user= this.userAccountRepository.findByUsername(auth.getName());
	    	PuntoReparto_Pojo punto=this.puntoRepartoRepository.findByUser(logged_user);
	    	
	    	List<Pedido_Pojo> listaPedidos=this.pedidos_repository.findByPuntoReparto(punto);
	    	
	    	List<Queja_Pojo> listaQuejas=new ArrayList<>();
	    	for(Pedido_Pojo actual:listaPedidos) {
	    		if(actual.getQueja()!=null) {
	    			listaQuejas.add(actual.getQueja());
	    		}		
	    	}
	    	
	    	model.addAttribute("lista_quejas", listaQuejas);
	    	
	    	
	        return "/v_cliente/verQuejas";
	    }
	    
	 
}
