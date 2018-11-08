package model.entidade;

public class Pagamento {
	protected Pedido pedido = null;
	protected Cheque cheque = null;
	protected double cartaoDinheiro = 0;

	public Pagamento() { }
	public Pagamento(Pedido pedido) { this.pedido = pedido; }
	public Pagamento(Pedido pedido, double valor) {
		this.pedido = pedido;
		this.cartaoDinheiro = valor;
	}
	public Pagamento(Pedido pedido, Cheque cheque) {
		this.pedido = pedido;
		this.cheque = cheque;
	}
	public Pagamento(Pedido pedido, Cheque cheque, double valor) {
		this.pedido = pedido;
		this.cheque = cheque;
		this.cartaoDinheiro = valor;
	}
	public double total() { 
		if(this.cheque!=null)
			return this.cartaoDinheiro + this.cheque.getValue(); 
		return this.cartaoDinheiro;
	}
	
	public void setCheque(Cheque cheque)  { this.cheque = cheque; }
	public Pedido getPedido()             { return pedido; }
	public void setPedido(Pedido pedido)  { this.pedido = pedido; }
	public Cheque getCheque()             { return cheque; }
	public double getValorCartaoDinheiro(){ return cartaoDinheiro; }

	@Override
	public String toString() {
		return "Pagamento(cheque:"+cheque+"+cartao|dinheiro:"+cartaoDinheiro+"="+total()+")";
	}
}
