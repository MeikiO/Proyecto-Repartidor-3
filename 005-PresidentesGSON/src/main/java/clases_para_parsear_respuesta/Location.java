package clases_para_parsear_respuesta;

public class Location {
	double lat;
	double lng;
	public Location() {
	}
	public Location(int lat, int lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}

	
}
