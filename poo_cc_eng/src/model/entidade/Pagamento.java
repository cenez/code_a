package model.entidade;

public class Pagamento {
	private double valor;
	private Pedido pedido;
	
	public Pagamento(double _valor) {  this.valor = _valor; }

	public double getValor() { return valor; }
	public void setValor(double valor) { this.valor = valor; }
	public Pedido getPedido() { return pedido; }
	public void setPedido(Pedido pedido) { this.pedido = pedido; }
}
