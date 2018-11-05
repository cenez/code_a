package util;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLDao<T> {
	public void toXMLFile(List<T> list, String path) {
		XStream stream = new XStream(new DomDriver());
		FileUtil.writeFile(path, stream.toXML(list));
	}
	@SuppressWarnings("unchecked")
	public List<T> fromXMLFile(String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = FileUtil.readFile(path);
		return (List<T>) stream.fromXML(xml);
	}
}
