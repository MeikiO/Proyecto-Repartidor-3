import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
    
    private Vista vista;
    private Modelo_persistencia_Personas personas;
    private int indiceDeLaPersonaEnCurso;
    private Modelo_POJO_Persona personaEnCurso;
    
    public Controlador(Modelo_persistencia_Personas personas) {
        this.personas = personas;
        indiceDeLaPersonaEnCurso = 0;
        personaEnCurso = personas.get(indiceDeLaPersonaEnCurso);
    }
    
    public void arrancar(Vista vista) {
        this.vista = vista;
        vista.mostrarInterface();
        mostrarDatosEnLaVista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("MOSTRAR_ANTERIOR")) {
            indiceDeLaPersonaEnCurso = indiceDeLaPersonaEnCurso - 1;
            if (indiceDeLaPersonaEnCurso < 0 ) {
               indiceDeLaPersonaEnCurso = personas.getCuantasHay() - 1;
            }
            personaEnCurso = personas.get(indiceDeLaPersonaEnCurso);
            if(personaEnCurso == null) {
                JOptionPane.showMessageDialog(null, "No hay ninguna persona en la lista");
            }
            mostrarDatosEnLaVista();
        }
        else if (comando.equals("MOSTAR_SIGUIENTE")) {
            indiceDeLaPersonaEnCurso = indiceDeLaPersonaEnCurso + 1;
            if (indiceDeLaPersonaEnCurso > (personas.getCuantasHay() - 1 )) {
               indiceDeLaPersonaEnCurso = 0;
            }
            personaEnCurso = personas.get(indiceDeLaPersonaEnCurso);
            if(personaEnCurso == null) {
                JOptionPane.showMessageDialog(null, "No hay ninguna persona en la lista");
            }
            mostrarDatosEnLaVista();
        }
        else if (comando.equals("NUEVA_EN_BLANCO")) {
            personaEnCurso = null;
            mostrarDatosEnLaVista();
        }
        else if (comando.equals("GUARDAR_PERSONA")) {
            if (personaEnCurso == null) {
                if (!vista.getNombre().isBlank() || !vista.getApellidos().isBlank()) {
                    personaEnCurso = Modelo_POJO_Persona.crearNuevaPersona(vista.getNombre(), vista.getApellidos());
                    personaEnCurso.setDni_cedula_pasaporte_o_similar(vista.getIdentificacion());
                }
            }
            else {
                personaEnCurso.setNombre(vista.getNombre());
                personaEnCurso.setApellidos(vista.getApellidos());
                personaEnCurso.setDni_cedula_pasaporte_o_similar(vista.getIdentificacion());
            }
            
            try {
                personas.guardar(personaEnCurso);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error al guardar." + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    private void mostrarDatosEnLaVista() {
        if (personaEnCurso == null){
            vista.setNombre("");
            vista.setApellidos("");
            vista.setIdentificacion("");
        }
        else {
            vista.setNombre(personaEnCurso.getNombre());
            vista.setApellidos(personaEnCurso.getApellidos());
            vista.setIdentificacion(personaEnCurso.getDni_cedula_pasaporte_o_similar());
        }
        
    }
    
}
