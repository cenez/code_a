package model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lanche")
public class Lanche extends ItemCardapio {
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
		super(nome, preco);
	}
	@Override
	public final boolean visit(ItemPedido visitor) { return true; }
}
