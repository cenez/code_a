package drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class BodySnakeImg extends Circulo {
	private final String[] files = {"tail32_Right.png","tail32_Up.png", "tail32_Left.png", "tail32_Down.png", "body32.png"};
	private String file = files[4];
	protected ImageObserver observer = null;
	public int QUADRANTE;
	public BodySnakeImg(double x, double y, ImageObserver o) { 
		super(x, y, Color.BLACK);
		observer = o;
	} 
	public void setQuad(int n) {
		if(n>=0 && n<4)
			file = files[n];
		else file = files[4];
	}
	@Override
	public void draw(Graphics2D g2d) {
		Image img = new ImageIcon(this.getClass().getResource(file)).getImage();
		g2d.drawImage(img, (int)this.X, (int)this.Y, observer);
	}
}
