package br.unifor.poo.model;

public class Aluno {
	protected int matricula;
	protected String nome;
	protected String mae;
	protected Departamento depto;

	public Aluno() {
		this.matricula = AutoIncremento.getNum();
	}

	public Aluno(String _nome) {
		this();
		this.nome = _nome;
	}

	public Aluno(String _nome, String _mae) {
		this();
		this.nome = _nome;
		this.mae = _mae;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String _mae) {
		this.mae = _mae;
	}

	public Departamento getDepto() {
		return depto;
	}

	public int getMatricula() {
		return matricula;
	}

	@Override
	public String toString() {
		return this.matricula + ":" + this.nome;
	}
	public boolean setDepartamento(Departamento departamento) {
		if (departamento != null) {
			if (!departamento.equals(this.depto)) {
				if (this.depto != null)
					this.depto.remove(this);
				this.depto = departamento;
				return this.depto.addAluno(this);
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
