package fecho;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Stack;

import commons.Canvas;
import geometrics.IIncrementalDrawable;
import geometrics.Point;
import util.SortPoint;

public class Graham implements IIncrementalDrawable {
	private int sleep = 10;
	private Point polo;
	private Point[] points = new Point[0];
	
	public void setPoints(Point[] points) { this.points = points; }
	
	public void draw(Canvas tela) { draw(tela, tela.getPaint(), tela.halfLargura(), tela.halfAltura()); }
	
	public void draw(Graphics2D g2d, double maxX, double maxY) { draw(null, g2d, maxX, maxY); }
	
	private void draw(Canvas tela, Graphics2D g2d, double maxX, double maxY) {
		Stack<Point> fecho = new Stack<Point>(); //cnz
		int minYX = 0;
		
	    if (points.length < 3) return;
	    
	    // Encontre o ponto com a menor coordenada y (pivot)
	    // Se Ys iguais, pega-se o que tem menor x
	    for (int i = 1; i < points.length; i++)
	        if (points[i].minYXCompareTo(points[minYX]))
	            minYX = i;
	    
	    // troca o pivô polo com o primeiro ponto
	    Point tmp = points[0];
	    polo = points[0] = points[minYX];
	    points[minYX] = tmp;
	    
	    //ordena restante pela ordem polar em relacao ao pivot (polo)
	    SortPoint.SORT(polo, points, 1, points.length-1);

	    fecho.push(points[0]); fecho.push(points[1]); fecho.push(points[2]);
	    
	    drawPointsAndInitialLines(g2d);
	    
	    for (int i = 3; i < points.length; i++) {
	        Point topo = fecho.pop();
	        while (fecho.size()>0 && (fecho.lastElement().ccw(topo, points[i]) != -1))   {
	        	fecho.lastElement().drawLineTo(g2d, topo, Color.BLACK);
	        	topo.draw(g2d, Color.PINK);
	        	
	        	topo.drawLineTo(g2d, points[i], Color.RED);
	        	if(tela!=null) tela.plot();
	        	try { Thread.sleep(sleep); } catch (InterruptedException e) { e.printStackTrace(); }
	        	topo.drawLineTo(g2d, points[i], Color.BLACK);
	            
	        	topo = fecho.pop();
	        }
	        
	        topo.drawLineTo(g2d, points[i], Color.WHITE);
	        topo.draw(g2d, Color.GREEN);
	        points[i].draw(g2d, Color.GREEN);
	        
	        if(tela!=null) tela.plot();
	        
	        try { Thread.sleep(sleep); } catch (InterruptedException e) { e.printStackTrace(); }
	        
	        fecho.push(topo);
	        fecho.push(points[i]);
	    }
	    fecho.lastElement().drawLineTo(g2d, polo, Color.RED);
	    if(tela!=null) tela.plot();
	}
	
	/*
	 * Pintando os pontos e linhas iniciais na tela
	 */
	private void drawPointsAndInitialLines(Graphics2D g2d) {
		    for (Point p : points) {
		    	if((p.x==polo.x && p.y==polo.y))
		    		p.draw(g2d, Color.RED);
		    	else
					p.draw(g2d, Color.WHITE);
			}
		    polo.drawLineTo(g2d, points[1], Color.GREEN);
		    points[1].drawLineTo(g2d, points[2], Color.BLUE);
		    points[1].draw(g2d, Color.GREEN);
		    points[2].draw(g2d, Color.GREEN);
	}
}
