package GuiFX;

import java.util.ArrayList;
import java.util.List;

import Builder.ClienteDaoBuilder;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Model.Cliente;
import Model.Pedido;
import Model.tipoDocumento;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
			
			   Scene scene = new Scene(root);
	           stage.setScene(scene);
	           stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
