package model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemcardapio")
public class ItemCardapio {
	@Id
	@GeneratedValue
	@Column(name="id")
	protected Long id;

	@Column(name="nome")
	protected String nome;
	
	@Column(name="preco")
	protected double preco;
	
	@Column(name="quantidade")
	protected Integer quantidade = null;

	public ItemCardapio() {}
	public ItemCardapio(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	public ItemCardapio(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public boolean visit(ItemPedido visitor) { return true; }

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }
	public double getPreco() { return this.preco; }
	public void setPreco(double preco) { this.preco = preco; }
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

	@Override
	public String toString() {
		if(this.quantidade!=null) {
			return nome + "(" + this.preco + ", "+this.quantidade+")";
		}
		return nome + "(" + this.preco +")";
	}
}