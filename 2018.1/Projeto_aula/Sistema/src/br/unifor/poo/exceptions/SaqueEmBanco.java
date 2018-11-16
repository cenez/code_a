package br.unifor.poo.exceptions;

public class SaqueEmBanco {
	private double saldo = 1.0;
	public static void main(String[] args) {
		double[] aplicacaoArray = new double[2];
		try {			
			aplicacaoArray[0] = 10;
			aplicacaoArray[1] = 20;
			aplicacaoArray[2] = 30;
		} catch (Exception e) {
			System.out.println("No máximo 2 aplicações são permitidas!");
		}
		SaqueEmBanco seb = new SaqueEmBanco();
		try {
			seb.sacar(2);
		} catch (InsuficienteFundoException e) {
			e.printStackTrace();
		}
	}
	public void sacar(double qtd) throws InsuficienteFundoException {
		if (qtd > saldo)
			throw new InsuficienteFundoException(qtd);
	}
}
