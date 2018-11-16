package br.unifor.poo.view.db;

import java.util.List;

import javax.swing.JOptionPane;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.model.dao.DAO;
import br.unifor.poo.util.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DepartamentoView {
	//Botoes e textFields
	@FXML
	protected TextField textFieldCodigo;
	@FXML
	protected TextField textFieldNome;
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnRemove;
	@FXML
	protected Button btnNew;
	@FXML
	protected Button btnFuncionario;
	@FXML
	protected GridPane grid_pane;
	@FXML
	protected ComboBox<Funcionario> comboBox;

	TableViewPOO<Departamento> tableView;
	protected DAO<Departamento, Long> dao;
	
	@FXML
	public void initialize() {
		dao = new DAO<Departamento, Long>(ConnectionFactory.currentManager(), Departamento.class);
		tabelaConfig();
		textFieldCodigo.getStyleClass().add("desabilitado");
		textFieldCodigo.setDisable(true);
	}
	public void tabelaConfig() {
		tableView = new TableViewPOO<>(Departamento.class, "id","nome");
		grid_pane.getChildren().add(tableView);
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
			    if (event.getClickCount() == 2) 
			    	tableComboUpdate();
			}
		});
		updateTableView();		
	}
	private void tableComboUpdate() {
    	Departamento depto = dao.load(tableView.getSelectionModel().getSelectedItem().getId());
    	textFieldCodigo.setText(""+depto.getId());
        textFieldNome.setText(depto.getNome());
        
		comboBox.getItems().clear();
		List<Funcionario> funcs = depto.getFuncionarios();
		if(funcs.size()>0) {
			comboBox.getItems().addAll(getDeptoFuncionarios(funcs));
			comboBox.getSelectionModel().select(depto.getFuncionarios().get(0));
		}
	}
	public Departamento getDepartamento() {
		Long id=-1l;
		
		try {
			id = Long.parseLong(textFieldCodigo.getText());
		} catch(Exception e) { }

		Departamento depto = null;
		if(id>=0) depto = dao.load(id);
		if(depto==null)
			depto = new Departamento();
		
		if(id>=0) depto.setId(id);
		depto.setNome(textFieldNome.getText());
		return depto;
	}
	@FXML
	public void btnAddClick(ActionEvent event) {
		Departamento depto = getDepartamento();
		dao.save(depto);
		updateTableView();
		textFieldCodigo.setText(depto.getId()+"");
	}
	@FXML
	public void btnNewClick(ActionEvent event) {
		textFieldCodigo.setText("");
		btnAddClick(event);
	}
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		if(!textFieldCodigo.getText().equals("")) {
			Departamento depto = getDepartamento();
			dao.delete(depto);
			updateTableView();
			textFieldCodigo.setText("");
		}else JOptionPane.showMessageDialog(null, "Codigo nullo!");
	}
	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getDepartamentos());
	}
	public ObservableList<Departamento> getDepartamentos(){
		List<Departamento> departamentos = dao.list();
		ObservableList<Departamento> lista = FXCollections.observableArrayList();
		for (Departamento depto: departamentos)
			lista.add(depto);
		return lista;
	}
	public ObservableList<Funcionario> getDeptoFuncionarios(List<Funcionario> listaFunc){
		ObservableList<Funcionario> lista = FXCollections.observableArrayList();
		for (Funcionario f: listaFunc)
			lista.add(f);
		return lista;
	}
	@FXML
	public void btnFuncionarioClick(ActionEvent event) {
		Departamento depto = tableView.getSelectionModel().getSelectedItem();
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
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if(depto!=null) {
			tableView.getSelectionModel().select(depto);
			tableComboUpdate();
		}
	}
}
