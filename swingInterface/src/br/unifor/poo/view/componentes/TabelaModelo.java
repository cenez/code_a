package br.unifor.poo.view.componentes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModelo<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final List<T> dataList;
	private String[] columnName = null;
	public TabelaModelo() { dataList = new ArrayList<T>(); }
	
	@Override
	public int getRowCount() {
		return dataList.size();
	}
	@Override
	public int getColumnCount() {
		if(dataList.size() == 0)
			return 0;
		T f = dataList.get(0);
		return f.getClass().getDeclaredFields().length;
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
		if(this.columnName==null)
			configColumns();
		if(this.dataList.size()>0)
			return this.columnName[column];
		return "";
	}
	public void configColumns() {
		if(this.dataList.size()>0) {
			T n = (T) dataList.get(0);
			int i = 0;
			Field[] atributos = n.getClass().getDeclaredFields();
			this.columnName = new String[atributos.length];
			for (Field field : atributos) {
				this.columnName[i++] = field.getName().toUpperCase();
			}
		}
	}
	public void clear(){ dataList.clear(); }
	public void add(T t) { 
		dataList.add(t); 
	}
	public T getItem(int rowIndex){
		if(dataList.size() == 0) return null;
		return (T) dataList.get(rowIndex);
	}
}
