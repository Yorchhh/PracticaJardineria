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
	List<Cliente> clientes;
	public ClienteDaoBuilder(List<Cliente> clientes){
		this.clientes=clientes;
	}

	public Cliente build(Integer id, String nombreCliente, String apellidoCliente, String telefono,
			String ciudad, String codigoPostal, String email, String contraseña, String documento,
			tipoDocumento tipoDocumento)
			throws IdException, DuplicityException, SurnamePhoneException, EmailException, dniException, nieException {
			
		comprobarIdPositivo(id);
		comprobarDuplicidadId(clientes, id);
		comprobarSurnamePhone(clientes, nombreCliente, apellidoCliente, telefono);
		comprobarEmail(email);
		comprobarDNI(tipoDocumento, documento);
		comprobarNIE(tipoDocumento, documento);
		return new Cliente(id, nombreCliente, apellidoCliente, telefono, ciudad, codigoPostal, email, contraseña,
				documento, tipoDocumento);
		
	}
	
	
	public static void comprobarEmail(String email) throws EmailException {
			Pattern p = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
			Matcher m = p.matcher(email);
		if(m.find()==false) {
			throw new EmailException();
		}else System.out.println("EMAIL CORRECTO");
		
	}
	
	public static void comprobarIdPositivo(int id) throws IdException {
		if (id < 0) {// Si el id introducido al crear nuestro cliente es menor que 0 salta nuestra
			// excepcion
			throw new IdException();
			}
		}
	
	public static void comprobarDuplicidadId(List<Cliente> clientes, Integer id) throws DuplicityException {
		for (Cliente c : clientes) {// Recorremos nuestra lista de la bbdd
			if (c.getId() == id) {// Si el id de uno de los clientes es igual al que nos entan introduciendo
									// (duplicidad)
				throw new DuplicityException();
			} else
				System.out.println("** ID INTRODUCIDO CORRECTAMENTE **");
		}
		
	}
	
	public static void comprobarSurnamePhone(List<Cliente> clientes, String nombreCliente, String apellidoCliente, String telefono) 
			throws SurnamePhoneException {
		for (Cliente c : clientes) {// Para ello recorremos nuestra lista
			if (c.getNombreCliente() == nombreCliente && c.getApellidoCliente() == apellidoCliente
					&& c.getTelefono() == telefono) {// Y comprobamos que sean iguales el nombre, apellido y tf
				throw new SurnamePhoneException();
			} else
				System.out.println("** DATOS INTRODUCIDOS CORRECTAMENTE **");
		}
		
	}
	
	public static void comprobarDNI(tipoDocumento tipoDocumento, String documento) throws dniException
			 {
		if(tipoDocumento==tipoDocumento.DNI) {
			if(documento.matches("^[0-9]{8}[A-Z]$")){
				}else throw new dniException();	
			}
		}

	
	public static void comprobarNIE(tipoDocumento tipoDocumento, String documento) throws nieException  {
		 if(tipoDocumento==tipoDocumento.NIE){
				if(documento.matches("^[A-Z][0-9]{7}[A-Z]$")) {
					
				}else throw new nieException();
		
		 }
		}
	

}
	
	
		
	
	
	
		
	

