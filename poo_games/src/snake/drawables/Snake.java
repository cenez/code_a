package snake.drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import core.BaseLimitedDrawable;
import drawables.Point;

public class Snake extends BaseLimitedDrawable {
	private final Color HEAD_COLOR = Color.RED;
	private final Point HEAD = new Point(0, 0);
	private final List<Point> TAIL = new ArrayList<>();
	
	private int fluxoX=-Point.SIZE, fluxoY=0; 
	
	public Snake(double xMax, double yMax) {
		super(xMax, yMax);
		for(int i = 1; i <= 4; i++)
			TAIL.add(new Point(Point.SIZE * i, 0));
	}
	public Point getHEAD() { return HEAD; }
	public void addToTail(Point p) { TAIL.add(p); }
	public void up() {
		if(fluxoY==0) {
			fluxoY = Point.SIZE;
			fluxoX = 0;
		} 
	}
	public void down() {
		if(fluxoY==0) {
			fluxoY = -Point.SIZE;
			fluxoX = 0;
		} 
	}
	public void left() {
		if(fluxoX==0) {
			fluxoY = 0;
			fluxoX = -Point.SIZE;
		} 
	}
	public void right() {
		if(fluxoX==0) {
			fluxoY = 0;
			fluxoX = Point.SIZE;
		} 
	}
	public void listenKey(KeyEvent e) { 
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_UP) 		this.up();
		else if(k == KeyEvent.VK_DOWN) 	this.down();
		else if(k == KeyEvent.VK_LEFT) 	this.left();
		else if(k == KeyEvent.VK_RIGHT) this.right();
	}
	public void update() {
		updateTail();
		updateHead();
	}
	private void updateHead() {
		HEAD.moveIncremental(fluxoX, fluxoY);
		if(Math.abs(HEAD.X)>this.MAX_X) HEAD.X = -HEAD.X;
		if(Math.abs(HEAD.Y)>this.MAX_Y) HEAD.Y = -HEAD.Y;
	}
	private void updateTail() {
		for(int i = TAIL.size() - 1; i > 0; i--)
			TAIL.get(i).moveTO(TAIL.get(i - 1).X, TAIL.get(i - 1).Y);
		TAIL.get(0).moveTO(HEAD.X, HEAD.Y);
	}
	@Override
	public void draw(Graphics2D g2d) {
		TAIL.forEach(p -> p.draw(g2d));
		Color cor = g2d.getColor();
		g2d.setColor(HEAD_COLOR);
		HEAD.draw(g2d);
		g2d.setColor(cor);
	}
}

/* Observação sobre Movimento:
 * fluxoX diz o sentido que cobra segue na coordenada X do plano cartesiano;
 * fluxoY diz o sentido que cobra segue na coordenada Y do plano cartesiano;
 * Em fluxoX==0 ou fluxoY==0 diz que esse movimento é estável, 
 * respectivamente para sentidos X e Y, não existindo movimento;
 * fluxoX ou fluxoY caminham ao passo +-Point.SIZE.
 */

