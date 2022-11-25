package clases_para_parsear_respuesta;

public class PlusCode {
	String compound_code;
	String global_code;
	public PlusCode() {
	}
	public PlusCode(String compound_code, String global_code) {
		super();
		this.compound_code = compound_code;
		this.global_code = global_code;
	}
	public String getCompound_code() {
		return compound_code;
	}
	public void setCompound_code(String compound_code) {
		this.compound_code = compound_code;
	}
	public String getGlobal_code() {
		return global_code;
	}
	public void setGlobal_code(String global_code) {
		this.global_code = global_code;
	}
	
}
