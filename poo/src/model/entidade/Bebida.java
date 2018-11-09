package model.entidade;

import javax.persistence.Entity;

@Entity
public class Bebida extends ItemCardapio {
	public Bebida() {}
	public Bebida(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public Bebida(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	@Override
	public final boolean visit(ItemPedido visitor) {
		boolean liberado = visitor.getQuantidade()<=this.quantidade;
		if(liberado)
			this.quantidade = this.quantidade-visitor.getQuantidade();
		return liberado;
	}
}
