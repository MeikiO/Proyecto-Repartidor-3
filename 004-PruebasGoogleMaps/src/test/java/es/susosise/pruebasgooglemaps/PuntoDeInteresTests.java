package es.susosise.pruebasgooglemaps;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PuntoDeInteresTests {

    @Test
    void seCreaCorrectamenteUnPuntoDeInteresParaGreenwich() {
        PuntoDeInteres punto = new PuntoDeInteres("Greenwich", 0.000001, 0.000002);
        punto.descripcion = "Este es el observatorio de Greenwich, donde se ha establecido el origen de coordenadas.";
        assertEquals("Greenwich", punto.getNombre());
        assertEquals(0.000001, punto.getLatitud());
        assertEquals(0.000002, punto.getLongitud());
    }
    

	@Test
	void noSePermiteUnaLatitudMayorDelLimite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
             new Executable() {
                @Override
                public void execute() throws Throwable {
                    PuntoDeInteres punto = new PuntoDeInteres("prueba", 90.123456, 0.000000);
                }
             }
                                                         );
	    
	}
	
    @Test
    void noSePermiteUnaLatitudMenorDelLimite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
             new Executable() {
                @Override
                public void execute() throws Throwable {
                    PuntoDeInteres punto = new PuntoDeInteres("prueba", -90.123456, 0.000000);
                }
             }
                                                         );
        
    }

    @Test
    void noSePermiteUnaLongitudMayorDelLimite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
             new Executable() {
                @Override
                public void execute() throws Throwable {
                    PuntoDeInteres punto = new PuntoDeInteres("prueba", 0.000000, 180.123456);
                }
             }
                                                         );
        
    }
    
    @Test
    void noSePermiteUnaLongitudMenorDelLimite() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
             new Executable() {
                @Override
                public void execute() throws Throwable {
                    PuntoDeInteres punto = new PuntoDeInteres("prueba", 0.000000, -180.123456);
                }
             }
                                                         );
        
    }

}
