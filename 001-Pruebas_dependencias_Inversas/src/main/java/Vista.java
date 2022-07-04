import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Vista {
    
	private JFrame marcoPrincipal;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField identificacion;
	
	public Vista(Controlador controlador) {
		
		JButton btnRetrocederEnLaListaDePersonas = new JButton("ver la anterior");
		btnRetrocederEnLaListaDePersonas.addActionListener(controlador);
		btnRetrocederEnLaListaDePersonas.setActionCommand("MOSTRAR_ANTERIOR");
		
        JButton btnAvanzarEnLaListaDePersonas = new JButton("ver la siguiente");
        btnAvanzarEnLaListaDePersonas.addActionListener(controlador);
        btnAvanzarEnLaListaDePersonas.setActionCommand("MOSTAR_SIGUIENTE");
        
        JButton btnUnaNuevaEnBlanco = new JButton("una NUEVA en blanco");
        btnUnaNuevaEnBlanco.addActionListener(controlador);
        btnUnaNuevaEnBlanco.setActionCommand("NUEVA_EN_BLANCO");
        
 		JPanel botoneraSuperior = new JPanel();
		botoneraSuperior.setLayout(new FlowLayout());
		botoneraSuperior.setAlignmentX(FlowLayout.LEFT);
        botoneraSuperior.add(btnRetrocederEnLaListaDePersonas);
        botoneraSuperior.add(btnAvanzarEnLaListaDePersonas);
        botoneraSuperior.add(btnUnaNuevaEnBlanco);
		

        JButton btnGuardarPersona = new JButton("GUARDAR");
        btnGuardarPersona.addActionListener(controlador);
        btnGuardarPersona.setActionCommand("GUARDAR_PERSONA");
        
 		JPanel botoneraInferior = new JPanel();
 		botoneraInferior.setLayout(new FlowLayout());
 		botoneraInferior.setAlignmentX(FlowLayout.LEFT);
 		botoneraInferior.add(btnGuardarPersona);
          
        
        Box marcoNombre = new Box(BoxLayout.X_AXIS);
		marcoNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel lblNombre = new JLabel("Nombre:");
		nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(75, 25));	
		marcoNombre.add(lblNombre);
		marcoNombre.add(Box.createRigidArea(new Dimension(5,0)));
		marcoNombre.add(nombre);  
		
        Box marcoApellidos = new Box(BoxLayout.X_AXIS);
        marcoApellidos.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel lblApellidos = new JLabel("Apellidos:");
        apellidos = new JTextField();
        apellidos.setPreferredSize(new Dimension(250, 25));    
        marcoApellidos.add(lblApellidos);
        marcoApellidos.add(Box.createRigidArea(new Dimension(5,0)));
        marcoApellidos.add(apellidos);

        Box marcoIdentificacion = new Box(BoxLayout.X_AXIS);
        marcoIdentificacion.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel lblIdentificacion = new JLabel("Identificacion:");
        identificacion = new JTextField();
        identificacion.setPreferredSize(new Dimension(75, 25));    
        marcoIdentificacion.add(lblIdentificacion);
        marcoIdentificacion.add(Box.createRigidArea(new Dimension(5,0)));
        marcoIdentificacion.add(identificacion);

        Box formulario = new Box(BoxLayout.Y_AXIS);
        formulario.setAlignmentX(Component.LEFT_ALIGNMENT);
        formulario.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        formulario.add(marcoNombre);
        formulario.add(Box.createRigidArea(new Dimension(0,5)));
        formulario.add(marcoApellidos);
        formulario.add(Box.createRigidArea(new Dimension(0,5)));
        formulario.add(marcoIdentificacion);

		marcoPrincipal = new JFrame();
		marcoPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		marcoPrincipal.setTitle("Personas");
		marcoPrincipal.getContentPane().setLayout(new BorderLayout());
        marcoPrincipal.add(botoneraSuperior, BorderLayout.NORTH);
        marcoPrincipal.add(formulario, BorderLayout.CENTER);
        marcoPrincipal.add(botoneraInferior, BorderLayout.SOUTH);
		marcoPrincipal.pack();
	}
	
	protected void mostrarInterface() {
		marcoPrincipal.setVisible(true);
	}

	
	protected String getNombre() {
	    return nombre.getText();
	}
	
	protected void setNombre(String texto) {
	    nombre.setText(texto);
	}
	
	protected String getApellidos() {
	    return apellidos.getText();
	}
	protected void setApellidos(String texto) {
	    apellidos.setText(texto);
	}

	protected String getIdentificacion() {
	    return identificacion.getText();
	}
	protected void setIdentificacion(String texto) {
	    identificacion.setText(texto);
	}

}
