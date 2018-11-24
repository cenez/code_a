package br.unifor.concorrente;

import br.unifor.concorrente.produtorconsumidor.Consumidor;
import br.unifor.concorrente.produtorconsumidor.Produtor;

public class Main {
	
	/* Este programa intencionalmente trava quando executado*/
	public static void main(String[] args) throws InterruptedException {
		Produtor produtor = new Produtor();
		Consumidor consumidor = new Consumidor();
		produtor.start();
		consumidor.start();
	}
}
