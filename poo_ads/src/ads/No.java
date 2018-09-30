package ads;

public class No<T> {
	public T chave = null;
	public No<T> prox = null;
	public No(){}
	public No(T t){
		this.chave = t;
	}
}
