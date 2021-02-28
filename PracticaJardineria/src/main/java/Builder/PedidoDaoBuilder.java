package Builder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Excepciones.codigoPedidoDuplicityException;
import Excepciones.codigoPedidoException;
import Excepciones.fechaEsperadaException;
import Excepciones.fechaException;
import Excepciones.idClientePedidoException;
import Model.Cliente;
import Model.Pedido;

public class PedidoDaoBuilder {
	static List<Pedido> pedidos;
	static List<Cliente> clientes;
	public PedidoDaoBuilder(List<Pedido> pedidos, List<Cliente>	clientes) {
		super();
		PedidoDaoBuilder.pedidos = pedidos;
		PedidoDaoBuilder.clientes=clientes;
	}
	
	
	public static Pedido build(Integer codigoPedido, Date fechaPedido,
			Date fechaEntrega, Integer id, Date fechaEsperada) throws fechaException, fechaEsperadaException, codigoPedidoException,
	codigoPedidoDuplicityException, idClientePedidoException {

		LocalDate ahora = LocalDate.now();
		Date hoy = Date.from(ahora.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		
		comprobarFecha(hoy, fechaPedido);//check
//		comprobarFechaEsperada(hoy, fechaEsperada);
		comprobarCodigoPedido(pedidos, codigoPedido);
//		comprobarDuplicidadcodigoPedido(pedidos, codigoPedido);
//		comprobarClienteIdPedido(id, clientes);
	
		return new Pedido(codigoPedido,fechaPedido,fechaEntrega,id,fechaEsperada);
		
	}
	public static void comprobarFecha(Date fechaHoy, Date fechaPedido) throws fechaException {
		boolean igual= false;
		if(fechaHoy.equals(fechaPedido)) {
			igual=true;
			System.out.println("** La fecha corresponde al dia de hoy, CORRECTO **");
		}else {
			igual=false;
			throw new fechaException();
		}
	}
	
	
	
	public static void comprobarFechaEsperada(Calendar calendario, Date fechaEsperada) 
			throws fechaEsperadaException {
		calendario.add(Calendar.DATE, +3);
		if (!fechaEsperada.after(calendario.getTime())) {
			throw new fechaEsperadaException();
		}else System.out.println("** La fecha de entrega esperada es de 3 dias o inferior **");
	}
	
	public static void comprobarCodigoPedido(List<Pedido> pedidos, Integer codigoPedido) 
			throws codigoPedidoException {
		
		if(codigoPedido<0) {
			throw new codigoPedidoException();
		}
	}
	
	public static void comprobarDuplicidadcodigoPedido(List<Pedido> pedidos, Integer codigoPedido) 
			throws codigoPedidoDuplicityException {
		for (Pedido p : pedidos) {
			if(p.getCodigoPedido()==codigoPedido) {
				throw new codigoPedidoDuplicityException();
			}
		}
	}
	
	public static void comprobarClienteIdPedido(Integer id,List<Cliente> clientes) 
			throws idClientePedidoException {
		boolean encontrado=false;
		for (Cliente c : clientes) {
			if(c.getId()==id) {
				encontrado=true;
				break;
				}
			}
		if(!encontrado) {
			throw new idClientePedidoException();
			
		}
	}
	
	
			
}
		
	


