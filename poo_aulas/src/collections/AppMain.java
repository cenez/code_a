package collections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AppMain {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayDeque<>();
		c.add(8);
		c.add(2);
		
		System.out.println("Iterando collections com for:");
		for (Integer i: c) {
			System.out.println(i);
		}

		System.out.println("Iterando collections com lambda:");
		c.forEach(e -> System.out.println(e));

		Map<Integer, String> mapa = new HashMap<Integer, String>();
		mapa.put(1, "Ana");
		mapa.put(2, "Joao");
		mapa.put(3, "Maria");
		mapa.put(4, "Paulo");
		
		System.out.println("Iterando Mapas com for:");
		for (Integer i : mapa.keySet()) {
			System.out.println(i + "," + mapa.get(i));
		}

		System.out.println("Iterando Mapas com lambda:");
		mapa.forEach((k,v) -> System.out.println(k + "," + v) );
	}
}
