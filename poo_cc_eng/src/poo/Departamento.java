package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departamento {
	protected int codigo;
	protected String nome;
	protected List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
	}

	public void addFuncionario(Funcionario f){
		funcionarios.add(f);
	}
	
	public Departamento(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "["+this.codigo+":"+this.nome+"]";
	}
}
