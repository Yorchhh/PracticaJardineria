package Excepciones;

public class idClientePedidoException extends Exception {
	public idClientePedidoException() {
		System.out.println("** EL ID CLIENTE NO COINCIDE CON SU PEDIDO **");
	}

}
