package model.entidade;

public class Lanche extends ItemCardapio {
	public Lanche(String nome, double preco) {
		super(nome, preco);
	}
	@Override
	public final boolean visit(ItemPedido visitor) { return true; }
}
