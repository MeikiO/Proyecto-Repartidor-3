/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;

import clases_para_parsear_respuesta.TransCripcionJson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author flarrinaga
 */
public class JSON2Object {

    public static void main(String[] args) {

        Gson gson = new Gson();
        
        TransCripcionJson resultado;
        
        try (Reader reader = new FileReader("C:\\Users\\Lenovo\\Desktop\\Codigo repartidor3\\005-PresidentesGSON\\src\\main\\java\\01-Tabla de presidentes.json")) {

			// Convert JSON to Java Object
            resultado = gson.fromJson(reader, TransCripcionJson.class);
            
            
           System.out.println(resultado);
           
         double lat=resultado.getResults().get(0).getGeometry().getLocation().getLat();
         double lng=resultado.getResults().get(0).getGeometry().getLocation().getLng();
         
         System.out.println("Lat: "+lat+" longitud:"+lng);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


 