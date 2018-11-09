package br.unifor.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departamento {
	protected int codigo;
	protected String nome;
	protected List<Aluno> alunos = new ArrayList<Aluno>();

	public Departamento() {
		this.codigo = AutoIncremento.getNum();
	}

	public Departamento(String _nome) {
		this();
		this.nome = _nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public List<Aluno> getAlunos() {
		return Collections.unmodifiableList(alunos);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Departamento) {
			return ((Departamento) obj).getCodigo() == this.getCodigo();
		}
		return false;
	}

	@Override
	public String toString() {
		return this.codigo + ":" + this.nome;
	}
	public boolean isAluno(Aluno f) {
		return this.alunos.contains(f);
	}
	public boolean remove(Aluno f) {
		if (this.equals(f.getDepto()))
			f.setDepartamento(null);
		return this.alunos.remove(f);
	}
	public boolean addAluno(Aluno f) {
		if (f == null)
			return false;
		if (this.equals(f.getDepto())) {
			if (!this.isAluno(f))
				return this.alunos.add(f);
			else
				return false;
		}
		return f.setDepartamento(this);
	}
}
