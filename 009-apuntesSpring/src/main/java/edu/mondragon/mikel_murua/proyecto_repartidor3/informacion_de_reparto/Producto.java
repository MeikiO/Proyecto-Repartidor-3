package edu.mondragon.mikel_murua.proyecto_repartidor3.informacion_de_reparto;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public enum Producto {

	Berria(Color.BLUE,""),
	Argia(Color.red,"mie");
	
	private Color color;
	private String diaSemana;
	private final static String separador=":";

	private Producto(Color color,String diaSemana) {
		this.color=color;
		this.setDiaSemana(diaSemana);
	}
	
	public final static List<Producto> cogerCadena(String texto){
		List<Producto> lista=new ArrayList<>();
		String[] elementos=texto.split(Producto.separador);
		
		for(String actual:elementos) {
			Producto nuevo=Producto.valueOf(actual);
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
