package fecho.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import fecho.common.Point;

public class ServicePontos {
	public static Point[] pontos() {
		Collection<Point> l = new HashSet<>();
//		l.add(new Point(-250,  0));
//		l.add(new Point(-250,200));
//		l.add(new Point(-100,100));
//		l.add(new Point(-50,   0));
//		l.add(new Point(-50, 380));
//		l.add(new Point(100,-350));
//		l.add(new Point(0,   -50));
//		l.add(new Point(0,    50));
//		l.add(new Point(0,   350));
//		l.add(new Point(50,  100));
//		l.add(new Point(100,  50));
//		l.add(new Point(200,-300));
//		l.add(new Point(250,   0));
//		l.add(new Point(300, 100));
//		l.add(new Point(350,   0));
		
		Random r = new Random();
		for(int i = 0; i<500; i++) {
			int x = (r.nextInt()%390);
			int y = (r.nextInt()%390);
			l.add(new Point(x,   y));
		}
		
		return l.toArray(new Point[l.size()]);
	}
}
