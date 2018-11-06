package model.entidade;

public class ItemPedido {
	protected int quantidade;
	protected ItemCardapio item = null;
	private Pedido pedido = null;
	protected boolean validado = true;
	
	public ItemPedido() { validado = false; }
	public ItemPedido(ItemCardapio _item, int qtd) {
		this.item = _item;
		this.quantidade = qtd;
		this.validado = this.item.visit(this);
	}
	public double getValidValue() {
		if(this.validado)
			return this.item.preco * this.quantidade;
		return 0;
	}
	
	public Pedido getPedido()                 { return this.pedido; }
	public void setPedido(Pedido pedido)      { this.pedido = pedido; }
	public boolean isValidado()               { return validado; }
	public void setValidado(boolean validado) { this.validado = validado; }
	public int getQuantidade()                { return this.quantidade; }
	public void setQuantidade(int qtd)        { this.quantidade = qtd; }
	public ItemCardapio getItem()             { return this.item; }
	public void setItem(ItemCardapio item)    { this.item = item; }
	@Override
	public String toString() {
		return "ItemPedido[" + item + "," + quantidade + ", validado=" + validado + "]";
	}
}
