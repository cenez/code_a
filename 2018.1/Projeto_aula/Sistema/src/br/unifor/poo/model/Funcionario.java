package br.unifor.poo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="atribuicao")
	private String atribuicao;
	
	@ManyToOne
	private Departamento departamento = null;
	
	public Funcionario() {}
	public Funcionario(Long id, String nome, String atribuicao) { this.id = id; this.nome = nome; this.atribuicao = atribuicao; }
	
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
			if(f.getId()==this.id)
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		if(this.departamento!=null)
			return this.id+"."+this.nome+" Dpto."+this.departamento.getNome();
		else return this.id+"."+this.nome+" Dpto.null";
	}
}
