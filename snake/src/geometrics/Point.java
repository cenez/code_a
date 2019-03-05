package geometrics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Point implements IDrawable {
	protected double X, Y;
	public static final int SIZE = 7;
	
	public Point(double x, double y) { this.X = x; this.Y = y; }
	
	@Override
	public void draw(Graphics2D g2d, double maxX, double maxY) {
		draw(g2d, Color.WHITE);
	}
	public void draw(Graphics2D g2d, Color cor) {
		g2d.setColor(cor);
		g2d.fillOval((int) this.X, (int) this.Y, Point.SIZE, Point.SIZE);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point) obj;
			return this.X==p.X && this.Y==p.Y;
		}
		return false;
	}
	public void setXY(double _x, double _y) {
		this.X = _x;
		this.Y = _y;
	}
	public void move(double _x, double _y) {
		this.X += _x;
		this.Y += _y;
	}
}
