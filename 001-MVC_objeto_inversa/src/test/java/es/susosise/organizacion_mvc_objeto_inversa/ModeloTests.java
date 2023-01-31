package es.susosise.organizacion_mvc_objeto_inversa;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModeloTests {
    
    private Modelo_persistencia_Personas personas;
    
    private String carpetaTemporal;
    static String getUnaCarpetaTemporal() {
        return (System.getProperty("user.home")+ File.separator 
                + "Pruebas" + UUID.randomUUID().toString());
    }
    static void borrarRecursivo (File carpeta) {
        if (carpeta.exists()) {
            if (carpeta.isDirectory()) {
                for (File contenido : carpeta.listFiles()) {
                    borrarRecursivo(contenido);
                }
            }
            carpeta.delete();
        }
    }

    @BeforeEach
    void setUp() throws Exception {
        carpetaTemporal = getUnaCarpetaTemporal();
        personas = new Modelo_persistencia_Personas_enDisco(carpetaTemporal);
    }

    @AfterEach
    void tearDown() throws Exception {
        borrarRecursivo(new File(carpetaTemporal));
    }

    @Test
    void inicializarLaPersistenciaCreaUnaListaDePersonasVacia() {
        assertEquals(0, (personas.getCuantasHay()));
    }
    
    @Test
    void conLaListaDePersonasVaciaNoDaErrorIntentarRecuperarUna() {
        assertNull(personas.get(UUID.randomUUID()));
        assertNull(personas.get("Benzirpi Mirvento"));
        assertNull(personas.get(0));
    }

    
    @Test
    void seCreaYseGuardaYseRecuperaUnaNuevaPersona() throws IOException {
        Modelo_POJO_Persona nuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
        personas.guardar(nuevaPersona);
        Modelo_POJO_Persona personaRecuperada = personas.get(nuevaPersona.getIdInterno());
        assertEquals(personaRecuperada, nuevaPersona);
    }
    
    @Test
    void alIntentarRecuperarUnaPersonaQueNoExisteDevuelveNull() throws IOException {
        Modelo_POJO_Persona nuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
        personas.guardar(nuevaPersona);
        Modelo_POJO_Persona otraNuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Riverti", "Zarimte");
        personas.guardar(otraNuevaPersona);
        assertNull(personas.get(UUID.randomUUID()));
        assertNull(personas.get("Unnombre Quenoexiste"));
        assertNull(personas.get(personas.getCuantasHay() + 1));
    }
    
    @Test
    void seRecuperaUnaPersonaSegunSuNombreYApellidos() throws IOException {
        Modelo_POJO_Persona nuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
        personas.guardar(nuevaPersona);
        Modelo_POJO_Persona otraNuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Riverti", "Zarimte");
        personas.guardar(otraNuevaPersona);
        Modelo_POJO_Persona personaRecuperada = personas.get("Benzirpi Mirvento");
        assertEquals(personaRecuperada, nuevaPersona);
        Modelo_POJO_Persona otraPersonaRecuperada = personas.get("Riverti Zarimte");
        assertEquals(otraPersonaRecuperada, otraNuevaPersona);
    }
    
    @Test
    void seRecuperaUnaPersonaSegunSuIndiceEnLaLista() throws IOException {
        Modelo_POJO_Persona nuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Benzirpi", "Mirvento");
        personas.guardar(nuevaPersona);
        Modelo_POJO_Persona otraNuevaPersona = Modelo_POJO_Persona.crearNuevaPersona("Riverti", "Zarimte");
        personas.guardar(otraNuevaPersona);
        Modelo_POJO_Persona personaRecuperada = personas.get(0);
        assertEquals(personaRecuperada, nuevaPersona);
        Modelo_POJO_Persona otraPersonaRecuperada = personas.get(1);
        assertEquals(otraPersonaRecuperada, otraNuevaPersona);
    }
    
    
    
}
