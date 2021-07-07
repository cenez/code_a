package utils;
import java.io.IOException;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
public class XMLControl<T> {
	public List<T> fromXMLFile(String path){
		XStream stream = new XStream(new DomDriver());
		String xml = "";
		try { xml = FileUtil.readFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (List<T>) stream.fromXML(xml);
	}
	public void toXMLFile(List<T> list, String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = stream.toXML(list);
		FileUtil.writeFile(path, xml);
	}
	public T fromXMLFileT(String path){
		XStream stream = new XStream(new DomDriver());
		String xml = "";
		try {
			xml = FileUtil.readFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T) stream.fromXML(xml);
	}
	public void toXMLFileT(T t, String path) {
		XStream stream = new XStream(new DomDriver());
		String xml = stream.toXML(t);
		FileUtil.writeFile(path, xml);
	}
}
