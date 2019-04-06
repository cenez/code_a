package associacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departamento {
	private int codigo;
	private String nome;
	private final List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Departamento(int codigo, String nome) { 
		this.codigo = codigo; 
		this.nome = nome; 
	}
	public List<Funcionario> getFuncionarios(){ 
		return Collections.unmodifiableList(this.funcionarios); 
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
	public boolean isFuncionario(Funcionario f) { 
		return this.funcionarios.contains(f); 
	}
	public int size() { 
		return this.funcionarios.size(); 
	}
	public boolean remove(Funcionario f) { 
		if(this.equals(f.getDepartamento())) 
			f.setDepartamento(null);
		return this.funcionarios.remove(f); 
	}
	public boolean add(Funcionario f) { 
		if(f==null) return false;
		if(this.equals(f.getDepartamento())) {
			if(!this.isFuncionario(f))
				return this.funcionarios.add(f);
			else return false;
		}
		return f.setDepartamento(this);
	}
	public void imprimeFuncionarios() {
    System.out.println("Funcionarios do departamento " + this.nome + ":");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("   "+funcionario);
		}
	}
	@Override
	public String toString() {
		return this.codigo+":"+this.nome;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Departamento) {
			Departamento dp = (Departamento) obj;
			if(dp.getCodigo()==this.getCodigo()) return true;
		}
		return false;
	}
}
