package drawables;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import core.IDrawable;

public class RetanguloImg implements IDrawable {
	public final Rectangle RETANGULO;
	private String file = "inverse_fundo1024.573.jpg";
	protected ImageObserver observer = null;
	private double X, Y, W, H;
	
	public RetanguloImg(double x, double y, ImageObserver o) {
		this.X = x;
		this.Y = y;
		this.W = x*2 - 2*Circulo.SIZE;
		this.H = y*2 - 2*Circulo.SIZE;
		RETANGULO = new Rectangle(
				(int) -x   + Circulo.SIZE,
				(int) -y   + Circulo.SIZE,
				(int)  this.W,
				(int)  this.H
				);
		
		this.observer = o;
		this.X = x; this.Y = y;
	}
	
	public boolean intersects(Shape shape) {
		return shape.intersects(RETANGULO);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		//g2d.draw(RETANGULO);
		Image img = new ImageIcon(this.getClass().getResource(file)).getImage();
		g2d.drawImage(img, (int)-this.X+Circulo.SIZE, (int)-this.Y+Circulo.SIZE, observer);
	}
}
