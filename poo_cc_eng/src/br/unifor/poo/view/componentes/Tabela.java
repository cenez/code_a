package br.unifor.poo.view.componentes;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabela<T> extends JScrollPane {
	private static final long serialVersionUID = 1L;
	protected JTable tabela = new JTable();
	protected TabelaModelo<T> modelo = new TabelaModelo<T>();
	public Tabela() {
		this.getViewport().add(tabela);
	}
	public void addItem(T t) {
		modelo.add(t);
		tabela.setModel(modelo);
		modelo.fireTableDataChanged();
	}
}
