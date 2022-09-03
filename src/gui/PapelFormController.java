package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Papel;
import model.services.PapelService;

public class PapelFormController implements Initializable {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
	
	//dependencia para a classe Papel
	private Papel entity; //entity - para generalizar
	private PapelService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	@FXML
	private TextField txtIdPapel; 
	@FXML
	private TextField txtPapel; 
	@FXML
	private TextField txtDescricao; 
	@FXML
	private TextField txtRamoNegocio; 
	
	@FXML
	private Label lblErrName;
	@FXML
	private Label lblErrDescricao;
	@FXML
	private Label lblErrRamoNegocio;
	
	@FXML
	private Button btnSalvar; 
	@FXML
	private Button btnCancelar; 

	public void setPapel(Papel entity) {
		this.entity = entity;
	}
	
	public void setPapelService(PapelService service) {
		this.service = service;
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	@FXML
	public void onBtnSalvarAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			
			notifyDataChangeListeners();
			
			Utils.currentStage(event).close();
		}catch(DbException e) {
			Alerts.showAlert("error saving object", null, e.getMessage(), AlertType.ERROR);
		}
		Utils.currentStage(event).close();
	}
	
	//subject
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}

	private Papel getFormData() {
		Papel obj = new Papel();
		
		Integer idPapel = 0;
		//alterar: associar ao usuário logado
		Integer idResp = 1368;
		Date dtCadastro = new Date();
		
		
		if(!txtIdPapel.getText().isEmpty() &&  txtIdPapel.getText() != "") {
			idPapel = Integer.parseInt(txtIdPapel.getText());
		}
		
		obj.setId_Papel(idPapel);
		obj.setTx_Papel(txtPapel.getText());
		obj.setTx_Descricao(txtDescricao.getText());
		obj.setTx_RamoNegocios(txtRamoNegocio.getText());
		obj.setId_Resp(idResp);
		obj.setDt_Cadastro(sdf.format(dtCadastro));
		return obj;
	}

	@FXML
	public void onBtnCancelarAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldMaxLength(txtPapel, 5);
		Constraints.setTextFieldMaxLength(txtDescricao, 30);
		Constraints.setTextFieldMaxLength(txtRamoNegocio, 50);
		
		Constraints.setTextFieldUCase(txtPapel);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtPapel.setText(entity.getTx_Papel());
		txtDescricao.setText(entity.getTx_Descricao());
		txtRamoNegocio.setText(entity.getTx_RamoNegocios());
	}

}
