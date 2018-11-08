package model.entidade;

import javax.persistence.Entity;

@Entity
public class Lanche extends ItemCardapio {
	public Lanche() {}
	public Lanche(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public Lanche(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	@Override
	public final boolean visit(ItemPedido visitor) { return true; }
}
