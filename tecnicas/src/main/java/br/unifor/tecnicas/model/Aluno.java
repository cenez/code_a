package br.unifor.tecnicas.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String endereco;
	
	@ElementCollection
	private List<Documento> documentos;
	
	@OneToMany(mappedBy = "aluno")
	protected List<Diploma> diplomas;
	
	public Aluno() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String _endereco) {
		this.endereco = _endereco;
	}
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> _docs) {
		this.documentos = _docs;
	}
	public List<Diploma> getDiplomas() {
		return diplomas;
	}

	public void setDiplomas(List<Diploma> diplomas) {
		this.diplomas = diplomas;
	}
	@Override
	public String toString() {
		return this.nome;
	}
}
