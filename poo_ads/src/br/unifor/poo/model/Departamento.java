package br.unifor.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Departamento {
	protected int codigo;
	protected String nome;
	protected List<Funcionario> funcionarios = new ArrayList<Funcionario>();

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

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
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
		StringBuilder sb = new StringBuilder("[ ");
		int len = funcionarios.size();
		AtomicInteger i = new AtomicInteger(0);
		funcionarios.forEach(f -> {
			String s = (i.incrementAndGet()) == len ? " " : ", ";
			sb.append(f.getNome() + s);
		});
		sb.append("]");
		return this.codigo + ":" + this.nome + ":" + sb.toString();
	}
	public boolean isFuncionario(Funcionario f) {
		return this.funcionarios.contains(f);
	}
	public boolean remove(Funcionario f) {
		if (this.equals(f.getDepto()))
			f.setDepartamento(null);
		return this.funcionarios.remove(f);
	}
	public boolean addFuncionario(Funcionario f) {
		if (f == null)
			return false;
		if (this.equals(f.getDepto())) {
			if (!this.isFuncionario(f))
				return this.funcionarios.add(f);
			else
				return false;
		}
		return f.setDepartamento(this);
	}
}
