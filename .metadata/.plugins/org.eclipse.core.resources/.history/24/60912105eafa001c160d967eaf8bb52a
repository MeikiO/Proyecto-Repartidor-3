package z_enumeraciones;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public enum TipoReparto {

	Berria(Color.BLUE,""),
	Argia(Color.red,"mie");
	
	private Color color;
	private String diaSemana;
	private final static String separador=":";

	private TipoReparto(Color color,String diaSemana) {
		this.color=color;
		this.setDiaSemana(diaSemana);
	}
	
	public final static List<TipoReparto> cogerCadena(String texto){
		List<TipoReparto> lista=new ArrayList<>();
		String[] elementos=texto.split(TipoReparto.separador);
		
		for(String actual:elementos) {
			TipoReparto nuevo=TipoReparto.valueOf(actual);
			lista.add(nuevo);
		}
		
		return lista;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	
}
