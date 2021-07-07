package drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class HeadSnakeImg extends Circulo {
	private final String[] files = {"head32_Right.png", "head32_Up.png", "head32_Left.png", "head32_Down.png"};
	private String file = files[2];
	protected ImageObserver observer = null;
	public HeadSnakeImg(double x, double y, ImageObserver o) { 
		super(x, y, Color.BLACK);
		observer = o;
	} 
	public void setQuad(int n) { 
		if(n>=0 && n<4) {
			file = files[n];
		}
	} 
	@Override
	public void draw(Graphics2D g2d) {
		//super.draw(g2d);
		Image img = new ImageIcon(this.getClass().getResource(file)).getImage();
		g2d.drawImage(img, (int)this.X, (int)this.Y, observer);
	}
}
