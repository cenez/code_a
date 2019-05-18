package componente;

public class Funcionario {
	private int matricula;
	private String nome;
	private String atribuicao;
	private Departamento departamento = null;
	
	public Funcionario(int matricula, String nome, String atribuicao) { 
		this.matricula = matricula; 
		this.nome = nome; 
		this.atribuicao = atribuicao; 
	}
	public Funcionario(int matricula, String nome, String atribuicao, Departamento dp) {
		this(matricula,nome,atribuicao);
		this.departamento = dp;
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public boolean setDepartamento(Departamento departamento) {
		if(departamento!=null) {
			if(!departamento.equals(this.departamento)) {
				if(this.departamento!=null) 
					this.departamento.remove(this);
				this.departamento = departamento;
				return this.departamento.add(this);
			}
		} else if(this.departamento!=null) {
			Departamento dp = this.departamento;
			this.departamento = null;
			dp.remove(this);
			return true;
		}
		return false;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Funcionario) {
			Funcionario f = (Funcionario) obj;
			if(f.getMatricula()==this.matricula)
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		if(this.departamento!=null)
			return this.matricula+"."+this.nome+" "+this.departamento.getNome();
		else return this.matricula+"."+this.nome+" Dpto: null";
	}
}

