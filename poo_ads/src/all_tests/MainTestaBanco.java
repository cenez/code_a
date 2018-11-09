package all_tests;

import model.dao.DAO;
import model.entidade.Bebida;
import model.entidade.Cardapio;
import model.entidade.Cheque;
import model.entidade.Cliente;
import model.entidade.Entregador;
import model.entidade.Pagamento;
import model.entidade.Pedido;
import util.ConnectionFactory;

public class MainTestaBanco {
	public static void main(String[] args) {
		DAO<Cardapio,Long> cardapioDao = new DAO<>(ConnectionFactory.currentManager(), Cardapio.class);
		DAO<Pedido,Long> pedidoDao = new DAO<>(ConnectionFactory.currentManager(), Pedido.class);
		DAO<Cliente,Long> clienteDao = new DAO<>(ConnectionFactory.currentManager(), Cliente.class);
		DAO<Entregador,Long> entregadorDao = new DAO<>(ConnectionFactory.currentManager(), Entregador.class);
		
		Cliente joao = new Cliente("Joao", "RuaDeBoa");
		Entregador jose = new Entregador("Jose Silva", "YZK-1232");
		Pagamento pagamento = new Cheque(2.5, "12345", "ag-123", "cc-123456","1");
		Pedido pedido = new Pedido(joao, jose, pagamento);
		
		Cardapio coca = new Bebida("Coca", 4.5, 10);
		Cardapio fanta = new Bebida("Fanta", 4.5, 10);
		
		pedido.addItem(coca, 2);
		pedido.addItem(fanta, 1);
		
		cardapioDao.save(coca);
		cardapioDao.save(fanta);
		
		clienteDao.save(joao);
		entregadorDao.save(jose);
		
		pedido.entregaFeita(true);
		pedidoDao.save(pedido);

		System.out.println(pedido.ticket());
		System.out.println(jose.ticket());
		ConnectionFactory.close();
	}
}
