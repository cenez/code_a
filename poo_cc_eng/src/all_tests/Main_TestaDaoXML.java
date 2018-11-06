package all_tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.dao.XMLDao;
import model.entidade.Bebida;

public class Main_TestaDaoXML {
	public static void main(String[] args) {
		Bebida coca = new Bebida("Coca-Cola", 4.5, 1000);
		Bebida fanta = new Bebida("Fanta", 4.5, 1000);
		Bebida guarana = new Bebida("Guarana", 4.5, 1000);
		
		//Testa Dao xml
		List<Bebida> lista_tmp = Arrays.asList(coca, fanta, guarana);
		Set<Bebida> bebidas_set = new HashSet<Bebida>(lista_tmp);
		XMLDao<Bebida> dao = new XMLDao<Bebida>();
		
		dao.commit(bebidas_set, "bebidas.xml");
		
		Collection<Bebida> fromFile = dao.load("bebidas.xml");
		fromFile.forEach(t->{ System.out.println(t);});
	}
}
