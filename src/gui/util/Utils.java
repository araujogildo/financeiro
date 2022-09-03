package gui.util;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class Utils {
	
	public static Stage currentStage(ActionEvent event) {
		//retorna o Stage da janela que foi acionado um evento
		return (Stage) ((Node)event.getSource()).getScene().getWindow();
	}
	
	public static Integer tryParseToInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(NumberFormatException e) {
			return null;
		}
	}
}
