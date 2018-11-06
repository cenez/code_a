package model.entidade;

public class Cliente {
	private String nome;
	private String endereco;
	private boolean ativo = true;
	
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	public String getNome()                  { return nome; }
	public String getEndereco()              { return endereco; }
	public void setEndereco(String endereco) { this.endereco = endereco; }
	public boolean isAtivo()                 { return ativo; }
	public void setAtivo(boolean ativo)      { this.ativo = ativo; }
	@Override
	public String toString() {
		return "Cliente[" + nome + "," + endereco + "," + ativo + "]";
	}
}
