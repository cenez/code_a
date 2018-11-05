package model.entidade;

public class ItemCardapio {
	protected String nome;
	protected double preco;
	public ItemCardapio(){}
	public ItemCardapio(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
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
	@Override
	public String toString() {
		return "ItemCardapio [nome=" + nome + ", preco=" + preco + "]";
	}
}
