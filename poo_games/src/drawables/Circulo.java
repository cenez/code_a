package drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import core.IDrawable;

public class Circulo implements IDrawable {
	public double X, Y;
	public static final int SIZE = 24;
	public Ellipse2D CIRCULO;
	protected boolean fill = true;
	private Color cor;
	
	public Circulo(double x, double y, Color cor) { 
		this.X = x; 
		this.Y = y; 
		this.cor = cor; 
		update(); 
	} 
	
	public void moveTO(double _x, double _y) {
		this.X = _x;
		this.Y = _y;
		update();
	}
	public void moveIncremental(double _x, double _y) {
		this.X += _x;
		this.Y += _y;
		update();
	}
	public void update() {
		CIRCULO = new Ellipse2D.Double(X, Y, SIZE, SIZE); 
	}
	
	public boolean intersects(Shape shape) {
		return shape.intersects(X, Y, SIZE, SIZE);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circulo) {
			Circulo c = (Circulo) obj;
			return c.CIRCULO.intersects(X, Y, SIZE, SIZE);
		}
		return false;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		Color c = g2d.getColor();
		g2d.setColor(cor);
		if(fill) g2d.fill(CIRCULO);
		g2d.draw(CIRCULO);
		g2d.setColor(c);
	}

	/*
	@Override
	public Rectangle getBounds() {
		return CIRCULO.getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		return CIRCULO.getBounds2D();
	}

	@Override
	public boolean contains(double x, double y) {
		return CIRCULO.contains(x, y);
	}

	@Override
	public boolean contains(Point2D p) {
		return CIRCULO.contains(p);
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return CIRCULO.intersects(x, y, w, h);
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		return CIRCULO.intersects(r);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		return CIRCULO.contains(x, y, w, h);
	}

	@Override
	public boolean contains(Rectangle2D r) {
		return CIRCULO.contains(r);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return CIRCULO.getPathIterator(at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return CIRCULO.getPathIterator(at, flatness);
	}
	*/
}
