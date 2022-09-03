package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ViewFinanceiro.fxml"));
			ScrollPane scrollPane = loader.load();			
			mainScene  = new Scene(scrollPane, 708, 400);
			
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("JavaFx - Controle Financeiro");
			primaryStage.show();
			
			/*
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,900,550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Controle Financeiro");
			primaryStage.show();
			*/
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
