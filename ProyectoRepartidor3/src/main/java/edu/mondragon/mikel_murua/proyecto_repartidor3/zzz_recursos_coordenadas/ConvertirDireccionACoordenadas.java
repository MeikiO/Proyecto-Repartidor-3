package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import edu.mondragon.mikel_murua.proyecto_repartidor3.logistica.poblacion.Poblacion_Pojo;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas.clase_de_parseo.Location;
import edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_coordenadas.clase_de_parseo.TransCripcionJson;

public class ConvertirDireccionACoordenadas {
	private static final String API_KEY = "AIzaSyApwAN0oIELXbhbqji-3m0jJ7ktyiiMLDM";
    private static final String LLAMADA_WEB_API = "https://maps.googleapis.com/maps/api/geocode/json?";

    
    public static void main(String[] args) throws IOException, InterruptedException {

    	ConvertirDireccionACoordenadas programa=new ConvertirDireccionACoordenadas();
     	String direccion=	"Biteri Hiribidea, 2, 2i";

     	Poblacion_Pojo poblacion=new Poblacion_Pojo((long) 16.0, "20500","Guipuzkoa", "Arrasate");
     	
     	Coordenadas coordenadaEspecificada=programa.realizarConsultaDeCoordenada(direccion,poblacion);

    }
    
	public Coordenadas realizarConsultaDeCoordenada(String direccion, Poblacion_Pojo poblacion) throws IOException, InterruptedException {
		String resultado="";
     	Coordenadas conversor=null;
		
     	try {
     		resultado=this.realizarConsultaDeDireccion(poblacion,direccion);
     		conversor=this.hacerParseoDeResultadoWeb(resultado);
     	}
     	catch(Exception ex) {
     		ex.printStackTrace();
     	}
     
		return conversor;
	}

	public String realizarConsultaDeDireccion(Poblacion_Pojo poblacion, String direccion) throws IOException, InterruptedException {	
		
		direccion= direccion+","+poblacion.getNombreLocalizacion()+","+poblacion.getCodigoPostal()+","+poblacion.getRegion();
		
		String direccionCodificada=this.codificarDireccion(direccion);
    	
    	System.out.println(direccion);
    	System.out.println(direccionCodificada);
    		
    	
    	String requestUri = LLAMADA_WEB_API  
        		+ "address="+direccionCodificada
        		+ "&key="+API_KEY;
    	
    	System.out.println(requestUri);
    		
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUri))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        
        System.out.println("------------------------------------------");
              
        return response.body();   
	}

	public String codificarDireccion(String direccion) {
    	
    	String direccionCodificada=new String(direccion);
    	
    	/*
    	 
    	  https://maps.googleapis.com/maps/api/geocode/json?
    	  address=1600+Amphitheatre+Parkway,+Mountain+View,+CA
    	  &key=YOUR_API_KEY
    	  
    	  -> en la direccion se sustituyen los espacios por [+]
    	  
    	 */
    	
    	direccionCodificada=direccionCodificada.replaceAll("\s+","+");// quita espacios y pone un solo [ + ]
		
    	return direccionCodificada.toString();
    }
    
    public Coordenadas hacerParseoDeResultadoWeb(String respuesta) {
    	Gson gson = new Gson();
     	Coordenadas conversor=null;
     	
     	if(!respuesta.isEmpty()) {
     		TransCripcionJson resultado = gson.fromJson(respuesta, TransCripcionJson.class);
     		Location loc=resultado.getResults().get(0).getGeometry().getLocation();
     		conversor=new Coordenadas(loc.getLat(),loc.getLng());     		
     	}
     	
     	return conversor;
	}
	
}