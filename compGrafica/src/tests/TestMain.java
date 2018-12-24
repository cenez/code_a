package tests;

import geometrics.Point;
import util.SortPoint;

public class TestMain {
	public static void main(String[] args) {
		NO[] nodes = TestServicePontos.pontos();
		print(nodes);
		
		Point polo = new NO("POLO",-300, 0);
		SortPoint.SORT(polo, nodes, 0, nodes.length-1);
		print(nodes);
		
		Point b = new Point(300, 400); Point c = new Point(700,700);
		System.out.println("Distancia b->c: "+Math.sqrt(b.sqrDist(c)));
		
		if((polo.ccw(b, c))<0) System.out.println("polo -> b->c sentido-anti-horario");
		else System.out.println("polo -> b->c sentido-horario");
		System.out.println("b<c? "+polo.polarOrder(b, c));
	}
	public static void print(NO[] nodes) {
		for (NO no : nodes) {
			System.out.print(no.chave+" ");			
		}
		System.out.println();		
	}
}
