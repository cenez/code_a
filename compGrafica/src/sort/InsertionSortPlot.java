package sort;

import java.awt.Color;
import java.awt.Graphics2D;

import commons.Canvas;
import geometrics.IIncrementalDrawable;
import geometrics.Point;

public class InsertionSortPlot implements IIncrementalDrawable {
	private Point polo;
	private Point[] points = new Point[0];
	private int sleep = 0;

	public void setPoints(Point[] points, int _sleep) {
		this.sleep = _sleep;
		this.points = points;
	}

	public void draw(Canvas tela) {
		draw(tela, tela.getPaint(), tela.halfLargura(), tela.halfAltura());
	}

	public void draw(Graphics2D g2d, double maxX, double maxY) {
		draw(null, g2d, maxX, maxY);
	}

	private void draw(Canvas tela, Graphics2D g2d, double maxX, double maxY) {
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
		sort(tela, g2d, points, points.length-1);
	}
	private void sort(Canvas tela, Graphics2D g2d, Point[] A, int n) {
		for (int j = 1; j <= n; j++) {
			Point chave = A[j];
			int i = j - 1;
			while (i >= 0 && !A[i].minXYCompareTo(chave)) {// > chave) {
				apontaRED_WHITE(tela, g2d, chave, A[i], Color.RED);
				A[i + 1] = A[i];
				i = i - 1;
			}
			apontaRED_BLACK_CHANGE(tela, g2d, chave, Color.GREEN);
			A[i + 1] = chave;
		}
	}

	private void apontaRED_WHITE(Canvas tela, Graphics2D g2d, Point a, Point b, Color c) {
		a.drawLineTo(g2d, b, c);
		tela.plot();
		if(sleep>0)
			try { Thread.sleep(sleep); } catch (InterruptedException e) { e.printStackTrace(); }
		a.drawLineTo(g2d, b, Color.BLACK);
		
	}

	private void apontaRED_BLACK_CHANGE(Canvas tela, Graphics2D g2d, Point p, Color c) {
		p.draw(g2d, Color.BLACK);
		p.y = 0;
		p.draw(g2d, c);
		polo = p;
		drawPointsAndInitialLines(g2d);
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
}
