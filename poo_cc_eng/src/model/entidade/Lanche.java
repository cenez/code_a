package model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lanche")
public class Lanche implements ItemCardapio {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="preco")
	protected double preco;
	
	public Lanche() {}
	public Lanche(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; }
	public double getPreco() { return this.preco; }
	public void setPreco(double preco) { this.preco = preco; }
	
	@Override
	public final boolean visit(ItemPedido visitor) { return true; }

	@Override
	public String toString() {
		return nome + "(" + preco + ")";
	}
}
