package util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import geometrics.Point;

public class ServicePontosSort {
	public static Point[] pontos(int numPontos) {
		Collection<Point> l = new HashSet<>();
		Random r = new Random();
		for(int i = 0; i<numPontos; i++) {
			int x = (r.nextInt()%190);
			int y = (r.nextInt()%190);
			l.add(new Point(5, x,   y));
		}
		
		return l.toArray(new Point[l.size()]);
	}
}
