package drawables;

import java.awt.Color;
import java.awt.Graphics2D;

public class PacMan extends Circulo {
	private int startAngle = 0;
	private int arcAngle = 0;
	private boolean abrindo = false;
	private int speedOpen = 16;
	private static int[] quadrante = {20, 290, 210, 120}; //0+x, 1+y, 2-x, 3-y
	private Color frente = Color.WHITE; 
	
	public PacMan(double x, double y, Color fundo, Color frente) { 
		super(x, y, fundo); 
		dataSet(x, y, quadrante[2], 315); 
		this.frente = frente;
	} 
	public PacMan(double x, double y, Color fundo, Color frente, boolean _fill) { 
		this(x, y, fundo, frente); 
		this.fill = _fill; 
	} 
	private void dataSet(double _x, double _y, int _startAngle, int _arcAngle) { 
		this.X = _x;                   this.Y = _y; 
		this.startAngle = _startAngle; this.arcAngle = _arcAngle; 
	} 
	public void setQuad(int n) { 
		if(n>=0 && n<4) 
			this.startAngle = quadrante[n]; 
	} 
	@Override
	public void update() {
		super.update();
		if(abrindo) { 
			arcAngle +=speedOpen; 
			if((360-arcAngle)<=0) abrindo = !abrindo; 
		} else { 
			arcAngle -=speedOpen; 
			if((360-arcAngle)>=120) abrindo = !abrindo; 
		}
	}
	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		Color c = g2d.getColor();
		g2d.setColor(frente);
		g2d.fillArc((int) X, (int) Y, SIZE, SIZE, startAngle, arcAngle);
		g2d.setColor(c);
	}
}
