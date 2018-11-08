package model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bebida")
public class Bebida implements ItemCardapio {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="preco")
	protected double preco;
	
	@Column(name="quantidade")
	private int quantidade;

	public Bebida() {}
	public Bebida(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	@Override
	public final boolean visit(ItemPedido visitor) {
		boolean valido = visitor.getQuantidade()<=this.quantidade;
		if(valido)
			this.quantidade = this.quantidade-visitor.getQuantidade();
		return valido;
	}
	
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }
	public double getPreco() { return this.preco; }
	public void setPreco(double preco) { this.preco = preco; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

	@Override
	public String toString() {
		return nome + "[" + this.preco + ","+this.quantidade+"]";
	}
}
