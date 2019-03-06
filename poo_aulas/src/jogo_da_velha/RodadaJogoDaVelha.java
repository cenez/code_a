package jogo_da_velha;
class RodadaJogoDaVelha {
	Tabuleiro tabuleiro = new Tabuleiro();
	int totalJogadas = 0;
	String jogadorA = "A";
	String jogadorB = "B";
	
	String fechouJogada(String a, String b, String c) {
		if((a==b && a==c) && (a!=tabuleiro.statusLivre))
			return a;
		return "";
	}
	String jogada(int position) {
		if(position>=1 && position<=tabuleiro.size) {
			if(tabuleiro.celulas[position-1].valor==tabuleiro.statusLivre) {
				if((totalJogadas++) % 2 ==0)
					tabuleiro.celulas[position-1].valor = jogadorA;
				else
					tabuleiro.celulas[position-1].valor = jogadorB;
				String ganhador = getGanhador();
				if(ganhador!="Indefinido") {
					show();
					return "\n"+ganhador + " Venceu a partida!";
				}
			} 
			else return "Celula já marcada!!!";
			
			return "Celula marcada com sucesso!!!";
		}
		return "Posição incorreta!!!";
	}
	
	String getGanhador() {
		for(int i = 0; i < tabuleiro.size; i = i + 3) { //Ganhou pelas Linhas?
			String msn = fechouJogada(tabuleiro.celulas[i].valor, 
								 tabuleiro.celulas[i+1].valor, 
								 tabuleiro.celulas[i+2].valor); 
			if(msn!="") return msn;
		}
		for(int i = 0; i < Math.sqrt(tabuleiro.size); i++) { //Ganhou pelas Colunas?
			String msn = fechouJogada(tabuleiro.celulas[i].valor,
								 tabuleiro.celulas[i+3].valor,
								 tabuleiro.celulas[i+6].valor); 
			if(msn!="") return msn;
		}
		for(int i = 0; i < 2; i = i + 2) { //Ganhou pelas Diagonais?
			String msn = fechouJogada(tabuleiro.celulas[i].valor, 
								 tabuleiro.celulas[4].valor, 
								 tabuleiro.celulas[8-i].valor); 
			if(msn!="") return msn;
		}
		return "Indefinido";
	}
	void show() {
		System.out.println("\nTabuleiro");
		for (int i = 0; i < tabuleiro.size; i++) {
			if(i==0 || i==3 || i==6)
				System.out.print("[ ");
			System.out.print(tabuleiro.celulas[i].valor + " ");
			if(i==2 || i==5 || i==8)
				System.out.println("]");
		}
	}
}
