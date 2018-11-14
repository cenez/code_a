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
import model.entidade.Cardapio;
import util.ConnectionFactory;
import view.crud.TableViewPOO;

public class CardapioView {
	// Botoes e textFields
	@FXML
	protected TextField textFieldCodigo;
	@FXML
	protected TextField textFieldNome;
	@FXML
	protected TextField textFieldPreco;
	@FXML
	protected Button btnAdd;
	@FXML
	protected Button btnRemove;
	@FXML
	protected Button btnNew;
	@FXML
	protected GridPane grid_pane;

	protected TableViewPOO<Cardapio> tableView;
	protected DAO<Cardapio, Long> dao;

	@FXML
	public void initialize() {
		dao = new DAO<Cardapio, Long>(ConnectionFactory.currentManager(), Cardapio.class);
		tabelaConfig();
		textFieldCodigo.getStyleClass().add("desabilitado");
		textFieldCodigo.setDisable(true);
	}

	public void tabelaConfig() {
		tableView = new TableViewPOO<>(Cardapio.class, "id", "nome", "preco");
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
		Cardapio cardapio = dao.load(tableView.getSelectionModel().getSelectedItem().getId());
		textFieldCodigo.setText("" + cardapio.getId());
		textFieldNome.setText(cardapio.getNome());
		textFieldPreco.setText("" + cardapio.getPreco());
	}

	public Cardapio getCardapio() {
		Long id = -1l;

		try {
			id = Long.parseLong(textFieldCodigo.getText());
		} catch (Exception e) {
		}

		Cardapio cardapio = null;
		if (id >= 0)
			cardapio = dao.load(id);
		if (cardapio == null)
			cardapio = new Cardapio();

		if (id >= 0)
			cardapio.setId(id);
		cardapio.setNome(textFieldNome.getText());
		cardapio.setPreco(Double.parseDouble(textFieldPreco.getText()));
		return cardapio;
	}

	@FXML
	public void btnAddClick(ActionEvent event) {
		Cardapio cardapio = getCardapio();
		dao.save(cardapio);
		updateTableView();
		textFieldCodigo.setText(cardapio.getId() + "");
	}

	@FXML
	public void btnNewClick(ActionEvent event) {
		textFieldCodigo.setText("");
		btnAddClick(event);
	}

	@FXML
	public void btnRemoveClick(ActionEvent event) {
		if (!textFieldCodigo.getText().equals("")) {
			Cardapio cardapio = getCardapio();
			dao.delete(cardapio);
			updateTableView();
			textFieldCodigo.setText("");
		} else
			JOptionPane.showMessageDialog(null, "Codigo nullo!");
	}

	public void updateTableView() {
		tableView.getItems().clear();
		tableView.getItems().addAll(getCardapios());
	}

	public ObservableList<Cardapio> getCardapios() {
		List<Cardapio> cardapios = dao.list();
		ObservableList<Cardapio> lista = FXCollections.observableArrayList();
		for (Cardapio cardapio : cardapios)
			lista.add(cardapio);
		return lista;
	}
}
