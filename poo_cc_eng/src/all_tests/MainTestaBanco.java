package all_tests;

import model.dao.DAO;
import model.entidade.Bebida;
import model.entidade.ItemCardapio;
import model.entidade.Lanche;
import util.ConnectionFactory;

public class MainTestaBanco {
	public static void main(String[] args) {
		DAO<ItemCardapio,Long> dao = new DAO<>(ConnectionFactory.currentManager(), ItemCardapio.class);
		
		ItemCardapio coca_cola = dao.load(1l);
		ItemCardapio xsalada = dao.load(2l);
		
		if(coca_cola==null && xsalada==null) {
			coca_cola = new Bebida("Coca-Cola", 5.2, 1000);
			xsalada = new Lanche("X-Salada", 5.2);
			dao.save(coca_cola);
			dao.save(xsalada);
		}
		System.out.println(coca_cola + "\n" + xsalada);
		
		ConnectionFactory.close();
	}
}
