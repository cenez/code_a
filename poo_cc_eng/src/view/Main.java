package view;

import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.dao.XMLDao;
import model.entidade.Bebida;

public class Main {
	public static void main(String[] args) {
		XStream stream = new XStream(new DomDriver());
		Bebida coca = new Bebida("Coca-Cola", 4.5, 1000);
		Bebida fanta = new Bebida("Fanta", 4.5, 1000);
		Bebida guarana = new Bebida("Guarana", 4.5, 1000);
		
		List<Bebida> bebidas = Arrays.asList(coca, fanta, guarana);
//		
//		String xml = stream.toXML(bebidas);
//		
//		FileUtil.writeFile("bebidas.xml", xml);
		XMLDao<Bebida> dao = new XMLDao<Bebida>();
		dao.toXMLFile(bebidas, "bebidas2.xml");
		
		List<Bebida> lista = dao.fromXMLFile("bebidas2.xml");
		lista.forEach(t->{ System.out.println(t);});
		
		//String xml = FileUtil.readFile("bebidas.xml");
		
		//List<Bebida> teste = (List<Bebida>) stream.fromXML(xml);
		//teste.forEach(t->{ System.out.println(t); });
		
	}
}
