package ads;

public class Lista<T> {
	No<T> inicio = null;
	public void add(T item){
		if(this.inicio==null) {
			this.inicio = new No<T>();
			this.inicio.prox = new No<T>(item);
			return;
		}
		No<T> fim = this.inicio.prox;
		while(fim.prox!=null){	
			fim = fim.prox;
		}
		fim.prox = new No<T>(item);
	}
	public void imprime(){
		if(this.inicio==null) return;
		No<T> fim = this.inicio.prox;
		while(fim!=null){
			System.out.print(fim.chave+" ");
			fim = fim.prox;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Lista<String> lista = new Lista<String>();
		lista.add("joao");
		lista.add("maria");
		lista.add("ana");
		lista.imprime();
	}
}
