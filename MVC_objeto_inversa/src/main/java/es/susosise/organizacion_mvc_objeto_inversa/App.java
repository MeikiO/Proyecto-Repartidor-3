
package es.susosise.organizacion_mvc_objeto_inversa;

import java.io.IOException;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {

		String direction = "MVC_objeto_inversa/src/main/resources/personas-registrosDeMuestra-.txt";
		try {

			Modelo_persistencia_Personas_enDisco personas;
			personas = new Modelo_persistencia_Personas_enDisco(direction);

			Controlador controlador = new Controlador(personas);

			Vista vista = new Vista(controlador);

			controlador.arrancar(vista);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Problemas al acceder a los datos en la carpeta indicada: [" + direction + "]"
							+ System.lineSeparator() + System.lineSeparator()
							+ e.getMessage());
			e.printStackTrace();
		}
	}

}
