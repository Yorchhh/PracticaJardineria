package Dao;

import java.util.List;

public interface Dao<T> {

	List<T> listar();

	void guardar(T t);

	void actualizar(int id, T t);

	void eliminar(T t);
	
	public T obtenerPorId(int id);

}
