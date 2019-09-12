package teste;

public class Aluno {
	private String nome;
	private int matricula;
	private Endereco endereco;
	public Aluno(String nome, int matricula, Endereco endereco) {
		this.nome = nome;
		this.matricula = matricula;
		this.endereco = endereco;
	}
	public String getNome() { return nome; }
	public int getMatricula() { return matricula; }
	public void setNome(String nome) { this.nome = nome; }
	public void setMatricula(int matricula) { this.matricula = matricula; }
	public Endereco getEndereco() { return endereco; }
	public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}
