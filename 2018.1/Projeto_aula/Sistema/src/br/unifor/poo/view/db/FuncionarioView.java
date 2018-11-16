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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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
	@FXML
	protected Button btnNew;
	@FXML
	protected GridPane grid_pane;
	@FXML
	protected ComboBox<Departamento> comboBox;

	protected TableViewPOO<Funcionario> tableView;
	protected DAO<Departamento, Long> daoDp;
	protected DAO<Funcionario, Long> dao;
	
	public FuncionarioView() { }
	@FXML
	public void initialize() {
		daoDp = new DAO<>(ConnectionFactory.currentManager(), Departamento.class);
		dao = new DAO<>(ConnectionFactory.currentManager(), Funcionario.class);
		tabelaConfig();
		textFieldMatricula.getStyleClass().add("desabilitado");
		textFieldMatricula.setDisable(true);
	}
	public void tabelaConfig() {
		tableView = new TableViewPOO<>(Funcionario.class, "id","nome","atribuicao","departamento");
		grid_pane.getChildren().add(tableView);
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
			    if (event.getClickCount() == 2) {
			    	Funcionario funcionario = tableView.getSelectionModel().getSelectedItem();
			    	setFunc(funcionario);
			    }
			}
		});
		updateTableView();		
	}
	private void setFunc(Funcionario funcionario) {
		textFieldMatricula.setText(""+funcionario.getId());
        textFieldNome.setText(funcionario.getNome());
        textFieldAtribuicao.setText(funcionario.getAtribuicao());
        comboBox.getSelectionModel().select(funcionario.getDepartamento());
        tableView.getSelectionModel().select(funcionario);
	}
	public Funcionario getFuncionario() {
		Long id=-1l;
		Departamento dpto = null;
		try {
			id = Long.parseLong(textFieldMatricula.getText());
		}catch(Exception e) { System.out.println("Erro: matricula/depto!"); id = -1l; }
		dpto = daoDp.load(comboBox.getSelectionModel().getSelectedItem().getId());

		Funcionario funcionario = null;
		if(id>=0) funcionario = dao.load(id);
		
		if(funcionario==null)
			funcionario = new Funcionario();
		
		funcionario.setNome(textFieldNome.getText());
		funcionario.setAtribuicao(textFieldAtribuicao.getText());
		funcionario.setDepartamento(dpto);

		return funcionario;
	}
	@FXML
	public void btnAddClick(ActionEvent event) {
		Funcionario f = null;
		if(comboBox.getSelectionModel().getSelectedItem()!=null) {
			f = getFuncionario();
			dao.save(f);
			updateTableView();
			textFieldMatricula.setText(f.getId()+"");
		}else {
			JOptionPane.showMessageDialog(null, "Informar Depto");
		}
		if(f!=null) setFunc(f);
	}
	@FXML
	public void btnNewClick(ActionEvent event) {
		textFieldMatricula.setText("");
		btnAddClick(event);
	}
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		if(!textFieldMatricula.getText().equals("")) {
			Funcionario f = dao.load(Long.parseLong(textFieldMatricula.getText()));
			Departamento d = f.getDepartamento();
			d.remove(f);
			dao.delete(f);
			daoDp.save(d);
			updateTableView();
			textFieldMatricula.setText("");
		} else JOptionPane.showMessageDialog(null, "Codigo nulo!");
	}
	public void updateTableView() {
		ObservableList<Funcionario> observer_func = getFuncionarios();
		tableView.getItems().clear();
		if(observer_func.size()>0) tableView.getItems().addAll(observer_func);
		else textFieldMatricula.setText("");
		
		ObservableList<Departamento> observer_dptos = getDepartamentos();
		if(observer_dptos.size()>0) comboBox.setItems(observer_dptos);
		
		if(observer_func.size()>0) {
			tableView.getSelectionModel().select(observer_func.get(0));
			comboBox.getSelectionModel().select(observer_func.get(0).getDepartamento());
		}
	}
	public ObservableList<Funcionario> getFuncionarios(){
		List<Funcionario> funcionarios = dao.list();
		ObservableList<Funcionario> lista = FXCollections.observableArrayList();
		for (Funcionario f: funcionarios)
			lista.add(f);
		return lista;
	}
	public ObservableList<Departamento> getDepartamentos(){
		List<Departamento> departamentos = daoDp.list();
		ObservableList<Departamento> lista = FXCollections.observableArrayList();
		for (Departamento depto: departamentos)
			lista.add(depto);
		
		return lista;
	}
}

















