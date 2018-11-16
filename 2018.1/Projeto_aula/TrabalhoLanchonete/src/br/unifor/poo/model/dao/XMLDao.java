package br.unifor.poo.model.dao;

import java.io.Reader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.unifor.poo.util.FileUtil;

public class XMLDao<T> {
	public List<T> carrega(Reader fonte) {
		XStream stream = new XStream(new DomDriver());
		return (List<T>) stream.fromXML(fonte);
	}
	public void toXMLFile(List<T> list, String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = stream.toXML(list);
		FileUtil.writeFile(path, xml);
	}
	public List<T> fromXMLFile(String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = FileUtil.readFile(path);
		List<T> l = (List<T>) stream.fromXML(xml);
		return l;
	}
}
