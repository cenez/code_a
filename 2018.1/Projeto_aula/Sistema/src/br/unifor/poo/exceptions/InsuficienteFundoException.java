package br.unifor.poo.exceptions;

public class InsuficienteFundoException extends RuntimeException {
	private double max_qtd;

	public InsuficienteFundoException(double qtd) {
		super("Fundo insuficiente para " + qtd);
		this.max_qtd = qtd;
	}

	public double getAmount() {
		return max_qtd;
	}
}
