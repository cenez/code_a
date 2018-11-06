package model.entidade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entregador {
	private String nome;
	private String placa;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Entregador() { }
	public Entregador(String nome, String placa) {
		this.nome = nome;
		this.placa = placa;
	}
	public void recebePedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	public void recebePedido(Pedido ... _pedidos) {
		for (Pedido p : _pedidos)
			pedidos.add(p);
	}
	public String getNome()            { return nome; }
	public void setNome(String nome)   { this.nome = nome; }
	public String getPlaca()           { return placa; }
	public void setPlaca(String placa) { this.placa = placa; }
	public List<Pedido> getPedidos()   { 
		return Collections.unmodifiableList(pedidos); 
	}
	public double totalOfPedidoEntregues() {
		double soma = 0;
		for (Pedido p : pedidos) {
			if(!p.isPendente())
				soma += p.total();
		}
		return soma;
	}
	public double getComissao() {
		return totalOfPedidoEntregues()*0.05;
	}
	@Override
	public String toString() {
		return "Entregador[" + nome + "," + placa + "]";
	}
}
