package br.unifor.poo.view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("PrincipalView.fxml"));
			Scene cenario = new Scene(janela, 400, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			primaryStage.setScene(cenario);
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Main.launch(args);
	}
}
