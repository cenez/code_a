package model.entidade;

public class ItemPedido {
	protected int quantidade;
	protected ItemCardapio item;
	protected boolean validado = true;
	
	public ItemPedido(ItemCardapio _item, int qtd) {
		this.item = _item;
		this.quantidade = qtd;
		this.validado = this.item.visit(this);
	}
	
	public boolean isValidado()               { return validado; }
	public void setValidado(boolean validado) { this.validado = validado; }
	public int getQuantidade()                { return this.quantidade; }
	public void setQuantidade(int qtd)        { this.quantidade = qtd; }
	public ItemCardapio getItem()             { return this.item; }
	public void setItem(ItemCardapio item)    { this.item = item; }
}
