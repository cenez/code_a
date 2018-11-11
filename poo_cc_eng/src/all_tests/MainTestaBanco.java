package all_tests;

import model.dao.DAO;
import model.entidade.Bebida;
import model.entidade.Cardapio;
import model.entidade.Cheque;
import model.entidade.Cliente;
import model.entidade.Entregador;
import model.entidade.Lanche;
import model.entidade.Pagamento;
import model.entidade.Pedido;
import util.ConnectionFactory;

public class MainTestaBanco {
	public static void main(String[] args) {
		DAO<Cardapio,Long> cardapioDao = new DAO<>(ConnectionFactory.currentManager(), Cardapio.class);
		DAO<Pedido,Long> pedidoDao = new DAO<>(ConnectionFactory.currentManager(), Pedido.class);
		DAO<Cliente,Long> clienteDao = new DAO<>(ConnectionFactory.currentManager(), Cliente.class);
		DAO<Entregador,Long> entregadorDao = new DAO<>(ConnectionFactory.currentManager(), Entregador.class);
		
		Cliente francisco = new Cliente("Francisco", "Rua A, 5 Apto 8");
		Entregador joseMotoboy = new Entregador("Jose Motoboy", "YZK-1232");
		Pagamento pagamento = new Cheque(2.5, "12345", "ag-123", "cc-123456","1");
		Pedido pedido = new Pedido(francisco, joseMotoboy, pagamento);
		
		Cardapio coca = new Bebida("Coca", 4.5, 100);
		Cardapio fanta = new Bebida("Fanta", 4.5, 100);
		Cardapio xsalada = new Lanche("X-Salada", 12.0);
		
		pedido.addItem(coca, 2);
		pedido.addItem(fanta, 200);
		pedido.addItem(xsalada, 1);
		
		cardapioDao.save(coca);
		cardapioDao.save(fanta);
		cardapioDao.save(xsalada);
		
		clienteDao.save(francisco);
		entregadorDao.save(joseMotoboy);
		
		//Motoboy entregou:
		pedido.entregaFeita(true);
		
		pedidoDao.save(pedido);

		System.out.println(pedido.ticket());
		System.out.println(joseMotoboy.ticket());
		ConnectionFactory.close();
	}
}
