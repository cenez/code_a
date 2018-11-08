package model.entidade;

public interface Pagamento {
	public double getValue();
	public void setValue(double valor);
	public Pedido getPedido();
	public void setPedido(Pedido pedido);
}
