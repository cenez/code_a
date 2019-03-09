package geometrics;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;

public class Star implements IDrawable {
	public void draw(Graphics2D g2d, double maxX, double maxY) {
		for(int i = 0; i< 20; i++) {
			Random r = new Random();
			int x = r.nextInt()%((int)maxX);
			int y = r.nextInt()%((int)maxY);
	
			g2d.draw(createStar(5, x, y, 1, 4));
		}
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
}
