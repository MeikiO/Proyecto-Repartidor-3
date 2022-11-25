package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas.clase_de_parseo;
public class Geometry {
	Location location;
	String location_type;
	ViewPort viewport;
	
	public Geometry() {
	}

	public Geometry(Location location, String location_type, ViewPort viewport) {
		super();
		this.location = location;
		this.location_type = location_type;
		this.viewport = viewport;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public ViewPort getViewport() {
		return viewport;
	}

	public void setViewport(ViewPort viewport) {
		this.viewport = viewport;
	}
	
}
