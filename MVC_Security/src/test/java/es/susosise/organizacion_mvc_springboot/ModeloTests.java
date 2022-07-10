package es.susosise.organizacion_mvc_springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.susosise.pruebas_springboot.personas.Personas;

@SpringBootTest
class ModeloTests {
    
    @Autowired
    private Personas personas;
    

//    @Test
//    void inicializarLaPersistenciaCreaUnaListaDePersonasVacia() {
//        assertEquals(0, (personas.getCuantasHay()));
//    }
//    
//    @Test
//    void conLaListaDePersonasVaciaNoDaErrorIntentarRecuperarUna() {
//        //assertNull(personas.get(UUID.randomUUID()));
//        assertNull(personas.get("Benzirpi Mirvento"));
//        assertNull(personas.get(0));
//    }
//
//    
//    @Test
//    void seCreaYseGuardaYseRecuperaUnaNuevaPersona() {
//        Modelo_pojo_Persona nuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
//        personas.guardar(nuevaPersona);
//        Modelo_pojo_Persona personaRecuperada = personas.get(nuevaPersona.getIdInterno());
//        assertEquals(personaRecuperada, nuevaPersona);
//    }
//    
//    @Test
//    void alIntentarRecuperarUnaPersonaQueNoExisteDevuelveNull() {
//        Modelo_pojo_Persona nuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
//        personas.guardar(nuevaPersona);
//        Modelo_pojo_Persona otraNuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Riverti", "Zarimte");
//        personas.guardar(otraNuevaPersona);
//        assertNull(personas.get(UUID.randomUUID()));
//        assertNull(personas.get("Unnombre Quenoexiste"));
//        assertNull(personas.get(personas.getCuantasHay() + 1));
//    }
//    
//    @Test
//    void seRecuperaUnaPersonaSegunSuNombreYApellidos() {
//        Modelo_pojo_Persona nuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
//        personas.guardar(nuevaPersona);
//        Modelo_pojo_Persona otraNuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Riverti", "Zarimte");
//        personas.guardar(otraNuevaPersona);
//        Modelo_pojo_Persona personaRecuperada = personas.get("Benzirpi Mirvento");
//        assertEquals(personaRecuperada, nuevaPersona);
//        Modelo_pojo_Persona otraPersonaRecuperada = personas.get("Riverti Zarimte");
//        assertEquals(otraPersonaRecuperada, otraNuevaPersona);
//    }
//    
//    @Test
//    void seRecuperaUnaPersonaSegunSuIndiceEnLaLista() {
//        Modelo_pojo_Persona nuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
//        personas.guardar(nuevaPersona);
//        Modelo_pojo_Persona otraNuevaPersona = Modelo_pojo_Persona.crearNuevaPersona("Riverti", "Zarimte");
//        personas.guardar(otraNuevaPersona);
//        Modelo_pojo_Persona personaRecuperada = personas.get(0);
//        assertEquals(personaRecuperada, nuevaPersona);
//        Modelo_pojo_Persona otraPersonaRecuperada = personas.get(1);
//        assertEquals(otraPersonaRecuperada, otraNuevaPersona);
//    }
//    
    
    
}
