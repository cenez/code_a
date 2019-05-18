package componente;

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

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
	public Object getValueAtRow(int row) {
		if(Math.abs(row)<dataList.size()) return (T) dataList.get(row);
		return null;
	}
	public void clear() { dataList.clear(); }
	public void add(T t) { dataList.add(t); }
	
	public static class TableCellRenderer<T> extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(
				JTable table, 
				Object value, 
				boolean isSelected,
				boolean hasFocus, 
				int row, 
				int column) {
			TableModel<T> model = (TableModel<T>) table.getModel();
			T t = (T) model.getValueAtRow(row);
			if(model.getValueAtRow(0).equals(t))
				setBackground(Color.green);
			else
				setBackground(Color.WHITE);
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}
}
