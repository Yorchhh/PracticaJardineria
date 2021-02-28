package Controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.callback.TextOutputCallback;

import Builder.PedidoDaoBuilder;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Excepciones.codigoPedidoDuplicityException;
import Excepciones.codigoPedidoException;
import Excepciones.fechaEsperadaException;
import Excepciones.fechaException;
import Excepciones.idClientePedidoException;
import Model.Cliente;
import Model.Pedido;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PedidoController {
	@FXML
	DatePicker fechaPedido, fechaEntrega, fechaEsperada;
	@FXML
	TextField textCodigoPedido, textIdCliente;
	@FXML
	Button crearPedidoBtn;

	static List<Pedido> pedido = new ArrayList<Pedido>();
	static PedidoDao pedidoDao = new PedidoDao(pedido);
	Pedido p2;

	public Pedido createOrder() throws fechaException, fechaEsperadaException, codigoPedidoException, codigoPedidoDuplicityException, idClientePedidoException {
		p2 = new Pedido(1, new Date(121, 1, 26), new Date(121, 1, 28), 2, new Date(121, 1, 28));
		pedidoDao.guardar(p2);

		int codPedido = Integer.parseInt(textCodigoPedido.getText());
		LocalDate fecha = fechaPedido.getValue();
		Date fechaPedido = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate fecha2= fechaEntrega.getValue();
		Date fechaEntrega= Date.from(fecha2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate fecha3= fechaEsperada.getValue();
		Date fechaEsperada=Date.from(fecha3.atStartOfDay(ZoneId.systemDefault()).toInstant());
		int idCliente=Integer.parseInt(textIdCliente.getText());
		Pedido p = PedidoDaoBuilder.build(codPedido, fechaPedido, fechaEntrega, idCliente, fechaEsperada);
		pedidoDao.guardar(p);
		return p;
	}

	@FXML
	public void crearPedido(ActionEvent actionEvent) {
		Pedido p=null;
		try {
			 p = createOrder();
		} catch (fechaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (fechaEsperadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (codigoPedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (codigoPedidoDuplicityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (idClientePedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pedidoDao.guardar(p);
		
		for (Pedido pe : pedido) {
			System.out.println(pe.toString());
		}
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(" MENSAJE ");
		alert.setContentText("PEDIDO AÑADIDO CORRECTAMENTE");
		alert.showAndWait();

	}

	public void closeWindowsPedido() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
			Parent root = loader.load();
			MenuController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.closeWindowsMenu());
			Stage mystage = (Stage) this.crearPedidoBtn.getScene().getWindow();
			mystage.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
