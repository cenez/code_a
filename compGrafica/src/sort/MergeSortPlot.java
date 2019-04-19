package sort;

import java.awt.Color;
import java.awt.Graphics2D;

import commons.Tela;
import geometrics.IIncrementalDrawable;
import geometrics.Point;

public class MergeSortPlot implements IIncrementalDrawable {
	private Point polo;
	private Point[] points = new Point[0];
	private int sleep = 0;

	public void setPoints(Point[] points, int _sleep) {
		this.sleep = _sleep;
		this.points = points;
	}


	public void draw(Tela tela) {
		draw(tela, tela.getPINTOR(), tela.halfLargura(), tela.halfAltura());
	}

	public void draw(Graphics2D g2d, double maxX, double maxY) {
		draw(null, g2d, maxX, maxY);
	}

	private void draw(Tela tela, Graphics2D g2d, double maxX, double maxY) {
		int min = 0;
		int max = 0;
		for (int i = 0; i < points.length; i++)
			if (points[i].x < points[min].x)
				min = i;
		for (int i = 0; i < points.length; i++)
			if (points[i].x > points[max].x)
				max = i;
		polo = trocar(points, min, 0);
		polo.y = 0;
		points[max].y = 0;
		drawPointsAndInitialLines(g2d);
		sort(tela, g2d, points, 1, points.length-1);
	}

	private void apontaRED_WHITE(Tela tela, Graphics2D g2d, Point a, Point b, Color c) {
		a.drawLineTo(g2d, b, Color.RED);
		tela.plot();
		if(sleep>0)
			try { Thread.sleep(sleep); } catch (InterruptedException e) { e.printStackTrace(); }
		a.drawLineTo(g2d, b, Color.BLACK);
		drawPointsAndInitialLines(g2d);
		a.draw(g2d, Color.BLACK);
		a.y = 0;
		a.draw(g2d, Color.GREEN);
	}
	private Point trocar(Point[] A, int j, int menor) {
		Point tmp = A[j];
		A[j] = A[menor];
		A[menor] = tmp;
		return A[menor];
	}

	private void drawPointsAndInitialLines(Graphics2D g2d) {
		for (Point p : points) {
			if ((p.x == polo.x && p.y == polo.y))
				p.draw(g2d, Color.GREEN);
			else
				p.draw(g2d, Color.WHITE);
		}
	}
	private void sort(Tela tela, Graphics2D g2d, Point[] A, int p, int r){
		if(p<r){
			int q = (int)((p+r)/2);
			sort(tela, g2d, A,p,q); 
			sort(tela, g2d, A,q+1,r);
			merge(tela, g2d, A,p,q,r); 
		}
	}
	private void merge(Tela tela, Graphics2D g2d, Point[] A, int p, int q, int r){
		int n1 = q-p+1; 
		int n2 = r-q; 
		Point[] L = new Point[n1+2]; 
		Point[] R = new Point[n2+2]; 
		for(int i=1;i<=n1;i++) { L[i] = A[p+i-1]; } 
		for(int j=1;j<=n2;j++) { R[j] = A[q+j]; } 
		L[n1+1] = new Point(5, Integer.MAX_VALUE/2, 0); 
		R[n2+1] = new Point(5, Integer.MAX_VALUE/2,0); 
		int i = 1; 
		int j = 1; 
		for(int k=p;k<=r;k++){
			Point tmp = null;
			if (L[i].x<=R[j].x){ 
				polo = L[i];
				tmp = R[j];
				A[k] = L[i]; 
				i = i + 1; 
			} else { 
				polo = R[j];
				tmp = L[i];
				A[k] = R[j]; 
				j = j + 1; 
			}
			apontaRED_WHITE(tela, g2d, polo, tmp, Color.GREEN);
		} 
	}
}
