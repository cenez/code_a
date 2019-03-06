package aula_base;

class AulaBase {
	public static void main(String[] args) {
		//Isto é um comentário
		
		/* 
		 * Isto é um comentário mais longo
		*/
		
		// #### Vetores #####
		/*
		 * Todo vetor deve seguir a forma: 
		 * "Tipo[] variavel", exemplo:
		*/
		String[] vetor = {"Isso", "é", "um", "vetor", "de", "Strings"};
		int[] vetorInteiro = {8, 20, 3, 7, 5, 20};
		
		/*
		 * Nos vetores anteriores eles já nascem com dados
		 * Porém, é possível criar um vetor de tamanho prévio mas sem dados
		 * Veja exemplo:
		 */
		int[] vetorComTamanho10 = new int[10];
		
		 /*
		  * Vamos explorar os atalhos do eclipse
		  * 1- Digite foreach, segure a tecla ctrl, aperte a barra de espaço, dê enter na opção foreach
		  * 2- Dentro do laço "for" que surgir, faça:
		  *    a. Lembre-se que String é diferente de string, pois diferem pelas letras "S" ou "s" iniciais
		  *    b. Mude o nome da variável "string" para "palavra"
		  *    c. digite sysout, segure a tecla ctrl, aperte a barra de espaço
		  *    d. Deixe o novo código desta forma: System.out.println(palavra);
		  *    e. Aperte ctrl + F11 para rodar a aplicação
		  *    f. Para imprimir tudo em uma linha, remova o "ln" de println
		  *       Deixando agora desta forma: System.out.print(palavra + " ");
		  */
		for (String palavra : vetor) {
			System.out.print(palavra + " ");
		}

		//Imprima o tamanho do vetor:
		int tamanhoDoVetor = vetor.length;

		// A instrução abaixo "\n" quebra a linha anterior deixada pelo "System.out.print"
		// você poderia usar também System.out.println();, fazendo o mesmo efeito
		// Teste
		System.out.println("\n" + tamanhoDoVetor);
	}
}
