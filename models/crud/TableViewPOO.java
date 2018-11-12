package view;

import java.lang.reflect.Field;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewPOO<T> extends TableView<T> {
	
	private Class<T> persistentClass;
	
	public TableViewPOO(Class<T> persistentClass, String... colunas) {
		
		this.persistentClass = persistentClass;
		
		Field[] fields = this.persistentClass.getDeclaredFields();
		
		for (Field f : fields) {
			if(contem(colunas, f.getName())) {
				TableColumn<T, ?> tc = new TableColumn<>(f.getName().toUpperCase());
				tc.setMinWidth(f.getName().length()+200);
				tc.setCellValueFactory(new PropertyValueFactory<>(f.getName()));
				getColumns().add(tc);
			}
		}
	}
	private boolean contem(String[] colunas, String nome) {
		for (String s : colunas)
			if(s.equals(nome)) return true;
		return false;
	}
}
