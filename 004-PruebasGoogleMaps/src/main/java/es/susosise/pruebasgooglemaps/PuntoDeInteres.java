package es.susosise.pruebasgooglemaps;


public class PuntoDeInteres {
    
    private String nombre;
    public String descripcion;
    private Double latitud;
    private Double longitud;
    
    public PuntoDeInteres(String nombre, Double latitud, Double longitud) {
        super();
        this.nombre = nombre;
        setLatitud(latitud);
        setLongitud(longitud);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setLatitud(Double latitud) {
        if (latitud > -90 && latitud < 90) {
            this.latitud = latitud;
        }else {
            throw new IllegalArgumentException("La latitud ha de estar comprendida entre -90.000000 y 90.000000");
        }
    }
    public void setLongitud(Double longitud) {
        if (longitud > -180 && longitud < 180) {
            this.longitud = longitud;
        }else {
            throw new IllegalArgumentException("La longitud ha de estar comprendida entre -180.000000 y 180.000000");
        }
    }
    public Double getLatitud() {
        return latitud;
    }
    public Double getLongitud() {
        return longitud;
    }

}
