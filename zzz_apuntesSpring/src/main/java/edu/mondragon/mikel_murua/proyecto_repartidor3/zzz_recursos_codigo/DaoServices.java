package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_recursos_codigo;

public interface DaoServices<T> {

	public Long numero_de_elementos_en_database();
	public T buscarPorID(Long id);
	public void registrarEnDatabase(T objeto);
	public void actualizar(T objeto);
	public void borrarElemento(Long id);

}
