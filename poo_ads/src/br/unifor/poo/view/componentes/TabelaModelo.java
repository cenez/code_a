package br.unifor.poo.view.componentes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModelo<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final List<T> dataList;
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
	public void clear(){ dataList.clear(); }
	public void add(T t) { dataList.add(t); }
	public T getItem(int rowIndex){
		if(dataList.size() == 0) return null;
		return (T) dataList.get(rowIndex);
	}
}
