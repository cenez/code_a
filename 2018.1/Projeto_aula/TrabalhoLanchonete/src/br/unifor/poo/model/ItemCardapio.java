package br.unifor.poo.model;

public class ItemCardapio {
	private String nome;
	public ItemCardapio(){}
	public ItemCardapio(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	private double preco;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
