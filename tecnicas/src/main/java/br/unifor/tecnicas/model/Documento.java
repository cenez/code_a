package br.unifor.tecnicas.model;

import javax.persistence.Embeddable;

@Embeddable
public class Documento {
	private String numero;
	private DocumentoTipo tipo;
	public String getNumero() {
		return numero;
	}
	public DocumentoTipo getTipo() {
		return tipo;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setTipo(DocumentoTipo tipo) {
		this.tipo = tipo;
	}
}
