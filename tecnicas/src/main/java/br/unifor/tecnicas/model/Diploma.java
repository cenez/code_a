package br.unifor.tecnicas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Diploma {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String registro;
	
	@ManyToOne
	private Aluno aluno;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	@Override
	public String toString() {
		return "Diploma[id=" + id + ", registro=" + registro + "]";
	}
}
