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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FuncionarioView {
	//Botoes e textFields
	@FXML
	protected TextField textFieldMatricula;
	@FXML
	protected TextField textFieldNome;
	@FXML
	protected TextField textFieldAtribuicao;
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnRemove;

	//Tabela Funcionario
	@FXML
	protected TableView<Funcionario> tableView;
	protected TableColumn<Funcionario, Long> tableColumnFuncionarioMaticula;
	protected TableColumn<Funcionario, String> tableColumnFuncionarioNome;
	protected TableColumn<Funcionario, String> tableColumnFuncionarioAtribuicao;
	protected TableColumn<Funcionario, Departamento> tableColumnFuncionarioDepartamento;
	
	@FXML
	protected ComboBox<Departamento> comboBox;
	
	//Controle de XML
	protected ControladorXml controll;
	protected List<Funcionario> funcionarios;
	protected List<Departamento> departamentos;

	public FuncionarioView() {
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
		Funcionario beb = getFuncionario();
		if(beb!=null) {
			if(!funcionarios.contains(beb)) {
				funcionarios.add(beb);
				controll.salvaFuncDepto();
				updateTableView();
			}
		}
	}
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		Funcionario funcionario = getFuncionario();
		if(funcionarios.contains(funcionario)) {
			Departamento dpto = funcionario.getDepartamento();
			if(dpto!=null) 
				dpto.remove(funcionario);
			funcionarios.remove(funcionario);
			controll.salvaFuncDepto();
			this.updateTableView();
		}
	}
	public Funcionario getFuncionario() {
		Long id=0l;
		String nome = textFieldNome.getText();
		String atribuicao = textFieldAtribuicao.getText();
		Departamento dpto = null;
		try {
			id = Long.parseLong(textFieldMatricula.getText());
			dpto = (comboBox.getSelectionModel().getSelectedItem());
		}catch(Exception e) { JOptionPane.showMessageDialog(null, "Erro: matricula null!"); return null; }
		Funcionario f = new Funcionario(id, nome, atribuicao);
		f.setDepartamento(dpto);
		return f;
	}
	public void preparaTableView() {
		tableColumnFuncionarioMaticula = new TableColumn<Funcionario, Long>("Id");
		tableColumnFuncionarioMaticula.setMinWidth(50);
		tableColumnFuncionarioMaticula.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		tableColumnFuncionarioNome = new TableColumn<Funcionario, String>("Nome"); 
		tableColumnFuncionarioNome.setMinWidth(200);
		tableColumnFuncionarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		tableColumnFuncionarioAtribuicao = new TableColumn<Funcionario, String>("Atribuicao");
		tableColumnFuncionarioAtribuicao.setMinWidth(200);
		tableColumnFuncionarioAtribuicao.setCellValueFactory(new PropertyValueFactory<>("atribuicao"));
		
		tableColumnFuncionarioDepartamento = new TableColumn<Funcionario, Departamento>("Depto");
		tableColumnFuncionarioDepartamento.setMinWidth(200);
		tableColumnFuncionarioDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
		
		tableView.getColumns().addAll(tableColumnFuncionarioMaticula, tableColumnFuncionarioNome, tableColumnFuncionarioAtribuicao, tableColumnFuncionarioDepartamento);
	}
	@FXML
	public void tableViewClick(MouseEvent event){
	    if (event.getClickCount() == 2) {
	    	Funcionario funcionario = tableView.getSelectionModel().getSelectedItem();
	    	textFieldMatricula.setText(""+funcionario.getId());
	        textFieldNome.setText(funcionario.getNome());
	        textFieldAtribuicao.setText(funcionario.getAtribuicao());
	        comboBox.getSelectionModel().select(funcionario.getDepartamento());
	    }
	}
	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getFuncionarios());
		comboBox.setItems(getDepartamentos());
		
	}
	public ObservableList<Funcionario> getFuncionarios(){
		ObservableList<Funcionario> lista = FXCollections.observableArrayList();
		for (Funcionario funcionario : funcionarios)
			lista.add(funcionario);
		return lista;
	}
	public ObservableList<Departamento> getDepartamentos(){
		if(departamentos.size()==0) {
			for (Funcionario f : funcionarios) {
				if(!departamentos.contains(f.getDepartamento()))
					departamentos.add(f.getDepartamento());
			}
		}
		ObservableList<Departamento> lista = FXCollections.observableArrayList();
		for (Departamento departamento : departamentos)
			lista.add(departamento);
		return lista;
	}
}
