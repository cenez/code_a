package model.entidade;

public interface ItemCardapio {
	public String getNome();
	public void setNome(String nome);
	public double getPreco();
	public void setPreco(double preco);
	
	boolean visit(ItemPedido visitor);
}
