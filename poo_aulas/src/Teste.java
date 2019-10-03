import java.util.List;

public class Teste {
	public <T extends Teste> T getHead(List<T> list) {
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		System.out.format("Finonacci(%d)\n", fibo(44));
		System.out.println("Tempo: " + (System.currentTimeMillis()-t)/1000 + " seg");
	}
	public static long fibo(long n) {
		if(n<=1) return n;
		return fibo(n-1) + fibo(n-2);
	}
}
