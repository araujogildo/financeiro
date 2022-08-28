package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Papel;
import model.services.PapelService;

public class PapelListController implements Initializable{
	
	private PapelService service;
	
	@FXML
	private TableView<Papel> tableViewPapel;
	
	@FXML
	private TableColumn<Papel, String> tableColumnPapel;
	@FXML
	private TableColumn<Papel, String> tableColumnDescricao;
	@FXML
	private TableColumn<Papel, String> tableColumnRamo;

	@FXML
	private Button btnAdicionar;
	
	private ObservableList<Papel> obsList;
	
	@FXML
	public void onBtnAdicionarAction() {
		System.out.println("onBtnAdicionarAction()");
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
		tableColumnRamo.setCellValueFactory(new PropertyValueFactory<>("tx_Ramo"));
		
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

}
