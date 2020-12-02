package Excepciones;

public class fechaEsperadaException extends Exception {
	public fechaEsperadaException() {
		System.out.println("** LA FECHA DE ENTREGA ESPERADA ES SUPERIOR A 3 DIAS **");
	}

}
