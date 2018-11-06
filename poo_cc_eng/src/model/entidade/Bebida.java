package model.entidade;

public class Bebida extends ItemCardapio {
	private int quantidade;

	public Bebida(String nome, double preco, int quantidade) {
		super(nome, preco);
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

	@Override
	public final boolean visit(ItemPedido visitor) {
		boolean valido = visitor.getQuantidade()<=this.quantidade;
		if(valido)
			this.quantidade = this.quantidade-visitor.getQuantidade();
		return valido;
	}

	@Override
	public String toString() {
		return nome + "[" + this.quantidade + ", "+this.preco+"]";
	}
}
