package model.entidade;

public class ItemPedido {
	protected int quantidade;
	protected ItemCardapio item;
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public ItemCardapio getItem() {
		return item;
	}
	public void setItem(ItemCardapio item) {
		this.item = item;
	}
}
