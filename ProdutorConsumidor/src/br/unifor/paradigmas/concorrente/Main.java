package br.unifor.paradigmas.concorrente;

import br.unifor.paradigmas.concorrente.produtorconsumidor.Consumidor;
import br.unifor.paradigmas.concorrente.produtorconsumidor.Produtor;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Produtor produtor = new Produtor();
		Consumidor consumidor = new Consumidor();
		produtor.start();
		consumidor.start();
	}
}
