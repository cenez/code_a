package br.unifor.poo.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Colecoes {
	public static void main(String[] args) {
		//listas e filas
		Collection<Integer> lista = Arrays.asList(1,2,3,4,5,6);
		Collection<Integer> fila = new LinkedList();
		fila.add(3); fila.add(2); fila.add(1);
		fila.add(8); fila.add(7); fila.add(6);
		fila.forEach(s-> { System.out.print(s + " ");}); System.out.println();

		//conjuntos
		Collection<Integer> conjunto = new HashSet<>();
		
		//Conjuntos Navegaveis
		System.out.println("***************** Navegavel *****************");
		NavigableSet<Integer> nav = new TreeSet<>(Arrays.asList(1,3,5,8,10,12));
		System.out.println("Reverso: "+nav.descendingSet());
		System.out.println("calda: "+nav.tailSet(2));
		System.out.println("lower(5): "+nav.lower(5));
		System.out.println("floor(10): "+nav.floor(10));
		System.out.println("higher(8): "+nav.higher(8));
		System.out.println("Removeu ultimo: "+nav.pollLast());
		System.out.println("Removeu Ultimo: "+nav.pollLast());
		System.out.println("Removeu Primeiro: "+nav.pollFirst());
		
		Map<Integer, String> mapa = new LinkedHashMap<Integer, String>();
		mapa.put(2, "Joao");
		mapa.put(1, "Pedro");
		for (Map.Entry<Integer, String> kv : mapa.entrySet()) {
			System.out.println(kv.getKey() + " : " + kv.getValue());
		}
		mapa.entrySet().stream().forEach(e-> { System.out.println(e.getKey()+"."+e.getValue());});

	}
}
