package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.PapelService;

public class ViewControllerFinanceiro implements Initializable {

	@FXML
	private MenuItem mnuCadPapeis;
	@FXML
	private MenuItem mnuCadCarteira;
	@FXML
	private MenuItem mnuCadRecbtos;
	@FXML
	private MenuItem mnuCadCotacaoPapeisDia;
	@FXML
	private MenuItem mnuConsCarteira;
	@FXML
	private MenuItem mnuConsRecbtos;
	@FXML
	private MenuItem mnuAjudaSobre;
	@FXML
	private MenuItem mnuSair;

	@FXML
	public void onMnuCadPapeisAction() {
		loadView("/gui/PapelList.fxml", (PapelListController controller) -> {
			controller.setPapelService(new PapelService());
			controller.updateTableView();
		});
	}

	@FXML
	public void onMnuCadCarteiraAction() {
		Alerts.showAlert("Papéis", null, "Cadastro da Carteira", AlertType.WARNING);
	}
	
	@FXML
	public void onMnuCadRecbtosAction() {
		Alerts.showAlert("Papéis", null, "Cadastro de Recebimentos", AlertType.WARNING);
	}

	@FXML
	public void onMnuCadCotacaoPapeisDiaAction() {
		Alerts.showAlert("Papéis", null, "Cadastro Cotação de Papéis no Dia", AlertType.WARNING);
	}

	@FXML
	public void onMnuConsCarteiraAction() {
		Alerts.showAlert("Consulta", null, "Consulta Carteira", AlertType.WARNING);
	}

	@FXML
	public void onMnuConsRecbtosAction() {
		Alerts.showAlert("Consulta", null, "Consulta de Recebimentos", AlertType.WARNING);
	}

	@FXML
	public void onMnuAjudaSobre() {
		loadView("/gui/Sobre.fxml", x -> {});
	}
	
	@FXML
	public void onMnuSair(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// Constraints.setFieldEmail(null);
	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			// carrega a janela "Sobre.fxml"
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			// mostrar a janela "Sobre.fxml" dentro da janela principal
			
			// 1- Obtem a janela principal
			Scene mainScene = Main.getMainScene();
			VBox mainVBox =   (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			// limpar todos os filhos de VBox
			mainVBox.getChildren().clear();
			
			mainVBox.getChildren().add(mainMenu);
			// adicionar os filhos do VBox da janela "Sobre"
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			// executa a função passada como parâmetro
			T controller = loader.getController();
			initializingAction.accept(controller); 
				
		}catch(IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
		}
	}

}
