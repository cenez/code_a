package model.dao;

import java.io.Reader;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import util.FileUtil;

public class XMLDao<T> {
	public void commit(Collection<T> collection, String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = stream.toXML(collection);
		FileUtil.writeFile(path, xml);
	}
	public Collection<T> load(String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = FileUtil.readFile(path);
		return (Collection<T>) stream.fromXML(xml);
	}
	public Collection<T> load(Reader fonte) {
		XStream stream = new XStream(new DomDriver());
		return (Collection<T>) stream.fromXML(fonte);
	}
}
