package model.entidade;

import model.entidade.patters.EntityVisitor;

public interface ItemCardapio extends EntityVisitor {
	public String getNome();
	public void setNome(String nome);
	public double getPreco();
	public void setPreco(double preco);
}
