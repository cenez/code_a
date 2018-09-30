package br.unifor.poo.model;

public class Funcionario {
	private static int auto_incremento = 0;
	protected int matricula;
	protected String nome;
	protected String atribuicao;
	protected Departamento depto;

	public Funcionario() {
		this.matricula = ++auto_incremento;
	}

	public Funcionario(String _nome) {
		this();
		this.nome = _nome;
	}

	public Funcionario(String _nome, String _atribuicao) {
		this();
		this.nome = _nome;
		this.atribuicao = _atribuicao;
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

	public int getMatricula() {
		return matricula;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		if (this.depto != null)
			return this.matricula + ":" + this.nome + ":" + this.atribuicao + ":" + this.depto.getNome();
		return this.matricula + ":" + this.nome + ":" + this.atribuicao;
	}
	public boolean setDepartamento(Departamento departamento) {
		if (departamento != null) {
			if (!departamento.equals(this.depto)) {
				if (this.depto != null)
					this.depto.remove(this);
				this.depto = departamento;
				return this.depto.addFuncionario(this);
			}
		} else if (this.depto != null) {
			Departamento dp = this.depto;
			this.depto = null;
			dp.remove(this);
			return true;
		}
		return false;
	}
}
