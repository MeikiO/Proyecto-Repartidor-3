package es.susosise.organizacion_mvc_objeto_inversa;

import java.util.ArrayList;
import java.util.UUID;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;


public class Modelo_persistencia_Personas_enDisco implements Modelo_persistencia_Personas {
	
	private static final String SEPARADOR = " : ";
	
	private static final String ARCHIVO_PERSONAS = "personas.txt";
	private Path archivoPersonas;
	private ArrayList<Modelo_POJO_Persona> personas;
	
	
	public Modelo_persistencia_Personas_enDisco(String pathCarpetaDeDatos) throws IOException {
		Path carpetaDeDatos = java.nio.file.Paths.get(pathCarpetaDeDatos);
		if(!Files.exists(carpetaDeDatos)) {
		    Files.createDirectories(carpetaDeDatos);
		}
		archivoPersonas = carpetaDeDatos.resolve(ARCHIVO_PERSONAS);
		if(!Files.exists(archivoPersonas)) {
		    Files.createFile(archivoPersonas);
		}
		
		personas = new ArrayList<>();
		leerPersonasDelDisco();
	}

	
	@Override
    public Modelo_POJO_Persona get(UUID idInterno) {
	    for(Modelo_POJO_Persona persona : personas) {
	        if (persona.getIdInterno().equals(idInterno)) {
	            return persona;
	        }
	    }
	    return null;
	}
	
    @Override
    public Modelo_POJO_Persona get(String nombreyapellidos) {
        for(Modelo_POJO_Persona persona : personas) {
            String texto = persona.getNombre() + " " + persona.getApellidos();
            if (texto.equals(nombreyapellidos)) {
                return persona;
            }
        }
        return null;
    }
    
    @Override
    public int getCuantasHay() {
        return personas.size();
    }
    
    @Override
    public Modelo_POJO_Persona get(int indice) {
        if (!personas.isEmpty() && indice > -1 && indice < personas.size()) {
            return personas.get(indice);
        }
        else {
            return null;
        }
    }
   
	
	@Override
    public void guardar(Modelo_POJO_Persona persona) throws IOException {
	    Modelo_POJO_Persona existente = get(persona.getIdInterno());
	    if (existente == null) {
    	    personas.add(persona);
	    }
	    else {
	        existente.actualizarDatos(persona);
	    }
	    guardarPersonasEnElDisco();
	}
	
	
	private void leerPersonasDelDisco() throws IOException {
		
		personas.clear();
		try(BufferedReader lector = new BufferedReader(new FileReader(archivoPersonas.toFile()))){
			String linea = lector.readLine();
			while(linea != null) {
				personas.add(Modelo_POJO_Persona.deserializarDesdeTexto(linea, SEPARADOR));
				linea = lector.readLine();
			}
		}
	}
	
	private void guardarPersonasEnElDisco() throws IOException {
		
		try(BufferedWriter escritorPersonas = new BufferedWriter(new FileWriter(archivoPersonas.toFile()))){
			for(Modelo_POJO_Persona persona : personas) {
				escritorPersonas.write(persona.serializarATexto(SEPARADOR));
			}
		}
		
	}
	
	
}
