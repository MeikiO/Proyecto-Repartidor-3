package edu.mondragon.mikel_murua.proyecto_repartidor3.controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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

	public ControladorJ__Cliente(PuntoReparto_Repository puntoRepartoRepository,
			UserAccount_Repository userAccountRepository, Poblacion_Repository poblacionRepository,
			PasswordEncoder passwordEncoder,Pedidos_Repository pedidosRepository,
			Producto_Repository productosRepository,
			LineaPedido_Repository lineaProductos_repository) {
		super();
		this.puntoRepartoRepository = puntoRepartoRepository;
		this.userAccountRepository = userAccountRepository;
		this.poblacionRepository = poblacionRepository;
		this.passwordEncoder = passwordEncoder;
		
		this.pedidos_repository=pedidosRepository;
		this.productos_repository=productosRepository;
		this.lineaProductos_repository=lineaProductos_repository;
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
    	
    	List<Pedido_Pojo> listaPedidos=this.pedidos_repository.findByPuntoReparto(punto.get());
    	
    	model.addAttribute("listaPedidos", listaPedidos);
    	
    	/*
    	for(int i=1;i<=3;i++) {
    		Pedido_Pojo pedido=new Pedido_Pojo();
        	pedido.setObservaciones("Es el "+i);
        	pedido.setEstado_pedido(Estado_Pedido.ESTADO_EN_ESPERA_DE_MANDAR.toString());
        	pedido.setPuntoReparto(punto.get());
        	//this.pedidos_repository.save(pedido); //da error del foreign key al guardar
    	}
    	*/
    	
    	
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
                return "redirect:/cliente/hacer_una_queja"+id;
                
            //en el layout_cliente, todas las acciones
            case "hacer_pedido":
            	return "redirect:/cliente/hacer_pedido";
            
            case "procesar_pedido":
            	return "redirect:/cliente/entrada";
            
            
            	
            case "ver_todas_las_reclamaciones":
            	return "redirect:/cliente/ver_todas_las_reclamaciones";

                
            default:
                return "redirect:/cliente/entrada";
        }
    }
	 
    
    @GetMapping({"/cliente/hacer_pedido"})
    public String hacerPedido(Model model, String error, String logout) {
    	
    	List<Producto_Pojo> listaProductos=this.productos_repository.findAll();
    	
    	model.addAttribute("listaProductos", listaProductos);
    	
    
    	Pedido_Pojo pedido=new Pedido_Pojo();
    	
    	pedido=this.cargarPedidoEncursoDeUserLogeado();
    	
    	
    	/*Para pasar un nuevo objeto tenemos 
    	 * que pasarlo por aqui ya inicializado en los atribute
    	 	--> https://stackoverflow.com/questions/8781558/neither-bindingresult-nor-plain-target-object-for-bean-name-available-as-request 
    	 */
    	model.addAttribute("pedido", pedido);
        model.addAttribute("linea_pedido", new LineaPedido_Pojo());
    	
        return "/formularios/Formulario_Pedido";
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
    				pedido.setPrecio_total(this.calcularPrecioTotal(pedido));
    			}
    		}    		
    	}
    	

    	if(!tiene_pedido_en_curso) {
    		Set<LineaPedido_Pojo> lineasPedido=new HashSet<>();
    		pedido.setListaLineas(lineasPedido);
    		pedido.setEstadoPedido(Estado_Pedido.ESTADO_HACIENDO_EL_PEDIDO.toString());
    		pedido.setPuntoReparto(punto);
   		
    		this.pedidos_repository.save(pedido);
    	}
		return pedido;
	}

	@PostMapping("/cliente/procesarLinea")
	public String register(
			@RequestParam("producto_formulario") String productoElegido,
			@RequestParam("candidad") String cantidad) {
	        
		/*
		  	   NECESITAMOS PROCESAR 1 ELEMENTO DE LINEA DE PEDIDOS
	   -> LA LISTA DE PRODUCTOS YA ESTA HECHA
	   
	   +NECESITAMOS PODER SELECCIONAR EL PRODUCTO Y SU CANTIDAD
	   +DESPUES MANDARLA A PROCESAR (cliente/procesar_pedido) Y GUARDARLO EN DATABASE
	   , junto con su datos (pedido y punto reparto (el punto reparto se extrae de las credenciales de session)).


	   +Despues tenemos que poder hacerlo con varios (linea productos), pudiedo aumentar
	   el numero de lineas de producto 


		EJEMPLO
		 */
		
    	
    	System.out.println(productoElegido);
    	System.out.println(cantidad);
 
    	

    	Pedido_Pojo pedido=this.cargarPedidoEncursoDeUserLogeado();
    	System.out.println(pedido.getListaLineas());
    	
    	LineaPedido_Pojo una_linea=new LineaPedido_Pojo();
    	Producto_Pojo producto=this.productos_repository.findByNombre(productoElegido);
    	una_linea.setProducto(producto);
    	
    	String[] contenido_cantidad=cantidad.split("[,]");
    	una_linea.setCandidad(Integer.parseInt(contenido_cantidad[1]));
    	

        /* Al guardar los pedidos con todos los linea de pedido da el 
        error:object references an unsaved transient instance - save the transient instance before flushing: edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.pedidos.LineaPedido_Pojo
        
        +Para arreglar eso guardamos todo en cascada.
        
        Link de referencia:
        ->https://howtodoinjava.com/hibernate/hibernate-jpa-cascade-types/ 

		y ponemos el cascade en el @One to many de [listaProductos ]

        */    	

    	
    	if(!pedido.getListaLineas().contains(una_linea)) {
    		una_linea.setId(this.lineaProductos_repository.count()+1);
    		pedido.getListaLineas().add(una_linea);	
    		this.pedidos_repository.save(pedido);    		
    	}
    	
        return "redirect:/cliente/hacer_pedido";
    }
	 
	
	private double calcularPrecioTotal(Pedido_Pojo pedido) {
		double value=0;
		for(LineaPedido_Pojo actual:pedido.getListaLineas()) {
			double precioActual=pedido.getPrecio_total();
			Integer precio=Integer.parseInt(actual.getProducto().getPrecio_producto());
			int n_cantidad=actual.getCandidad();
			double descuento=actual.getProducto().getDescuento();
			
			value=precioActual+(precio*n_cantidad-(precio*n_cantidad*(descuento/100)));			
		}
		
		return value;
	}

	
	
	
	@PostMapping("/cliente/eliminarLinea/{id}")
	public String borrarLineaProducto(
			@PathVariable String id) {
		
		Pedido_Pojo pedido=this.cargarPedidoEncursoDeUserLogeado();
		
		Long id_lineaABorrar=(long) Integer.parseInt(id);
		
		Optional<LineaPedido_Pojo> linea=this.lineaProductos_repository.findById(id_lineaABorrar);	
		if(!linea.isEmpty()) {
			pedido.getListaLineas().remove(linea.get());			
			this.lineaProductos_repository.delete(linea.get());	
		}
		
		return "redirect:/cliente/hacer_pedido";
	}
	
	
	@PostMapping("/cliente/terminarPedido")
	public String terminarPedido(
			@RequestParam("observaciones") String observaciones) {
	        
		/*
		  	   NECESITAMOS PROCESAR 1 ELEMENTO DE LINEA DE PEDIDOS
	   -> LA LISTA DE PRODUCTOS YA ESTA HECHA
	   
	   +NECESITAMOS PODER SELECCIONAR EL PRODUCTO Y SU CANTIDAD
	   +DESPUES MANDARLA A PROCESAR (cliente/procesar_pedido) Y GUARDARLO EN DATABASE
	   , junto con su datos (pedido y punto reparto (el punto reparto se extrae de las credenciales de session)).


	   +Despues tenemos que poder hacerlo con varios (linea productos), pudiedo aumentar
	   el numero de lineas de producto 


		EJEMPLO
		 */
		
    	

    	System.out.println(observaciones);
    	
    	Pedido_Pojo pedido=this.cargarPedidoEncursoDeUserLogeado();
    	pedido.setEstadoPedido(Estado_Pedido.ESTADO_EN_ESPERA_DE_MANDAR.toString());
    	pedido.setObservaciones(observaciones);
    	pedido.setPrecio_total(this.calcularPrecioTotal(pedido));
    	
    	this.pedidos_repository.save(pedido);
		
        return "redirect:/cliente/entrada";
    }
   
	
	
	
	 @GetMapping("/cliente/ver/{id}")
	public String verPedido(@PathVariable String id,Model model, String error, String logout) {
	    
	    	Optional<Pedido_Pojo> pedido=this.pedidos_repository.findById((long) Integer.parseInt(id));

	    	model.addAttribute("pedido", pedido.get());
		 
	    	return "v_cliente/ver_cliente";
    }
   
	
	
	
}
