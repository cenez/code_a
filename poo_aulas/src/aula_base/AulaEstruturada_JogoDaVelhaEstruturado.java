package aula_base;
class AulaEstruturada_JogoDaVelhaEstruturado {
	static String fechou(String a, String b, String c) {
		if((a==b && a==c) && (a=="x" || a=="o")) {
			if(a=="x") return "X";
			else return "O";
		}
		return "";
	}
	static void imprime(String[] tabuleiro) {
		System.out.println("\nTabuleiro");
		int count = 0;
		for (String bloco : tabuleiro) {
			if(count==0 || count==3 || count==6)
				System.out.print("[ ");
			System.out.print(bloco + " ");
			if(count==2 || count==5 || count==8)
				System.out.println("]");
			count++;
		}
	}
	public static void main(String[] args) {
		String[] tabuleiro = {"_", "_", "_", "_", "_", "_", "_", "_", "_"};
		imprime(tabuleiro);
		
		tabuleiro[0] = "x"; imprime(tabuleiro);
		tabuleiro[2] = "o"; imprime(tabuleiro);
		tabuleiro[4] = "x"; imprime(tabuleiro);
		tabuleiro[8] = "o"; imprime(tabuleiro);
		tabuleiro[3] = "x"; imprime(tabuleiro);
		tabuleiro[5] = "o"; imprime(tabuleiro);

		String msn = "";

		//Linhas
		String a = tabuleiro[0], b = tabuleiro[1], c = tabuleiro[2];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn);
		
		a = tabuleiro[3]; b = tabuleiro[4]; c = tabuleiro[5];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn);
		
		a = tabuleiro[6]; b = tabuleiro[7]; c = tabuleiro[8];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn);
		
		//Colunas
		a = tabuleiro[0]; b = tabuleiro[3]; c = tabuleiro[6];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn);
		
		a = tabuleiro[1]; b = tabuleiro[4]; c = tabuleiro[7];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn);

		a = tabuleiro[2]; b = tabuleiro[5]; c = tabuleiro[8];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn);
		
		//Diagonais
		a = tabuleiro[2]; b = tabuleiro[4]; c = tabuleiro[6];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn); 
		
		a = tabuleiro[0]; b = tabuleiro[4]; c = tabuleiro[8];
		msn = fechou(a,b,c); 
		if(msn!="") System.out.println("Vitoria do " + msn); 
	}
}
