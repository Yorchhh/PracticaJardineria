package App;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Builder.ClienteDaoBuilder;
import Builder.PedidoDaoBuilder;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Excepciones.DuplicityException;
import Excepciones.EmailException;
import Excepciones.IdException;
import Excepciones.SurnamePhoneException;
import Excepciones.codigoPedidoDuplicityException;
import Excepciones.codigoPedidoException;
import Excepciones.dniException;
import Excepciones.fechaEsperadaException;
import Excepciones.fechaException;
import Excepciones.idClientePedidoException;
import Excepciones.nieException;
import Model.Cliente;
import Model.Pedido;
import Model.tipoDocumento;

class App {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static ClienteDao clienteDao = new ClienteDao(clientes);
	static List<Pedido> pedidos = new ArrayList<Pedido>();
	static PedidoDao pedidoDao = new PedidoDao(pedidos);

	public static void main( String[] args ) throws IdException, DuplicityException, SurnamePhoneException,
	EmailException, fechaException, fechaEsperadaException, codigoPedidoException, codigoPedidoDuplicityException, 
	idClientePedidoException, dniException, nieException{
    	
    	Scanner kb = new Scanner(System.in);
    	ClienteDaoBuilder cdb = new ClienteDaoBuilder(clientes);
    	System.out.println("CREAR CLIENTES");
    	Cliente c1 = cdb.build(1, "Jorge", "Martinez", "68616676",null, null, "jmaritnez@gmail.com", null, "73017762N", tipoDocumento.DNI);
    	clienteDao.guardar(c1);
    	Cliente c3 = cdb.build(0, "Jorge", "Martinez", "695897825",null, null, "jmaritnez@gmail.com", null, "73017652N", tipoDocumento.DNI);
    	clienteDao.guardar(c3);
    	Cliente c2 = cdb.build(2, "Jorge", "Martinez", null, null, null, "jmaritnez@gmail.com", null, "A7894561B", tipoDocumento.NIE);
    	clienteDao.guardar(c2);
    	Cliente c4 = cdb.build(3, "Alejandro", "Perez", null, null, null, "aperez@gmail.com", null, "B8745632W", tipoDocumento.NIE);    
    	clienteDao.guardar(c4);
    	
    	
    	
    	clientes=clienteDao.listar();
    	for (Cliente c : clientes) {
			System.out.println(c.toString());
		}
    	
    	PedidoDaoBuilder pdb = new PedidoDaoBuilder(pedidos, clientes);
    	System.out.println("**  AÑADIR PEDIDOS **");
    	//fechaPedido,fechaEntrega, fechaEsperada
    	Pedido p1=pdb.build(1, new Date(120,11,01), new Date(120,11,05), 2, new Date(120,11,2));
    	pedidoDao.guardar(p1);
    	
    	for (Pedido p	: pedidos) {
    		System.out.println(p.toString());
			
		}
    	

    	
    }
}
