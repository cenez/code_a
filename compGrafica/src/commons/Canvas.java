package commons;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.VolatileImage;

import geometrics.IDrawable;
import geometrics.IIncrementalDrawable;

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
		    	setImagemBuf(gframe.createVolatileImage(largura(), altura()));//new BufferedImage(largura(), altura(), BufferedImage.TYPE_INT_ARGB));
		    	setPaint(getImageBuf().createGraphics());
		    	adaptCartesianCoordinates(getPaint());
				clear();
				System.out.println(WIDTH+":"+HEIGHT);
		    }
		});
	}
	public void adaptCartesianCoordinates(Graphics2D g2d) {
		double xTrans = ((double)gframe.getWidth())/2.0;
		double yTrans = ((double)gframe.getHeight())/2.0;
		g2d.translate(xTrans, yTrans);
		g2d.scale(1, -1);
	}
	public void draw(IDrawable obj) { obj.draw(this.paint, halfLargura(), halfAltura()); }
	public void draw(IIncrementalDrawable obj) { obj.draw(this); }
	
	public void clear() {
		Graphics2D g2d = getPaint();
		g2d.setColor(Color.BLACK);
		g2d.clearRect(-1*((int)halfLargura()), -1*((int)halfAltura()), largura(), altura());
		g2d.fill(new Rectangle2D.Double(-1*halfLargura(),  -1*halfAltura(),  largura(),  altura()));
		g2d.setColor(Color.WHITE);
	}
	public void plot() { 
		Graphics g = this.gframe.getGraphics();
		g.drawImage(this.getImageBuf(), 0, 0, null);
		g.dispose(); //memory free
	}
	public int largura() { return WIDTH = this.gframe.getWidth(); }
	public int altura() { return HEIGHT = this.gframe.getHeight(); }
	public double halfLargura() { return this.gframe.getWidth()/2.0; }
	public double halfAltura() { return this.gframe.getHeight()/2.0; }
	public Graphics2D getPaint() {
		return paint;
	}
	public VolatileImage getImageBuf() {
		return imageBuf;
	}
	public void setPaint(Graphics2D _paint) {
		paint = _paint;
	}
	public void setImagemBuf(VolatileImage _imageBuf) {
		imageBuf = _imageBuf;
	}
}
