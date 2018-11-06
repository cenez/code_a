package model.entidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class Pedido {
	private Cliente cliente;
	private Pagamento pagamento;
	private boolean pendenteEntrega = true;
	private String data = null;
	private final Collection<ItemPedido> pedidos = new ArrayList<ItemPedido>();
	
	public Pedido(Cliente _cliente) {
		this.cliente = _cliente;
		LocalDate dt = LocalDate.now();
		data = dt.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}
	public void addItem(ItemCardapio item, int qtd) {
		ItemPedido ip = new ItemPedido(item, qtd);
		ip.setPedido(this);
		pedidos.add(ip);
	}
	public double total() {
		double soma = 0;
		for (ItemPedido ip : pedidos)
			soma += ip.getValidValue();
		return soma;
	}
	public Cliente getCliente()                  { return cliente; }
	public void setCliente(Cliente cliente)      { this.cliente = cliente; }
	public Pagamento getPagamento()              { return pagamento; }
	public void setPagamento(Pagamento pagamento){ this.pagamento=pagamento; }
	public boolean isPendente()                     { return pendenteEntrega; }
	public void entregaFeita(boolean ativo)          { this.pendenteEntrega = !ativo; }
	public String getData()                      { return data; }

	public String ticket() {
		StringBuilder sb = new StringBuilder();
		sb.append(System.lineSeparator()+"  Itens:");
		
		for (ItemPedido ip : pedidos)
			sb.append(ip.toString()+System.lineSeparator()+"        ");
		
		return "Pedido:"+System.lineSeparator()+
				"  "+cliente+System.lineSeparator()+
				"  pendenteEntrega="+pendenteEntrega+", data="+data+", total="+total()+
				sb.toString();
	}
}
