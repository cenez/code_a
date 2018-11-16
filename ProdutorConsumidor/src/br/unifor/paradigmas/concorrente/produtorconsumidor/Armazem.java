package br.unifor.paradigmas.concorrente.produtorconsumidor;

import br.unifor.paradigmas.concorrente.Semaforo;

public class Armazem {
	public static Semaforo semaforo = new Semaforo(1);
	public static long MAX = 100;
	public final static int N = 10;
	public static long[] buffer = new long[N];
	public static int c = 0;
	public static int i = 0, f = 0;
}
