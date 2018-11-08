package all_tests;

import model.dao.DAO;
import model.entidade.Bebida;
import model.entidade.Lanche;
import util.ConnectionFactory;

public class MainTestaBanco {
	public static void main(String[] args) {
		DAO<Bebida,Long> dao_bebida = new DAO<>(ConnectionFactory.currentManager(), Bebida.class);
		DAO<Lanche,Long> dao_lanche = new DAO<>(ConnectionFactory.currentManager(), Lanche.class);
		
		Bebida coca_cola = dao_bebida.load(1l);
		Lanche xsalada = dao_lanche.load(1l);
		
		if(coca_cola==null && xsalada==null) {
			coca_cola = new Bebida("Coca-Cola", 5.2, 1000);
			xsalada = new Lanche("X-Salada", 5.2);
			dao_bebida.save(coca_cola);
			dao_lanche.save(xsalada);
		}
		System.out.println(coca_cola + "\n" + xsalada);
		
		ConnectionFactory.close();
	}
}
