package br.unifor.poo.view.xml;

import java.util.List;

import javax.swing.JOptionPane;

import br.unifor.poo.controller.ControladorXml;
import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
	protected Button btnFuncionario;

	//Tabela Departamento
	@FXML
	protected TableView<Departamento> tableView;
	protected TableColumn<Departamento, Long> tableColumnDeptoCodigo;
	protected TableColumn<Departamento, String> tableColumnDeptoNome;
	
	@FXML
	protected ComboBox<Funcionario> comboBox;
	
	//Controle de XML
	protected ControladorXml controll;
	protected static List<Funcionario> funcionarios;
	protected static List<Departamento> departamentos;

	public DepartamentoView() {
		controll = new ControladorXml();
		funcionarios = controll.getFuncionarios();
		departamentos = controll.getDepartamentos();
	}
	@FXML
	public void initialize() {
		preparaTableView();
		updateTableView();
	}
	@FXML
	public void btnAddClick(ActionEvent event) {
		Departamento depto = getDepartamento();
		if(depto!=null) {
			if(!departamentos.contains(depto)) {
				departamentos.add(depto);
				controll.salvaFuncDepto();
				updateTableView();
			}
		}
	}
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		Departamento depto = getDepartamento();
		if(depto==null) return;
		for (Departamento departamento : departamentos) {
			if(departamento.getId()==depto.getId()) {
				depto = departamento;

				List<Funcionario> l = depto.getFuncionarios();
				while(l.size()>0) {
					Funcionario x = l.get(l.size()-1);
					depto.remove(x);
				}
				departamentos.remove(depto);
				controll.salvaFuncDepto();
				this.updateTableView();
				comboBox.getItems().clear();
				break;
			}
		}
	}
	public Departamento getDepartamento() {
		Long id=0l;
		String nome = textFieldNome.getText();
		try {
			id = Long.parseLong(textFieldCodigo.getText());
		}catch(Exception e) { JOptionPane.showMessageDialog(null, "Erro: codigo null!"); return null; }
		Departamento dpto = new Departamento(id, nome);
		return dpto;
	}
	public void preparaTableView() {
		tableColumnDeptoCodigo = new TableColumn<Departamento, Long>("Id");
		tableColumnDeptoCodigo.setMinWidth(50);
		tableColumnDeptoCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		tableColumnDeptoNome = new TableColumn<Departamento, String>("Nome"); 
		tableColumnDeptoNome.setMinWidth(200);
		tableColumnDeptoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		tableView.getColumns().addAll(tableColumnDeptoCodigo, tableColumnDeptoNome);
	}
	@FXML
	public void tableViewClick(MouseEvent event){
	    if (event.getClickCount() == 2) {
	    	Departamento depto = tableView.getSelectionModel().getSelectedItem();
	    	textFieldCodigo.setText(""+depto.getId());
	        textFieldNome.setText(depto.getNome());
	        
			comboBox.getItems().clear();
			List<Funcionario> funcs = depto.getFuncionarios();
			if(funcs.size()>0) {
				comboBox.getItems().addAll(getDeptoFuncionarios(funcs));
				comboBox.getSelectionModel().select(depto.getFuncionarios().get(0));
			}
	    }
	}
	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getDepartamentos());
	}
	public ObservableList<Departamento> getDepartamentos(){
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
		tableView.getItems().clear();
		tableView.getColumns().clear();
		comboBox.getItems().clear();
		
		funcionarios = controll.getFuncionarios();
		departamentos = controll.getDepartamentos();
		
		this.initialize();
	}
}
