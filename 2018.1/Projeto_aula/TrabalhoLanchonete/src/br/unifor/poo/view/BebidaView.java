package br.unifor.poo.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.unifor.poo.controller.ControladorXml;
import br.unifor.poo.model.Bebida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BebidaView {
	@FXML
	protected TextField textFieldNome;
	@FXML
	protected TextField textFieldPreco;
	@FXML
	protected TextField textFieldEstoque;
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnRemove;
	
	//Tabela Bebida
	@FXML
	protected TableView<Bebida> tableView;
	protected TableColumn<Bebida, String> tableColumnDeptoNome;
	protected TableColumn<Bebida, Double> tableColumnPreco;
	protected TableColumn<Bebida, Integer> tableColumnDeptoCodigo;
	
	//Controle de XML
	protected ControladorXml controll;
	protected static List<Bebida> bebidas;
	
	public BebidaView() {
		controll = new ControladorXml();
		bebidas = controll.getBebidas();
	}
	@FXML
	public void initialize() {
		preparaTableView();
		updateTableView();
	}
	@FXML
	public void btnAddClick(ActionEvent event) {
		Bebida bebida = getBebida();
		if(bebida!=null) {
			if(!bebidas.contains(bebida)) {
				bebidas.add(bebida);
				controll.salvaBebida();
				updateTableView();
			}
		}
	}
	@FXML
	public void btnRemoveClick(ActionEvent event) {
		Bebida bebis = getBebida();
		if(bebis==null) return;
		for (Bebida bebida : bebidas) {
			if(bebida.equals(bebis)) {
				bebis = bebida;
				
				bebidas.remove(bebis);
				controll.salvaBebida();
				this.updateTableView();
				break;
			}
		}
	}
	public Bebida getBebida() {
		String nome = textFieldNome.getText();
		double preco;
		int qtd;
		try {
			preco = Double.parseDouble(textFieldPreco.getText());
			qtd = Integer.parseInt(textFieldEstoque.getText());
		}catch(Exception e) { JOptionPane.showMessageDialog(null, "Erro: Preco e/ou Estoque!"); return null; }
		Bebida bebida = new Bebida(nome, preco, qtd);
		return bebida;
	}
	public void preparaTableView() {
		tableColumnDeptoNome = new TableColumn<Bebida, String>("Nome"); 
		tableColumnDeptoNome.setMinWidth(200);
		tableColumnDeptoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		tableColumnPreco = new TableColumn<Bebida, Double>("Preco"); 
		tableColumnPreco.setMinWidth(50);
		tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
		
		tableColumnDeptoCodigo = new TableColumn<Bebida, Integer>("Quantidade");
		tableColumnDeptoCodigo.setMinWidth(50);
		tableColumnDeptoCodigo.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
		
		tableView.getColumns().addAll(tableColumnDeptoNome, tableColumnPreco, tableColumnDeptoCodigo);
	}
	@FXML
	public void tableViewClick(MouseEvent event){
	    if (event.getClickCount() == 2) {
	    	Bebida bebida = tableView.getSelectionModel().getSelectedItem();
	    	textFieldNome.setText(bebida.getNome());
	    	textFieldPreco.setText(bebida.getPreco()+"");
	    	textFieldEstoque.setText(""+bebida.getQtdEstoque());
	        
	    }
	}
	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getBebidas());
	}
	public ObservableList<Bebida> getBebidas(){
		ObservableList<Bebida> lista = FXCollections.observableArrayList();
		for (Bebida bebida: bebidas)
			lista.add(bebida);
		return lista;
	}
}
