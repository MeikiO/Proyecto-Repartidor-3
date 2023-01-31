package edu.mondragon.mikel_murua.proyecto_repartidor3.parte_datos.repartidor;

public class RepartidorDTO {

	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String tlf;
	

	public RepartidorDTO(String nombre, String apellidos, String dni, String direccion, String tlf) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.tlf = tlf;
	}
	
}
