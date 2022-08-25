package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;

public class ViewControllerFinanceiro implements Initializable{
	
	@FXML
	private MenuItem mnuPapeis;
	@FXML
	public void onMnuPapeisAction() {
		Alerts.showAlert("Papéis", null, "Cadastro de Papéis", AlertType.WARNING);
	}
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//Constraints.setFieldEmail(null);
	}

}
