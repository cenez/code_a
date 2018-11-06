package all_tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.dao.XMLDao;
import model.entidade.Bebida;
import model.entidade.ItemPedido;
import model.entidade.Lanche;

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
		fromFile.forEach(item->{ System.out.println(item);});
		
		//Pattern visitor, ver se efetiva pedido ou nao
		Lanche xtudo = new Lanche("X-tudo", 5.4);
		ItemPedido itemLanche = new ItemPedido(xtudo, 5);
		
		ItemPedido itemCoca1 = new ItemPedido(coca, 1001);
		System.out.println("Remover 1001? Estoque coca: " + 
				coca.getQuantidade() + 
				" itemCoca1 validado="+itemCoca1.isValidado());
		
		ItemPedido itemCoca2 = new ItemPedido(coca, 200);
		System.out.println("Remover 200? Estoque coca: " + 
		        coca.getQuantidade() +
				" itemCoca2 validado="+itemCoca2.isValidado());
	}
}
