package br.unifor.poo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.unifor.poo.model.servicos.IRHVisitor;
import br.unifor.poo.model.servicos.IVisitable;

@Entity
@Table(name="departamento")
public class Departamento implements IVisitable{
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@OneToMany(mappedBy="departamento", cascade=CascadeType.ALL)
	private final List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Departamento() { }
	public Departamento(Long id, String nome) { this.id = id; this.nome = nome; }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public boolean isFuncionario(Funcionario f) { return this.funcionarios.contains(f); }
	public int size() { return this.funcionarios.size(); }
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
	
	public void listaColaboradores() {
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);// + ":"+funcionario.getDepartamento().getNome());
		}
	}
	@Override
	public boolean aceitar(IRHVisitor visitor) {
		return visitor.visitar(this);
	}
	@Override
	public String toString() {
		return this.id+":"+this.nome;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Departamento) {
			Departamento dp = (Departamento) obj;
			if(dp.getId()==this.getId()) return true;
		}
		return false;
	}
}
