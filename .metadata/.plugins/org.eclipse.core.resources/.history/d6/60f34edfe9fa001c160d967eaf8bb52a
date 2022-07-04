package z_modelo_equipo_repartidores;

import java.util.ArrayList;
import java.util.List;

import z_enumeraciones.Poblacion;

public class Repartidor implements Miembro{
	
	private boolean admin;
	private String password;
	private String username;
	private Poblacion zona_trabajo;
	private String tlf;
	private String direccion;
	private String dni;
	private String apellido;
	private String nombre;
	private int idEquipo;
	private int id_repartidor;
	
	private List<RegistroReparto> listaReparto;

	public Repartidor() {
	}
	
	public Repartidor(String nombre,String apellido, String dni,String direccion
			,String tlf,String poblacion,String username,String password,boolean admin) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.tlf=tlf;
		this.zona_trabajo=Poblacion.valueOf(poblacion);
		this.username=username;
		this.password=password;
		this.admin=admin;
		this.idEquipo=this.zona_trabajo.getId();
		
		this.listaReparto=new ArrayList<>();
	}
	public Repartidor(int id_repartidor,String nombre,String apellido, String dni,String direccion
			,String tlf,String poblacion,String username,String password,boolean admin,int id_grupo) {
		
		this.id_repartidor=id_repartidor;
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.tlf=tlf;
		this.zona_trabajo=Poblacion.valueOf(poblacion);
		this.username=username;
		this.password=password;
		this.admin=admin;
		this.idEquipo=id_grupo;
	
		this.listaReparto=new ArrayList<>();
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Poblacion getZona_trabajo() {
		return zona_trabajo;
	}

	public void setZona_trabajo(Poblacion zona_trabajo) {
		this.zona_trabajo = zona_trabajo;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(int id_repartidor) {
		this.id_repartidor = id_repartidor;
	}

	public List<RegistroReparto> getListaReparto() {
		return listaReparto;
	}

	public void setListaReparto(List<RegistroReparto> listaReparto) {
		this.listaReparto = listaReparto;
	}

	@Override
	public String toString() {
		return ""+this.getNombre()+" "+this.getApellido();
	}

	@Override
	public int getIdEquipo() {
		return this.idEquipo;
	}
	@Override
	public void setIdEquipo(int id) {
		this.idEquipo=id;
	}
	
	@Override
	public Poblacion getPoblacion() {
		return this.zona_trabajo;
	}
	@Override
	public void setPoblacion(Poblacion poblacion) {
		this.zona_trabajo=poblacion;
	}
	@Override
	public int getIdParticular() {
		return this.id_repartidor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_repartidor;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repartidor other = (Repartidor) obj;
		if (id_repartidor != other.id_repartidor)
			return false;
		return true;
	}

}
