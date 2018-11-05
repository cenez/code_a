package model.entidade;

public class Bebida extends ItemCardapio {
	private int quantidade;

	public Bebida(String nome, double preco, int quantidade) {
		super(nome, preco);
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
