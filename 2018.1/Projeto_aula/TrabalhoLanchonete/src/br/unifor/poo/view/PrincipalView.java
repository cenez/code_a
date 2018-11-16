package br.unifor.poo.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrincipalView {
	public void fecharClick(ActionEvent event){
		System.exit(0);
	}
	public void bebidaClick(ActionEvent event){
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("BebidaView.fxml"));
			Scene cenario = new Scene(janela, 380, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
