package core;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.VolatileImage;

public class Canvas {
	public static int WIDTH;
	public static int HEIGHT;
	
	private Graphics2D paint; 
	private VolatileImage imageBuf; 
	private Component gframe;
	
	public Canvas(Component _gframe) {
		this.gframe = _gframe;
		_gframe.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	imageBuf = gframe.createVolatileImage(width(), height());
		    	paint = imageBuf.createGraphics();
		    	adaptCartesianCoordinates(getPaint());
				clear();
				System.out.println(WIDTH+":"+HEIGHT);
		    }
		});
	}
	private void adaptCartesianCoordinates(Graphics2D g2d) {
		double xTrans = ((double)gframe.getWidth())/2.0;
		double yTrans = ((double)gframe.getHeight())/2.0;
		g2d.translate(xTrans, yTrans);
		g2d.scale(1, -1);
	}
	public void draw(IDrawable obj) { obj.draw(this.paint); }//, halfWidth(), halfHeight()); }
	
	public void clear() {
		paint.setColor(Color.BLACK);
		paint.clearRect(-1*((int)halfWidth()), -1*((int)halfHeight()), width(), height());
		paint.fill(new Rectangle2D.Double(-1*halfWidth(),  -1*halfHeight(),  width(),  height()));
		paint.setColor(Color.WHITE);
	}
	public void plot() { 
		Graphics g = this.gframe.getGraphics();
		g.drawImage(imageBuf, 0, 0, null);
		g.dispose(); //memory free
	}
	public int width() { return WIDTH = this.gframe.getWidth(); }
	public int height() { return HEIGHT = this.gframe.getHeight(); }
	public double halfWidth() { return this.gframe.getWidth()/2.0; }
	public double halfHeight() { return this.gframe.getHeight()/2.0; }
	public Graphics2D getPaint() {
		return paint;
	}
}
