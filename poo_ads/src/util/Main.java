package util;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Bebida> bebidas = new ArrayList<Bebida>();
		bebidas.add(new Bebida("Coca"));
		bebidas.add(new Bebida("Guarana"));
		bebidas.add(new Bebida("Suco-Laranja"));
		bebidas.add(new Bebida("Suco-Uva"));
		GeradorDeXML<Bebida> gerador = new GeradorDeXML<Bebida>();
		String path = gerador.geraDados(bebidas);
		
		XMLDao<Bebida> xml = new XMLDao<Bebida>();
		List<Bebida> novaLista = xml.fromXMLFile(path);
		for (Bebida bebida : novaLista) {
			System.out.println(bebida);
		}
	}
}
