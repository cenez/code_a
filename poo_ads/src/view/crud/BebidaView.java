package view.crud;

import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.dao.DAO;
import model.entidade.Bebida;
import model.entidade.Cardapio;
import util.ConnectionFactory;

public class BebidaView {
	// Botoes e textFields
	@FXML
	protected TextField textFieldCodigo;
	@FXML
	protected TextField textFieldNome;
	@FXML
	protected TextField textFieldPreco;
	@FXML
	protected TextField textFieldQtd;
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnRemove;
	@FXML
	protected Button btnNew;
	@FXML
	protected GridPane grid_pane;

	protected TableViewPOO<Bebida> tableView;
	protected DAO<Bebida, Long> dao;

	@FXML
	public void initialize() {
		dao = new DAO<Bebida, Long>(ConnectionFactory.currentManager(), Bebida.class);
		tabelaConfig();
		textFieldCodigo.getStyleClass().add("desabilitado");
		textFieldCodigo.setDisable(true);
	}

	public void tabelaConfig() {
		tableView = new TableViewPOO<>(Bebida.class, "id", "nome", "preco", "qtd");
		grid_pane.getChildren().add(tableView);
		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 1)
					tableEventUpdate();
			}
		});
		updateTableView();
	}

	private void tableEventUpdate() {
		Cardapio bebida = tableView.getSelectionModel().getSelectedItem();
		if(bebida!=null) {
			textFieldCodigo.setText("" + bebida.getId());
			textFieldNome.setText(bebida.getNome());
			textFieldPreco.setText("" + bebida.getPreco());
			textFieldQtd.setText("" + ((Bebida)bebida).getQtd());
		}
	}

	public Bebida getBebida() {
		Long id = -1l;

		try {
			id = Long.parseLong(textFieldCodigo.getText());
		} catch (Exception e) {
		}

		Bebida bebida = null;
		if (id >= 0)
			bebida = dao.load(id);
		if (bebida == null)
			bebida = new Bebida();

		if (id >= 0)
			bebida.setId(id);
		bebida.setNome(textFieldNome.getText());
		bebida.setPreco(Double.parseDouble(textFieldPreco.getText()));
		bebida.setQtd(Integer.parseInt(textFieldQtd.getText()));
		return bebida;
	}

	@FXML
	public void btnAddClick(ActionEvent event) {
		Bebida bebida = getBebida();
		dao.save(bebida);
		updateTableView();
		textFieldCodigo.setText(bebida.getId() + "");
	}

	@FXML
	public void btnNewClick(ActionEvent event) {
		textFieldCodigo.setText("");
		btnAddClick(event);
	}

	@FXML
	public void btnRemoveClick(ActionEvent event) {
		if (!textFieldCodigo.getText().equals("")) {
			Bebida bebida = getBebida();
			dao.delete(bebida);
			updateTableView();
			textFieldCodigo.setText("");
		} else
			JOptionPane.showMessageDialog(null, "Codigo nullo!");
	}

	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getBebidas());
	}

	public ObservableList<Bebida> getBebidas() {
		List<Bebida> bebidas = dao.list();
		ObservableList<Bebida> lista = FXCollections.observableArrayList();
		for (Bebida bebida : bebidas)
			lista.add(bebida);
		return lista;
	}
}
