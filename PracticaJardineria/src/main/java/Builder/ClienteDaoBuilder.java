package Builder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.ClienteDao;
import Dao.Dao;
import Excepciones.DuplicityException;
import Excepciones.EmailException;
import Excepciones.IdException;
import Excepciones.SurnamePhoneException;
import Excepciones.dniException;
import Excepciones.nieException;
import Model.Cliente;
import Model.tipoDocumento;

public class ClienteDaoBuilder {
	static List<Cliente> clientes;

	public ClienteDaoBuilder(List<Cliente> clientes) {
		ClienteDaoBuilder.clientes = clientes;
	}

	public static Cliente build(int id, String nombreCliente, String apellidoCliente, String telefono, String ciudad,
			String codigoPostal, String email, String contraseña, String documento, tipoDocumento tipoDocumento)
			throws IdException, DuplicityException, SurnamePhoneException, EmailException, dniException, nieException {

		ClienteDao clientedao = new ClienteDao(clientes);
		comprobarIdPositivo(id);
		comprobarDuplicidadId(id, clientes);
		comprobarSurnamePhone(clientes, nombreCliente, apellidoCliente, telefono);
		comprobarEmail(email);
		comprobarDNI(tipoDocumento, documento);
		comprobarNIE(tipoDocumento, documento);
		return new Cliente(id, nombreCliente, apellidoCliente, telefono, ciudad, codigoPostal, email, contraseña,
				documento, tipoDocumento);

	}

	public static void comprobarEmail(String email) throws EmailException {
		Pattern p = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email);
		if (m.find() == false) {
			throw new EmailException();
		} else
			System.out.println("EMAIL CORRECTO");

	}

	public static void comprobarIdPositivo(int id) throws IdException {
		if (id < 0) {// Si el id introducido al crear nuestro cliente es menor que 0 salta nuestra
			// excepcion
			throw new IdException();
		}
	}

	public static void comprobarDuplicidadId(Integer id, List clientes) throws DuplicityException {
		List<Cliente>cli=clientes;
		if (clientes == null) {
			return;
		}
		for (Cliente c : cli) {// Recorremos nuestra lista de la bbdd
			if (c.id == id) {// Si el id de uno de los clientes es igual al que nos entan introduciendo
									// (duplicidad)
				throw new DuplicityException();
			} else
				System.out.println("** ID INTRODUCIDO CORRECTAMENTE **");
		}
	}

	public static void comprobarSurnamePhone(List<Cliente> clientes, String nombreCliente, String apellidoCliente,
			String telefono) throws SurnamePhoneException {
		if (clientes == null) {
			return;
		}
		for (Cliente c : clientes) {// Para ello recorremos nuestra lista
			if (c.getNombreCliente() == nombreCliente && c.getApellidoCliente() == apellidoCliente
					&& c.getTelefono() == telefono) {// Y comprobamos que sean iguales el nombre, apellido y tf
				throw new SurnamePhoneException();
			} else
				System.out.println("** DATOS INTRODUCIDOS CORRECTAMENTE **");
		}

	}

	public static void comprobarDNI(tipoDocumento tipoDocumento, String documento) throws dniException {
		if (tipoDocumento == tipoDocumento.DNI) {
			int asci = 0;
			if (documento.length() == 9 && Character.isLetter(documento.charAt(8))) {
				for (int i = 0; i < documento.length() - 1; i++) {
					asci = documento.charAt(i);
					if (asci > 47 && asci < 58) {

					} else {
						throw new dniException();
					}
				}
			}
		}
	}

	public static void comprobarNIE(tipoDocumento tipoDocumento, String documento) throws nieException {
		if (tipoDocumento == tipoDocumento.NIE) {
			int asci = 0;
			if (documento.length() == 9 && Character.isLetter(documento.charAt(8))
					&& Character.isLetter(documento.charAt(0))) {
				for (int i = 1; i < documento.length() - 1; i++) {
					if (asci > 47 && asci < 58) {
					} else {
						throw new nieException();
					}
				}

			}
		}
	}

}
