package plano2d.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Point {
	private final int LEFT = -1, RIGHT = 1, ON_THE_LINE = 0;
	public double x, y;
	public static final int SIZE = 7;
	
	public Point(double x, double y) { this.x = x; this.y = y; }

	public boolean minYXCompareTo(Point b) {
        if (this.y != b.y)
            return this.y < b.y;
        return this.x < b.x;
    }
	public boolean minXYCompareTo(Point b) {
        if (this.x != b.x)
            return this.x < b.x;
        return this.y < b.y;
    }
	
	// retorna -1 se a -> b -> c for um giro no sentido anti-horário,
	// +1 para um giro no sentido horário, 0 se forem colineares
	public int ccw(Point b, Point c) {
	    double area = (b.x - this.x) * (c.y - this.y) - (b.y - this.y) * (c.x - this.x);
	    if (area > 0)
	        return LEFT;
	    else if (area < 0)
	        return RIGHT;
	    return ON_THE_LINE;
	}

	// retorna quadrado de distância euclidiana entre dois pontos
	public double sqrDist(Point b)  {
	    double dx = this.x - b.x, dy = this.y - b.y;
	    return dx * dx + dy * dy;
	}

	/* 
	 * É preciso que algum polo (this) chame este método
	 * Se a < b em relacao ao polo, o método retorna true
	*/
	public boolean polarOrder(Point b, Point c)  {
	    int order = this.ccw(b, c);
	    if (order == ON_THE_LINE)
	        return sqrDist(b) < sqrDist(c);
	    return (order == LEFT);
	}
    
	public double getX() { return x; }
	public double getY() { return y; }
	
	public void draw(Graphics2D g2d, Color cor) {
		g2d.setColor(cor);
		g2d.fillOval((int) this.x, (int) this.y, Point.SIZE, Point.SIZE);
	}
	public void drawLineTo(Graphics2D g2d, Point b, Color cor) {
		g2d.setColor(cor);
		g2d.draw(new Line2D.Double(x, y, b.x, b.y));
	}
	public void removeLineTo(Graphics2D g2d, Point b) {
		g2d.setColor(Color.BLACK);
		g2d.draw(new Line2D.Double(
				x, y, 
				b.x+x, b.y+y));
	}
	@Override
	public String toString() {
		return "["+x+","+y+"]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point) obj;
			return this.x==p.x && this.y==p.y;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return pairingFunction ((int)this.x, (int)this.y); 
	}
	public static int pairingFunction (int a, int b) {
		long A = (long)(a >= 0 ? 2 * (long)a : -2 * (long)a - 1);
		long B = (long)(b >= 0 ? 2 * (long)b : -2 * (long)b - 1);
		long C = (long)((A >= B ? A * A + A + B : A + B * B) / 2);
		long R = a < 0 && b < 0 || a >= 0 && b >= 0 ? C : -C - 1;
		return (int)R;
	}
}
