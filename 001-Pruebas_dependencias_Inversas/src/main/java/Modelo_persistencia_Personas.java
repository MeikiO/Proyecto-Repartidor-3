import java.io.IOException;
import java.util.UUID;

public interface Modelo_persistencia_Personas {

    Modelo_POJO_Persona get(UUID idInterno);

    Modelo_POJO_Persona get(String nombreyapellidos);

    int getCuantasHay();
    
    public Modelo_POJO_Persona get(int indice);

    void guardar(Modelo_POJO_Persona persona) throws IOException;

}