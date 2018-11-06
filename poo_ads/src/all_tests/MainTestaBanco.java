package all_tests;

import model.dao.DAO;
import model.entidade.Bebida;
import util.ConnectionFactory;

public class MainTestaBanco {
	public static void main(String[] args) {
		DAO<Bebida,Long> daoDp = new DAO<>(ConnectionFactory.currentManager(), Bebida.class);
	
		Bebida bebida = daoDp.load(1l);
		if(bebida!=null) {
			System.out.println(bebida);
		} else {
			bebida = new Bebida("Coca-Cola", 5.2, 1000);
			daoDp.save(bebida);
		}
		
		ConnectionFactory.close();
	}
}
