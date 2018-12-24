package tests;

import java.util.Collection;
import java.util.HashSet;

public class TestServicePontos {
	public static NO[] pontos() {
		Collection<NO> l = new HashSet<>();
		l.add(new NO("Y",0, -350));
		
		l.add(new NO("A",-250,  0));
		l.add(new NO("B",-250,200));
		l.add(new NO("C",-100,100));
		l.add(new NO("D",-50,   0));
		l.add(new NO("E",-50, 400));
		l.add(new NO("F",0,   -50));
		l.add(new NO("G",0,    50));
		l.add(new NO("H",0,   350));
		l.add(new NO("I",50,  100));
		l.add(new NO("J",100,-350));
		l.add(new NO("L",100,  50));
		l.add(new NO("M",200,-300));
		l.add(new NO("N",250,   0));
		l.add(new NO("O",300, 100));
		l.add(new NO("P",350,   0));
		
		return l.toArray(new NO[l.size()]);
	}
}
