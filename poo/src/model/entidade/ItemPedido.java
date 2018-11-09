package model.entidade;

public class ItemPedido {
	protected int quantidade;
	protected ItemCardapio item = null;
	private Pedido pedido = null;
	protected boolean liberado = true;
	
	public ItemPedido() { liberado = false; }
	public ItemPedido(ItemCardapio _item, int qtd) {
		this.item = _item;
		this.quantidade = qtd;
		this.liberado = this.item.visit(this);
	}
	public double getValidValue() {
		if(this.liberado)
			return this.item.getPreco() * this.quantidade;
		return 0;
	}
	
	public Pedido getPedido()                 { return this.pedido; }
	public void setPedido(Pedido pedido)      { this.pedido = pedido; }
	public boolean isLiberado()               { return liberado; }
	public void setLiberado(boolean livre)    { this.liberado = livre; }
	public int getQuantidade()                { return this.quantidade; }
	public void setQuantidade(int qtd)        { this.quantidade = qtd; }
	public ItemCardapio getItem()             { return this.item; }
	public void setItem(ItemCardapio item)    { this.item = item; }
	@Override
	public String toString() {
		return "Item[" + item + "," + quantidade + ", liberado =" + liberado + "]";
	}
}
