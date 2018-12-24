package fecho.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.VolatileImage;

import fecho.common.IDrawable;
import fecho.common.IIncrementalDrawable;

public class Tela {
	public static int WIDTH;
	public static int HEIGHT;
	
	private Graphics2D PINTOR;
	private VolatileImage IMAGEM_BUF; 
	private Component CONTAINER;
	
	public Tela(Component container) {
		this.CONTAINER = container;
		container.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	setIMAGEM_BUF(CONTAINER.createVolatileImage(largura(), altura()));//new BufferedImage(largura(), altura(), BufferedImage.TYPE_INT_ARGB));
		    	setPINTOR(getIMAGEM_BUF().createGraphics());
		    	adaptCartesianCoordinates(getPINTOR());
				clear();
				System.out.println(WIDTH+":"+HEIGHT);
		    }
		});
	}
	public void adaptCartesianCoordinates(Graphics2D g2d) {
		double xTrans = ((double)CONTAINER.getWidth())/2.0;
		double yTrans = ((double)CONTAINER.getHeight())/2.0;
		g2d.translate(xTrans, yTrans);
		g2d.scale(1, -1);
	}
	public void draw(IDrawable obj) { obj.draw(this.PINTOR, halfLargura(), halfAltura()); }
	public void draw(IIncrementalDrawable obj) { obj.draw(this); }
	
	public void clear() {
		Graphics2D g2d = getPINTOR();
		g2d.setColor(Color.BLACK);
		g2d.clearRect(-1*((int)halfLargura()), -1*((int)halfAltura()), largura(), altura());
		g2d.fill(new Rectangle2D.Double(-1*halfLargura(),  -1*halfAltura(),  largura(),  altura()));
		g2d.setColor(Color.WHITE);
	}
	public void plot() { 
		Graphics g = this.CONTAINER.getGraphics();
		g.drawImage(this.getIMAGEM_BUF(), 0, 0, null);
		g.dispose(); //memory free
	}
	public int largura() { return WIDTH = this.CONTAINER.getWidth(); }
	public int altura() { return HEIGHT = this.CONTAINER.getHeight(); }
	public double halfLargura() { return this.CONTAINER.getWidth()/2.0; }
	public double halfAltura() { return this.CONTAINER.getHeight()/2.0; }
	public Graphics2D getPINTOR() {
		return PINTOR;
	}
	public VolatileImage getIMAGEM_BUF() {
		return IMAGEM_BUF;
	}
	public void setPINTOR(Graphics2D pINTOR) {
		PINTOR = pINTOR;
	}
	public void setIMAGEM_BUF(VolatileImage iMAGEM_BUF) {
		IMAGEM_BUF = iMAGEM_BUF;
	}
}
