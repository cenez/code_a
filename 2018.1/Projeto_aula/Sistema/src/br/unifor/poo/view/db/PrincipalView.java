package br.unifor.poo.view.db;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrincipalView {
	
	@FXML
	public void menuItemFecharClick(ActionEvent event) {
		System.exit(0);
	}
	@FXML
	public void menuItemFuncionariosClick(ActionEvent event) {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("FuncionarioView.fxml"));
			Scene cenario = new Scene(janela, 800, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Cadastro de Funcionarios");
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void menuItemDepartamentosClick(ActionEvent event) {
		Stage modal = new Stage();
		modal.initOwner(new Stage());
		modal.initModality(Modality.APPLICATION_MODAL);
		try {
			BorderPane janela = (BorderPane) FXMLLoader.load(getClass().getResource("DepartamentoView.fxml"));
			Scene cenario = new Scene(janela, 800, 400);
			cenario.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
			modal.setScene(cenario);
			modal.setTitle("Cadastro de Departamentos");
			modal.setMaximized(true);
			modal.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
