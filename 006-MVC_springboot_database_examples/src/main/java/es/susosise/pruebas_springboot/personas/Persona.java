package es.susosise.pruebas_springboot.personas;

import es.susosise.pruebas_springboot.actividades.Actividad;
import es.susosise.pruebas_springboot.poblaciones.Poblacion;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="persona_id")
    private Long idInterno;
    
	private String dni_cedula_pasaporte_o_similar;
	private String nombre;
	private String apellidos;
	@OneToOne
	@JoinColumn(name="poblacion_id")
	private Poblacion poblacion;
	@OneToMany
	@JoinColumn(name="telefono_id")
	private List<Telefono> telefonos;

	@ManyToMany
	@JoinTable(
	        name = "persona_actividad",
	        joinColumns = { @JoinColumn(name="persona_id") },
	        inverseJoinColumns = { @JoinColumn(name="actividad_id") }
	)
	
	private Set<Actividad> actividades;


	public Persona() {
	    
	}
	
	public Persona(Long idInterno, String dni_cedula_pasaporte_o_similar,
			       String nombre, String apellidos, Poblacion poblacion) {
	    super();
		this.idInterno = idInterno;
		this.dni_cedula_pasaporte_o_similar = dni_cedula_pasaporte_o_similar;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.poblacion = poblacion;
	}
	
	
	public Long getIdInterno() {
		return idInterno;
	}
	public void setIdInterno(Long id) {
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


    public Poblacion getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }
    
    

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void actualizarDatos(Persona personaActualizada) {
        this.dni_cedula_pasaporte_o_similar = personaActualizada.getDni_cedula_pasaporte_o_similar();
        this.nombre = personaActualizada.getNombre();
        this.apellidos = personaActualizada.getApellidos();
        this.poblacion = personaActualizada.getPoblacion();
	}



}
