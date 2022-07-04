package z_enumeraciones;

public enum Poblacion {

	Arrasate(1,"Guipuzkoa","20500"),
	Aretxabaleta(2,"Guipuzkoa","20550"),
	Oñati(3,"Guipuzkoa","20560"),
	Bergara(4,"Guipuzkoa","20570"),
	Osintxu(5,"Guipuzkoa","20580"),
	Soraluze(6,"Guipuzkoa","20590"),
	Eibar(7,"Guipuzkoa","20600");
		
	private String codigoPostal;
	private String region;
	private int id;

	private Poblacion() {
	}
	
	Poblacion(int id,String string2, String string3) {
		this.id=id;
		this.region=string2;
		this.codigoPostal=string3;	
	}
	
	public final static int numeroPoblaciones(){
		return Poblacion.values().length;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
