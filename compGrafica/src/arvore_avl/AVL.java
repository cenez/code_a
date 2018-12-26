package arvore_avl;

import java.util.ArrayList;
import java.util.List;

public class AVL<TKey extends Comparable<TKey>> {
	protected NO<TKey> root = null;
	protected int altura(NO<TKey> N) {
	    if (N == null)
	        return -1;
	    return N.h;
	}
	public int hTree() { return altura(root); }
	private int max(int a, int b){
	    return (a > b)? a : b;
	}
	private NO<TKey> dirRotate(NO<TKey> y) {
		TKey ch1 = y.chave;
		TKey ch2 = y.esq.chave;
	    NO<TKey> x = y.esq;
	    NO<TKey> T = x.dir;

	    x.dir = y;
	    y.esq = T;

	    y.h = max(altura(y.esq), altura(y.dir))+1;
	    x.h = max(altura(x.esq), altura(x.dir))+1;

	    System.out.format("dirRotate: %s:%s\n",ch1.toString(),ch2.toString());
	    return x;
	}
	private NO<TKey> esqRotate(NO<TKey> x) {
		TKey ch1 = x.chave;
		TKey ch2 = x.dir.chave;
	    NO<TKey> y = x.dir;
	    NO<TKey> T = y.esq;

	    y.esq = x;
	    x.dir = T;

	    x.h = max(altura(x.esq), altura(x.dir))+1;
	    y.h = max(altura(y.esq), altura(y.dir))+1;

		System.out.format("esqRotate: %s:%s\n", ch1.toString(),ch2.toString());
	    return y;
	}
	private int getBalance(NO<TKey> N) {
	    if (N == null)
	        return 0;
	    return altura(N.esq) - altura(N.dir);
	}
	public void add(TKey chave){ root = insert(root, chave); }
	private NO<TKey> insert(NO<TKey> raiz, TKey chave) {
	    if (raiz == null)
	        return new NO<TKey>(chave, 0, 0);
	    if (raiz.chave.compareTo(chave) > 0 )
	        raiz.esq  = insert(raiz.esq, chave);
	    else if (raiz.chave.compareTo(chave) < 0)
	        raiz.dir = insert(raiz.dir, chave);
	    else
	        return raiz;
	    raiz.h = 1 + max(altura(raiz.esq), altura(raiz.dir));
	    int balance = getBalance(raiz);
	    if (balance > 1 && raiz.esq.chave.compareTo(chave) > 0)
	        return dirRotate(raiz);

	    if (balance < -1 && raiz.dir.chave.compareTo(chave) < 0)
	        return esqRotate(raiz);

	    if (balance > 1 && raiz.esq.chave.compareTo(chave) < 0) {
	        raiz.esq =  esqRotate(raiz.esq);
	        return dirRotate(raiz);
	    }
	    if (balance < -1 && raiz.dir.chave.compareTo(chave) > 0) {
	        raiz.dir = dirRotate(raiz.dir);
	        return esqRotate(raiz);
	    }
	    return raiz;
	}
	private NO<TKey> maxValueNO(NO<TKey> node) {
		NO<TKey> current = node;
		while (current.dir != null)
			current = current.dir;
		return current;
	}
	public void delete(TKey chave){ root = deleteNO(root, chave); }
	private NO<TKey> deleteNO(NO<TKey> raiz, TKey chave) {
	    if (raiz == null)
	        return raiz;

	    if ( raiz.chave.compareTo(chave) > 0 )
	        raiz.esq = deleteNO(raiz.esq, chave);

	    else if(raiz.chave.compareTo(chave) < 0 )
	        raiz.dir = deleteNO(raiz.dir, chave);

	    else {
	        if( (raiz.esq == null) || (raiz.dir == null) ) {
	            NO<TKey> temp = raiz.esq!=null ? raiz.esq : raiz.dir;

	            if (temp == null) {
	                temp = raiz;
	                raiz = null;
	            }
	            else
	             raiz = temp;
	        }
	        else {
				NO<TKey> temp = maxValueNO(raiz.esq);
	            raiz.chave = temp.chave;
	            raiz.esq = deleteNO(raiz.esq, temp.chave);
	        }
	    }
	    if (raiz == null)
	      return raiz;

	    raiz.h = 1 + max(altura(raiz.esq), altura(raiz.dir));
	    int balance = getBalance(raiz);

	    if (balance > 1 && getBalance(raiz.esq) >= 0)
	        return dirRotate(raiz);

	    if (balance > 1 && getBalance(raiz.esq) < 0) {
	        raiz.esq =  esqRotate(raiz.esq);
	        return dirRotate(raiz);
	    }

	    if (balance < -1 && getBalance(raiz.dir) <= 0)
	        return esqRotate(raiz);

	    if (balance < -1 && getBalance(raiz.dir) > 0){
	        raiz.dir = dirRotate(raiz.dir);
	        return esqRotate(raiz);
	    }
	    return raiz;
	}
	public boolean avl(){ return avl_verify(root); }
	private boolean avl_verify(NO<TKey> raiz) {
		boolean isAVL = true;
		if (raiz != null) {
			int fb = getBalance(raiz);

			isAVL = (fb == 0 || (Math.abs(fb) == 1 && avl_verify(raiz.esq) && avl_verify(raiz.dir)));
		}
		return isAVL;
	}
	public void print() {
		if(root==null) return;
		List<NO<TKey>> nodes = new ArrayList<>();
		orderByKey(root, nodes);
		for (NO<TKey> no : nodes) {
			System.out.print(no.toString()+" ");			
		}
		System.out.println();
	}
	private void orderByKey(NO<TKey> r, List<NO<TKey>> nodes) {
		if(r!=null) {
			orderByKey(r.esq, nodes);
			nodes.add(r);
			orderByKey(r.dir, nodes);
		}
	}
	public List<NO<TKey>> dados(double lenX, double lenY) {
		List<NO<TKey>> nodes = new ArrayList<>();
		if(root==null) return nodes;
		setXY(lenX, lenY);
		orderByKey(root, nodes);
		return nodes;
	}	
	public void setXY(double lenX, double lenY) {
		setXY(root, 0, lenY/2.0 - 40, lenX/2.0, 1);
	}
	private void setXY(NO<TKey> no, double X,     double Y,          double metade, int nivel) {
		if(no!=null) {
			no.x = X;
			no.y = Y;
			metade = metade/2.0;
			if(hTree()>0) {
				setXY(no.esq, X-metade, Y-40, metade, nivel+1);
				setXY(no.dir, X+metade, Y-40, metade, nivel+1);
			}
		}
	}
	public double count(NO<TKey> raiz){
		if(raiz==null) return 0.0;
		return count(raiz.esq)+1.0+count(raiz.dir);
	}
}
