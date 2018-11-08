package all_tests;

import model.dao.DAO;
import model.entidade.Bebida;
import util.ConnectionFactory;

public class MainTestaBanco {
	public static void main(String[] args) {
		DAO<Bebida,Long> dao_bebida = new DAO<>(ConnectionFactory.currentManager(), Bebida.class);
	
		Bebida bebida = dao_bebida.load(1l);
		if(bebida!=null) {
			System.out.println(bebida);
		} else {
			bebida = new Bebida("Coca-Cola", 5.2, 1000);
			dao_bebida.save(bebida);
		}
		
		ConnectionFactory.close();
	}
}
