import java.util.List;

public class Teste {
	public <T extends Teste> T getHead(List<T> list) {
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	public static void main(String[] args) {
		
	}
}
