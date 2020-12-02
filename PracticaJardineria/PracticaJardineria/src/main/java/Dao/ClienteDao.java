package Dao;

import java.util.*;

import Model.Cliente;

public class ClienteDao implements Dao<Cliente> {
	List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteDao(List<Cliente> clientes) {
		super();
		this.clientes = clientes;// Nuestro coonstructo
	}

	@Override
	public List<Cliente> listar() {
		return clientes;// Va a retornar la lista de clientes
	}

	@Override
	public void guardar(Cliente t) {
		clientes.add(t);// El cliente que le pasamos, sera añadido a nuestra lista
	}

	@Override
	public void actualizar(int id, Cliente t) {
		Cliente cNew = null;// Apuntamos con un nuevo cliente vacio
		for (Cliente cliente : clientes) {// Recorremos nuestra lista cliente
			if (id == cliente.getId()) {// Si el id que le pasamos coincide con el id de un cliente de nuestra lista
				cNew = cliente;// Se almacenara en nuestro cliente anteriormente vacio
				break;
			} // finalizamos bruscamente el for para que deje de buscar cuadno se de la
				// primera coincidencia
			if (cNew == null) {
				System.out.println("** NO SE HA ENCONTRADO COINCIDENCIA **");
			} else {
				clientes.set(clientes.indexOf(cNew), t);
			}
		}
	}

	@Override
	public void eliminar(Cliente t) {
		clientes.remove(t);
	}

	@Override
	public Cliente obtenerPorId(int id) {
		return  clientes.get(id);
	}
	
	

}
