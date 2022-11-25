package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas;


public class Coordenadas {
	private double coordenadasLatitud;
	private double coordenadasLongitud;
	

	public Coordenadas(double latitud, double longitud) {
		this.coordenadasLatitud=latitud;
		this.coordenadasLongitud=longitud;

	}

	public double getCoordenadasLatitud() {
		return coordenadasLatitud;
	}

	public void setCoordenadasLatitud(double coordenadasLatitud) {
		this.coordenadasLatitud = coordenadasLatitud;
	}

	public double getCoordenadasLongitud() {
		return coordenadasLongitud;
	}

	public void setCoordenadasLongitud(double coordenadasLongitud) {
		this.coordenadasLongitud = coordenadasLongitud;
	}


	@Override
	public String toString() {
		return "Coordenadas [coordenadasLatitud=" + coordenadasLatitud + ", coordenadasLongitud=" + coordenadasLongitud
				+ "]";
	}

}
