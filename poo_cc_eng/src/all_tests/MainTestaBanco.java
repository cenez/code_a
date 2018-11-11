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
		Cliente maria = new Cliente("Maria", "Rua B, 6 Apto 9");
		Cliente ana = new Cliente("Ana", "Rua C, 7 Apto 10");
		Cliente paula = new Cliente("Paula", "Rua D, 8 Apto 11");
		
		Entregador jose = new Entregador("Jose Motoboy", "YZK-1232");
		Entregador manoel = new Entregador("Manoel Motoboy", "PPI-8549");
		
		Pedido pedido1 = new Pedido(francisco,jose,new Cheque(2.5,"12345","ag-123","cc-123456","1"));
		Pedido pedido2 = new Pedido(maria,manoel,new Pagamento());
		Pedido pedido3 = new Pedido(ana,jose,new Pagamento());
		
		Cardapio coca = new Bebida("Coca", 4.5, 100);
		Cardapio fanta = new Bebida("Fanta", 4.5, 100);
		Cardapio xsalada = new Lanche("X-Salada", 12.0);
		Cardapio xtudo = new Lanche("X-Tudo", 15.0);
		Cardapio chaleao = new Bebida("Cha Leao", 4.0, 20);
		
		pedido1.addItem(coca, 2);
		pedido1.addItem(fanta, 200);
		pedido1.addItem(xsalada, 1);
		
		pedido2.addItem(coca, 2);
		pedido2.addItem(xsalada, 2);
		pedido2.addItem(xtudo, 1);
		
		pedido3.addItem(fanta, 1);
		pedido3.addItem(xtudo, 2);
		pedido3.addItem(xsalada, 1);
		
		cardapioDao.save(coca);
		cardapioDao.save(fanta);
		cardapioDao.save(xsalada);
		cardapioDao.save(xtudo);
		cardapioDao.save(chaleao);
		
		clienteDao.save(francisco);
		clienteDao.save(maria);
		clienteDao.save(ana);
		clienteDao.save(paula);
		
		entregadorDao.save(jose);
		entregadorDao.save(manoel);
		
		//Motoboy entregou:
		pedido1.entregaFeita(true);
		pedido2.entregaFeita(true);
		pedido3.entregaFeita(true);
		
		pedidoDao.save(pedido1);
		pedidoDao.save(pedido2);
		pedidoDao.save(pedido3);

		System.out.println(pedido1.ticket()+System.lineSeparator()+
						   pedido2.ticket()+System.lineSeparator()+
						   pedido3.ticket());
		System.out.println(jose.getNome()+":"+jose.ticket());
		System.out.println(manoel.getNome()+":"+manoel.ticket());
		ConnectionFactory.close();
	}
}
