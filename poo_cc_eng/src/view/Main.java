package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.ConnectionFactory;

/*
 * Exemplo para abertura modal de janelas (em eventos)
@FXML
public void menuItemEntidadesClick(ActionEvent event) {
	Stage modal = new Stage();
	modal.initOwner(new Stage());
	modal.initModality(Modality.APPLICATION_MODAL);
	try {
		BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("EntidadeView.fxml"));
		Scene cenario = new Scene(janela, 800, 400);
		cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
		modal.setScene(cenario);
		modal.setTitle("Cadastro de Entidades");
		modal.showAndWait();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
*/

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("PrincipalView.fxml"));
			Scene cenario = new Scene(janela, 400, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			primaryStage.setScene(cenario);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Sistema 1.0");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Main.launch(args);
		ConnectionFactory.close();
	}
}