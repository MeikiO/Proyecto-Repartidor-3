package es.susosise.pruebas_springboot.personas;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInterno;
	// TODO pensar en como podemos usar UUIDs en lugar de numeros autogenerados por la base de datos
    //private UUID idInterno;
    
	private String dni_cedula_pasaporte_o_similar;
	private String nombre;
	private String apellidos;

	public Persona() {
	    
	}
	
	public Persona(Long idInterno, String pasaporte,
			                   String nombre, String apellidos) {
	    super();
		this.idInterno = idInterno;
		this.dni_cedula_pasaporte_o_similar = pasaporte;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	
	protected Long getIdInterno() {
		return idInterno;
	}
	protected void setIdInterno(Long id) {
		this.idInterno = id;
	}
	
	public String getDni_cedula_pasaporte_o_similar() {
		return dni_cedula_pasaporte_o_similar;
	}

	public void setDni_cedula_pasaporte_o_similar(String id) {
		this.dni_cedula_pasaporte_o_similar = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void actualizarDatos(Persona personaActualizada) {
        this.dni_cedula_pasaporte_o_similar = personaActualizada.getDni_cedula_pasaporte_o_similar();
        this.nombre = personaActualizada.getNombre();
        this.apellidos = personaActualizada.getApellidos();
	}



}
