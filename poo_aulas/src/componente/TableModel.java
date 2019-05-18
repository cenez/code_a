package componente;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final List<T> dataList;
	
	public TableModel() { dataList = new ArrayList<T>(); }
	public TableModel(List<T> list) { dataList =  list; }
	
	@Override
	public int getColumnCount() {
		if (dataList.size() == 0)
			return 0;
		T f = dataList.get(0);
		return f.getClass().getDeclaredFields().length;
	}

	@Override
	public int getRowCount() {
		return dataList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(dataList.size()==0) return null;
		T n = (T) dataList.get(rowIndex);

		Object o = null;
		Field atributo = n.getClass().getDeclaredFields()[columnIndex];
		atributo.setAccessible(true);
		try {
			o = atributo.get(n);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}
	@Override
	public String getColumnName(int column) {
		if(dataList.size()==0) return null;
		T n = (T) dataList.get(0);

		String o = "";
		Field atributo = n.getClass().getDeclaredFields()[column];
		atributo.setAccessible(true);
		try {
			o = atributo.getName();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return o;
	}
	public void clear() { dataList.clear(); }
	public void add(T t) { dataList.add(t); }
}
