package arvore_avl;

import java.awt.Color;
import java.awt.Graphics2D;

import geometrics.Point;

public class NO<E> extends Point{
	public E chave;
	public NO<E> esq;
	public NO<E> dir;
	public int h;
	public String msg = "";
	public NO(E key) {
		super(0,0);
	}
	public NO(E key, double _x, double _y) {
		super(_x,_y);
		this.chave = key;
	    this.esq   = null;
	    this.dir  = null;
	    this.h = 0;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalizou no " + this.chave.toString());
		super.finalize();
	}
	public double maxOntheLine() { 
		return potencia(2, this.h);
	}
	public int potencia(int x, int expoente){
	    int valor = x;
	    for(int i=0;i<expoente-1;i++)
	        x = valor*x;
	    if(expoente==0) return 1;
	    else return x;
	}
	@Override
	public String toString() {
		return this.chave.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof NO) {
			@SuppressWarnings("unchecked")
			NO<E> p = (NO<E>) obj;
			return this.x==p.x && this.y==p.y && this.chave.equals(p.chave);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return pairingFunction ((int)this.x, (int)this.y)+this.chave.hashCode(); 
	}
	@Override
	public void draw(Graphics2D g2d, double maxX, double maxY) {
		super.draw(g2d, maxX, maxY);
		
		if(this.esq!=null) g2d.drawLine((int)this.x, (int)this.y, (int)this.esq.x, (int)this.esq.y);
		if(this.dir!=null) g2d.drawLine((int)this.x, (int)this.y, (int)this.dir.x, (int)this.dir.y);
		
		
		g2d.setColor(Color.YELLOW);
		g2d.scale(1, -1);
		g2d.drawString(this.toString(), (int) this.x-15, -1*((int) this.y+15));
		g2d.scale(1, -1);
		g2d.setColor(Color.WHITE);
	}
}
