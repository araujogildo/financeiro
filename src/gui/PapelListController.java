package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Papel;
import model.services.PapelService;

public class PapelListController implements Initializable, DataChangeListener{
	
	private PapelService service;
	
	@FXML
	private TableView<Papel> tableViewPapel;
	
	@FXML
	private TableColumn<Papel, String> tableColumnPapel;
	@FXML
	private TableColumn<Papel, String> tableColumnDescricao;
	@FXML
	private TableColumn<Papel, String> tableColumnRamoNegocios;
	@FXML
	private TableColumn<Papel, String> tableColumnDtCadastro;

	@FXML
	private Button btnAdicionar;
	
	private ObservableList<Papel> obsList;
	
	@FXML
	public void onBtnAdicionarAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Papel obj = new Papel();
		createDialogForm(obj, "/gui/PapelForm.fxml", parentStage);
	}
	
	//injeção de dependência na classe PapelService
	public void setPapelService(PapelService service) {
		this.service = service;
	}
	
	//
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//para inicializar algum node na tela
		initializeNodes();
	}
	
	private void initializeNodes() {
		tableColumnPapel.setCellValueFactory(new PropertyValueFactory<>("tx_Papel"));
		tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("tx_Descricao"));
		tableColumnRamoNegocios.setCellValueFactory(new PropertyValueFactory<>("tx_RamoNegocios"));
		
		tableColumnDtCadastro.setCellValueFactory(new PropertyValueFactory<>("dt_Cadastro"));
		
		//para ajustar o tableview na janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewPapel.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		List<Papel> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewPapel.setItems(obsList);
	}
	
	private void createDialogForm(Papel obj, String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			PapelFormController controller = loader.getController();
			controller.setPapel(obj);
			controller.setPapelService(new PapelService());
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();
			
			//um palco na frente do outro
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Dados do Papel");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		}catch(IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {
		updateTableView();
	}

}
