package br.unifor.poo.model;

public class Bebida extends ItemCardapio {
	private int qtdEstoque;
	public Bebida(){}
	public Bebida(String nome, double preco, int qtdEstoque) {
		super(nome, preco);
		this.qtdEstoque = qtdEstoque;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bebida) {
			Bebida o = (Bebida) obj;
			return this.getNome().equals(o.getNome());
		}
		return false;
	}
	@Override
	public String toString() {
		return this.getNome();
	}

}
