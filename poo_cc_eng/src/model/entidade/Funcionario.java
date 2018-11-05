package model.entidade;

public class Funcionario {
	//public static final String LEMA = "Unidos venceremos!";
	protected int matricula;
	protected String nome;
	protected String atribuicao;
	protected Departamento depto = null;
	public Funcionario(){}
	public Funcionario(String nome, String atribuicao) {
		super();
		this.matricula = Incremento.getValue();
		this.nome = nome;
		this.atribuicao = atribuicao;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAtribuicao() {
		return atribuicao;
	}
	public void setAtribuicao(String atribuicao) {
		this.atribuicao = atribuicao;
	}
	public Departamento getDepto() {
		return depto;
	}
	public void setDepto(Departamento depto) {
		this.depto = depto;
	}
	@Override
	public String toString() {
		return this.matricula+
				":"+this.nome+
				":"+this.atribuicao+
				":"+this.depto;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Funcionario){
			Funcionario teste = (Funcionario) obj;
			return this.getMatricula()==teste.getMatricula();
		}
		return false;
	}
}
