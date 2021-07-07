package drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import core.BaseLimitedDrawable;

public class Retangulo extends BaseLimitedDrawable {
	public final Rectangle RETANGULO;
	private boolean fill = false;
	private Color cor = Color.WHITE;
	
	public Retangulo(double maxX, double maxY) {
		super(maxX, maxY);
		RETANGULO = new Rectangle(
				(int) -maxX   + Circulo.SIZE, 
				(int) -maxY   + Circulo.SIZE, 
				(int)  maxX*2 - 2*Circulo.SIZE, 
				(int)  maxY*2 - 2*Circulo.SIZE
				);
	}
	public Retangulo(double maxX, double maxY, double w, double h, Color cor, boolean _fill) {
		super(maxX, maxY);
		RETANGULO = new Rectangle(
				(int) maxX, 
				(int) maxY, 
				(int) w, 
				(int) h
				);
		this.fill = _fill;
		this.cor = cor;
	}
	
	public boolean intersects(Shape shape) {
		return shape.intersects(RETANGULO);
	}
	
	@Override
	public void draw(Graphics2D g2d) { //Ellipse2D y = new Ellipse2D.Double(10, 10, 10, 10); g2d.draw(y);
		Color tmp = g2d.getColor();
		g2d.setColor(cor);
		if(fill) g2d.fill(RETANGULO);
		g2d.draw(RETANGULO); 
		g2d.setColor(tmp);
	}

	/*
	@Override
	public Rectangle getBounds() {
		return RETANGULO.getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		return RETANGULO.getBounds2D();
	}

	@Override
	public boolean contains(double x, double y) {
		return RETANGULO.contains(x, y);
	}

	@Override
	public boolean contains(Point2D p) {
		return RETANGULO.contains(p);
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return RETANGULO.intersects(x, y, w, h);
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		return RETANGULO.intersects(r);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		return RETANGULO.contains(x, y, w, h);
	}

	@Override
	public boolean contains(Rectangle2D r) {
		return RETANGULO.contains(r);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return RETANGULO.getPathIterator(at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return RETANGULO.getPathIterator(at, flatness);
	}
	*/
}
