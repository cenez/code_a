package util;

import java.util.List;

public class GeradorDeXML<T> {
	public static int increment = 0;
	public String geraDados(List<T> lista) {
		XMLDao<T> xml = new XMLDao<T>();
		String path = "/tmp/dados"+(++increment)+".xml";
		xml.toXMLFile(lista, path);
		return path;
	}
}
