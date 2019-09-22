package drawables;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

import core.BaseLimitedDrawable;

public class Star extends BaseLimitedDrawable {
	public Star(double maxX, double maxY) {
		super(maxX, maxY);
	}
	public static Shape createStar(int num_pontas, int x, int y, double raioOut, double raioIn) {
	    double angle = Math.PI / num_pontas;

	    GeneralPath path = new GeneralPath();

	    for (int i = 0; i < 2 * num_pontas; i++) {
	        double r = (i & 1) == 0 ? raioOut : raioIn;
	        Point2D.Double p = new Point2D.Double(
	            x + Math.cos(i * angle) * r, 
	            y + Math.sin(i * angle) * r);
	        if (i == 0) {
	            path.moveTo(p.getX(), p.getY());
	        }
	        else {
	            path.lineTo(p.getX(), p.getY());
	        }
	    }
	    path.closePath();
	    return path;
	}
	@Override
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< 20; i++) {
			Random r = new Random();
			int x = r.nextInt()%((int)this.MAX_X);
			int y = r.nextInt()%((int)this.MAX_Y);
			
			g2d.draw(createStar(5, x, y, 1, 4));
		}
	}
}