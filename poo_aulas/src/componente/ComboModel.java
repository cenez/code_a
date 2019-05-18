package componente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/* ComboBoxModel<T> extends ListModel<E>
 * ComboBoxModel<T> possui 2 métodos a implementar: getSelectedItem e setSelectedItem
 * ListModel<E> possui 2 métodos que serão implementados aqui: getElementAt e getSize
 * ListModel<E> possui 2 métodos implementados por AbstractListModel<E>: addListDataListener e removeListDataListener
 * AbstractListModel<E> também implementa:
	fireContentsChanged(Object source, int index0, int index1)//Visa atualizar todo o conteúdo do JComboBox.
	fireIntervalAdded(Object source, int index0, int index1)//Visa atualizar o intervalo de dados que foram inseridos no JComboBox.
	fireIntervalRemoved(Object source, int index0, int index1)//Visa atualizar o intervalo de dados que foram removidos no JComboBox.
 */

public class ComboModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {
	private static final long serialVersionUID = 1L;
	private List<T> listT;
	private T selectedItem;
	private final static int FIRSTINDEX = 0;

	public ComboModel() { this.listT = new ArrayList<T>(); }
	public ComboModel(List<T> listT) {
		this();
		this.listT.addAll(listT);
		if (getSize() > 0) {
			setSelectedItem(this.listT.get(FIRSTINDEX));
		}
	}
	
	@Override
	public T getElementAt(int index) { if(listT.size()>0) return listT.get(index); else return null; }//ListModel: recebe um int que será usado como índice para retornar um objeto da lista
	@Override
	public int getSize() { return listT.size(); }//ListModel: total de itens no nosso JComboBox
	@Override
	public T getSelectedItem() { return selectedItem; }//ComboBoxModel: usado pelo JComboBox para retornar o objeto que está selecionado
	@Override
	public void setSelectedItem(Object anItem) { selectedItem = (T) anItem; }//ComboBoxModel: usado pelo JComboBox para setar o objeto que está selecionado
	
	public void addItem(T item) {
		listT.add(item);
		fireIntervalAdded(this, getSize() - 1, getSize() - 1);
		setSelectedItem(listT.get(getSize() - 1));
	}
	public void addListItem(List<T> itens) {
		int primeiraLinha = getSize();
		listT.addAll(itens);
		fireIntervalAdded(this, primeiraLinha, primeiraLinha + itens.size());
		setSelectedItem(listT.get(getSize() - 1));
	}
	public void removeItem() {
		listT.remove(getSelectedItem());
		fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
		setSelectedItem(listT.get(FIRSTINDEX));
	}
	public void clear() {
		listT.clear();
		fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
	}
}
