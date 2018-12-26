package arvore_avl;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;

	public Pessoa(String name) {
		this.nome = name;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		String[] v = this.nome.split(" ");
		return v[0].hashCode();
	}
	@Override
	public String toString() {
		return this.nome;
	}
	@Override
	public int compareTo(Pessoa o) {
		return String.CASE_INSENSITIVE_ORDER.compare(this.getNome(), o.getNome());
	}
}
