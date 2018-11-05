package util;

public class Bebida {
	private String nome;
	public Bebida(String _nome) {
		this.nome = _nome;
	}
	@Override
	public String toString() {
		return "Bebida [nome=" + nome + "]";
	}
}
