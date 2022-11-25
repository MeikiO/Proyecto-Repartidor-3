package clases_para_parsear_respuesta;
import java.util.List;

public class TransCripcionJson {
	List<ResultadosApi> results;
	String status;
	public TransCripcionJson(List<ResultadosApi> results, String status) {
		super();
		this.results = results;
		this.status = status;
	}
	public List<ResultadosApi> getResults() {
		return results;
	}
	public void setResults(List<ResultadosApi> results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransCripcionJson [results=" + results + ", status=" + status + ", getResults()=" + getResults()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
