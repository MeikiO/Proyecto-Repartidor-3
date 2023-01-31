package es.susosise.organizacion_mvc_objeto_inversa;

import java.util.Objects;
import java.util.UUID;

public class Modelo_POJO_Persona {
	private UUID idInterno;
	private String dni_cedula_pasaporte_o_similar;
	private String nombre;
	private String apellidos;

	public Modelo_POJO_Persona(UUID idInterno, String pasaporte,
			                   String nombre, String apellidos) {
		this.idInterno = idInterno;
		this.dni_cedula_pasaporte_o_similar = pasaporte;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public static Modelo_POJO_Persona crearNuevaPersona(String nombre, String apellidos) {
		return new Modelo_POJO_Persona(UUID.randomUUID(), null,
				                       nombre, apellidos);
	}
	
	
	protected UUID getIdInterno() {
		return idInterno;
	}
	protected void setIdInterno(UUID id) {
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

	public void actualizarDatos(Modelo_POJO_Persona personaActualizada) {
        this.dni_cedula_pasaporte_o_similar = personaActualizada.getDni_cedula_pasaporte_o_similar();
        this.nombre = personaActualizada.getNombre();
        this.apellidos = personaActualizada.getApellidos();
	}
    
    @Override
    public int hashCode() {
        return Objects.hash(this.idInterno,
                            this.dni_cedula_pasaporte_o_similar,
                            this.nombre,
                            this.apellidos);
    }
    
    @Override
    public boolean equals(Object unObjeto) {
        if (this == unObjeto) {
            return true;
        }
        if (unObjeto == null) {
            return false;
        }
        if (getClass() != unObjeto.getClass()) {
            return false;
        }
        Modelo_POJO_Persona unaPersona = (Modelo_POJO_Persona)unObjeto;
        return Objects.equals(this.idInterno, unaPersona.idInterno)
            && Objects.equals(this.dni_cedula_pasaporte_o_similar, unaPersona.dni_cedula_pasaporte_o_similar)
            && Objects.equals(this.nombre, unaPersona.nombre)
            && Objects.equals(this.apellidos, unaPersona.apellidos);
    }
	
	
	

	public String serializarATexto(String separador) {
		StringBuilder linea = new StringBuilder();
		
		linea.append(nombre);
		linea.append(separador);
		
		linea.append(apellidos);
		linea.append(separador);
		
		linea.append(dni_cedula_pasaporte_o_similar);
		linea.append(separador);
		
		linea.append(idInterno.toString());
		linea.append(System.lineSeparator());
		
		return linea.toString();
	}
	
	public static Modelo_POJO_Persona deserializarDesdeTexto(String lineaDeDatos, String separador) {
		String[] datos = lineaDeDatos.split(separador);
		if(datos.length == 4) {
			return new Modelo_POJO_Persona(UUID.fromString(datos[3]), datos[2], datos[0], datos[1]);			
		}
		else {
			throw new IllegalArgumentException(
					"Error: no se puede interpretar correctamente esta linea:"
					+ System.lineSeparator() + System.lineSeparator()
					+ lineaDeDatos
					);
		}
	}


	

}
