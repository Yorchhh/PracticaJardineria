package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Builder.ClienteDaoBuilder;
import Dao.ClienteDao;
import Excepciones.DuplicityException;
import Excepciones.EmailException;
import Excepciones.IdException;
import Excepciones.SurnamePhoneException;
import Excepciones.dniException;
import Excepciones.nieException;
import Model.Cliente;
import Model.tipoDocumento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClienteController {
	@FXML
	TextField textId, textNombre, textApellido, textTlf, textCiudad, textCodPost, textEmail, textPass, textDocumento;
	@FXML
	RadioButton dni, nie;
	@FXML
	Button crearBtn;

	static List<Cliente> clientes = new ArrayList<Cliente>();
	static ClienteDao clienteDao = new ClienteDao(clientes);
	Cliente c2;

	
	public Cliente crearCliente()
			throws IdException, DuplicityException, SurnamePhoneException, EmailException, dniException, nieException {
		c2 = new Cliente(1, "Jaime", "Martinez", "685147596", "Barcelona", "500047", "martinez@emial.com", "martinez",
				"589654752F", tipoDocumento.DNI);
		clienteDao.guardar(c2);
		int id = Integer.parseInt(textId.getText());
		String nombre = textNombre.getText();
		String ape = textApellido.getText();
		String tlf = textTlf.getText();
		String city = textCiudad.getText();
		String codPost = textCodPost.getText();
		String email = textEmail.getText();
		String documento = textDocumento.getText();
		String pass = textPass.getText();
		tipoDocumento t = dni.isSelected() ? tipoDocumento.DNI : tipoDocumento.NIE;
		Cliente c = ClienteDaoBuilder.build(id, nombre, ape, tlf, city, codPost, email, pass, documento, t);
		clienteDao.guardar(c);
		return c;

	}
	
	
	@FXML
	public void crearCli(ActionEvent actionEvent) {
		Cliente c=null;
		try {
			c = crearCliente();
			
		} catch (IdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SurnamePhoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (dniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (nieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clienteDao.guardar(c);
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(" MENSAJE ");
		alert.setContentText("CLIENTE AÑADIDO CORRECTAMENTE");
		alert.showAndWait();
	}

	

	public void closeWindowsCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
			Parent root = loader.load();
			MenuController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.closeWindowsMenu());
			Stage mystage = (Stage) this.crearBtn.getScene().getWindow();
			mystage.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
