package clases_para_parsear_respuesta;

public class ViewPort {
	Location notheast;
	Location southwest;
	
	public ViewPort() {
	}

	public ViewPort(Location notheast, Location southwest) {
		super();
		this.notheast = notheast;
		this.southwest = southwest;
	}

	public Location getNotheast() {
		return notheast;
	}

	public void setNotheast(Location notheast) {
		this.notheast = notheast;
	}

	public Location getSouthwest() {
		return southwest;
	}

	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	
}
