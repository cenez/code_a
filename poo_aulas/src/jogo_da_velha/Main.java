package jogo_da_velha;

class Main {
	public static void main(String[] args) {
		RodadaJogoDaVelha jogo = new RodadaJogoDaVelha();		
		System.out.println(jogo.jogada(1)); 
		System.out.println(jogo.jogada(3)); 
		System.out.println(jogo.jogada(5)); 
		System.out.println(jogo.jogada(9)); 
		System.out.println(jogo.jogada(4)); 
		System.out.println(jogo.jogada(6)); 
		
		//System.out.println(jogo.jogada(2));
		//System.out.println(jogo.jogada(7));
		//System.out.println(jogo.jogada(8));
	}
}
