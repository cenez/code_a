package model.dao;

import java.io.Reader;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import util.FileUtil;

public class XMLDao<T> {
	private XStream stream = new XStream(new DomDriver());
	public void commit(Collection<T> collection, String path) {
		String xml = stream.toXML(collection);
		FileUtil.writeFile(path, xml);
	}
	public Collection<T> load(String path) {
		String xml = FileUtil.readFile(path);
		return (Collection<T>) stream.fromXML(xml);
	}
	public Collection<T> load(Reader fonte) {
		return (Collection<T>) stream.fromXML(fonte);
	}
}
