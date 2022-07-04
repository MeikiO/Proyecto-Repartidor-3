package z_enumeraciones;

import java.util.Calendar;

public enum DiasSemana {
	
	Domingo("do",0),
	Lunes("lu",1),
	Martes("mar",2),
	Miercoles("mie",3),
	Jueves("ju",4),
	Viernes("vi",5),
	Sabado("sa",6);
	
	public String abreviacion;
	public int diaSemana;

	DiasSemana(String string,int dayOfTheWeek) {
		this.abreviacion=string;
		this.diaSemana=dayOfTheWeek;
	}

	public static DiasSemana cogerDia(int dia) {
		DiasSemana abreviacionDia=null;
		
		for(DiasSemana actual:DiasSemana.values()) {
			if(actual.getDiaSemana()==dia) {
				abreviacionDia=actual;
			}
			
		}
		return abreviacionDia;
	}
	
	public static DiasSemana getDiaDeAbreviacion(String abreviacion) {
		DiasSemana numDia = null;
		for(DiasSemana actual:DiasSemana.values()) {
			if(actual.getAbreviacion().equals(abreviacion)) {
				numDia=actual;
			}
			
		}
		return numDia;
	}
	
	public static DiasSemana getDiaNombreEntero(String nomEntero) {
		DiasSemana numDia = null;
		for(DiasSemana actual:DiasSemana.values()) {
			if(actual.name().equals(nomEntero)) {
				numDia=actual;
			}
			
		}
		return numDia;
	}
	
	public static DiasSemana diaActual() {
	      Calendar calendar = Calendar.getInstance();
	      return DiasSemana.cogerDia(calendar.get(Calendar.DAY_OF_WEEK) - 1);
	}
	
	public String getAbreviacion() {
		return abreviacion;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

}
