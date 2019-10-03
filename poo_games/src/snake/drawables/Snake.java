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
	private final Color TAIL_COLOR = Color.WHITE;
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
	public void move(KeyEvent e) { 
		int k = e.getKeyCode();
		
		if(k == KeyEvent.VK_UP) 		this.up();
		else if(k == KeyEvent.VK_DOWN) 	this.down();
		else if(k == KeyEvent.VK_LEFT) 	this.left();
		else if(k == KeyEvent.VK_RIGHT) this.right();
	}
	private void ring() {
		if(HEAD.X >    MAX_X) HEAD.X = -1*MAX_X + Point.SIZE;
		if(HEAD.X < -1*MAX_X) HEAD.X =    MAX_X - Point.SIZE;
		if(HEAD.Y >    MAX_Y) HEAD.Y = -1*MAX_Y + Point.SIZE;
		if(HEAD.Y < -1*MAX_Y) HEAD.Y =    MAX_Y - Point.SIZE;
	}
	@Override
	public void draw(Graphics2D g2d) {
		Color corDoPincel = g2d.getColor();
		g2d.setColor(TAIL_COLOR);
		
		for(int i = TAIL.size() - 1; i > 0; i--) {
			TAIL.get(i).moveTO(TAIL.get(i - 1).X, TAIL.get(i - 1).Y);
			TAIL.get(i).draw(g2d);
		}
		TAIL.get(0).moveTO(HEAD.X, HEAD.Y);
		TAIL.get(0).draw(g2d);
		
		HEAD.moveIncremental(fluxoX, fluxoY);
		ring();
		g2d.setColor(HEAD_COLOR);
		HEAD.draw(g2d);
		g2d.setColor(corDoPincel);
	}
}

/* Observação sobre Movimento:
 * fluxoX diz o sentido que cobra segue na coordenada X do plano cartesiano;
 * fluxoY diz o sentido que cobra segue na coordenada Y do plano cartesiano;
 * Em fluxoX==0 ou fluxoY==0 diz que esse movimento é estável, 
 * respectivamente para sentidos X e Y, não existindo movimento;
 * fluxoX ou fluxoY caminham ao passo +-Point.SIZE.
 */

