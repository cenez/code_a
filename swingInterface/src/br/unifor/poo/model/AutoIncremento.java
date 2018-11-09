package br.unifor.poo.model;

public class AutoIncremento {
	private static int auto_incremento = 0;
	public static int getNum(){ return ++auto_incremento; }
}
