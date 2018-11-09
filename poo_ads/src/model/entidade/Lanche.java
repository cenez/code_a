package model.entidade;

import javax.persistence.Entity;

@Entity
public class Lanche extends Cardapio {
	public Lanche() {}

	public Lanche(String _nome, double _preco) {
		this.nome = _nome;
		this.preco = _preco;
	}
}
