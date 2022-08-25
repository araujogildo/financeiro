package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ViewFinanceiro.fxml"));
			Parent parent = loader.load();
			Scene mainScene  = new Scene(parent, 700, 400);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Java - Controle Financeiro");
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
