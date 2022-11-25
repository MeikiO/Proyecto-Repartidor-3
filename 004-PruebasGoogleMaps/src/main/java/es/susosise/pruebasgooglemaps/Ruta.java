package es.susosise.pruebasgooglemaps;

import java.util.ArrayList;

public class Ruta {

    private String nombre;
    public String descripcion;
    private ArrayList<PuntoDeInteres> recorrido;
    
    public Ruta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        recorrido = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public ArrayList<PuntoDeInteres> getRecorrido() {
        return (ArrayList<PuntoDeInteres>)recorrido.clone();
    }
    
    public void añadirUnPuntoAlRecorrido(PuntoDeInteres punto) {
        recorrido.add(punto);
    }
    
    
}
