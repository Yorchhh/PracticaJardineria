package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import Model.Pedido;

public class PedidoDao implements Dao<Pedido>{
	List<Pedido>pedidos = new ArrayList<Pedido>();

	

	public PedidoDao(List<Pedido> pedidos) {
		super();
		this.pedidos = pedidos;
	}

	@Override
	public List<Pedido> listar() {
		return pedidos;
	}

	@Override
	public void guardar(Pedido t) {
		pedidos.add(t);
		
	}

	@Override
	public void actualizar(int id, Pedido t) {
		Pedido pNew= null;
		for (Pedido pedido : pedidos) {
			if(id==pedido.getCodigoCliente()) {
				pNew=pedido;
				break;
			}
			if(pNew==null) {
				System.out.println("** NO SE HA ENCONTRADO COINCIDENCIA **");
			}else {
				pedidos.set(pedidos.indexOf(pNew), t);
			}
		}
		
	}

	@Override
	public void eliminar(Pedido t) {
		pedidos.remove(t);
		
	}

	@Override
	public Pedido obtenerPorId(int id) {
		return pedidos.get(id);
	}

	
	

}
