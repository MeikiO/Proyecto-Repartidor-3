package es.susosise.pruebasgooglemaps;

import org.springframework.stereotype.Service;

@Service
public class ManejoDeRutas {

    public Ruta getRutaParaPruebas() {
        Ruta rutaDePrueba = new Ruta("Ruta de prueba", "Esto es un simple recorrido para hacer pruebas con él.");
        
        PuntoDeInteres primerPunto = new PuntoDeInteres("ARRASATE_PLAZANAGUSIA", 43.065898, -2.490159);
        primerPunto.descripcion="La plaza suele estar llena de niños jugando con balones...";
        rutaDePrueba.añadirUnPuntoAlRecorrido(primerPunto);
        
        PuntoDeInteres segundoPunto = new PuntoDeInteres("ARRASATE_MONTERRON", 43.066345, -2.491480);
        segundoPunto.descripcion = "Bonito palacio, pero mas bonito aún el jardin con sus grandes árboles...";
        rutaDePrueba.añadirUnPuntoAlRecorrido(segundoPunto);
        
        PuntoDeInteres tercerPunto = new PuntoDeInteres("ARRASATE_HOTEL_MONDRAGON", 43.064237,  -2.487558);
        tercerPunto.descripcion = "Un lugar donde poder dormir, comer,...";
        rutaDePrueba.añadirUnPuntoAlRecorrido(tercerPunto);
        
        return rutaDePrueba;
    }
    
}
