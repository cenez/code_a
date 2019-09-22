package core;

import java.awt.Graphics2D;

public interface IDrawable {
	/*
	 * maxX e maxY podem ser limites + no plano cartesiano
	 * -maxX e -maxY podem ser limites - no plano cartesiano
	 */
	void draw(Graphics2D g2d);//, double maxX, double maxY);
}
