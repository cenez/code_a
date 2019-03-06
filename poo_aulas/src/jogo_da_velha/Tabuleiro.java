package jogo_da_velha;

class Tabuleiro {
	int size = 9;
	Celula[] celulas;
	String statusLivre = "_";
	
	Tabuleiro() {
		celulas = new Celula[9];
		for(int i = 0; i < size; i++) {
			celulas[i] = new Celula(statusLivre);
		}
	}
}
