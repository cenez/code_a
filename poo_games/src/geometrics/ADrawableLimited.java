package geometrics;

import java.awt.Graphics2D;

public abstract class ADrawableLimited implements IDrawable {
	private final double MAX_X;
	private final double MAX_Y;
	
	public ADrawableLimited(double maxX, double maxY) {
		this.MAX_X = maxX;
		this.MAX_Y = maxY;
	}
	@Override
	public void draw(Graphics2D g2d) {
		this.draw(g2d, MAX_X, MAX_Y);
	}
	abstract void draw(Graphics2D g2d, double maxX, double maxY);
}
