package snake.drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import core.ADrawableLimited;
import drawables.Point; 

public class SnakeOLD extends ADrawableLimited {
	private final Color HEAD_COLOR = Color.RED;
	private final Point HEAD;// = new Point(0, 0);
	private final List<Point> TAIL = new ArrayList<>();
	
	private int fluxoX=-Point.SIZE, fluxoY=0; 
	
	public SnakeOLD(double xMax, double yMax) {
		super(xMax, yMax);
		HEAD = new Point((MAX_X-Point.SIZE*2), (MAX_Y-Point.SIZE*2));
		for(int i = 1; i <= 4; i++)
			TAIL.add(new Point(Point.SIZE * i, 0));
		TAIL.get(0).moveTO(HEAD.X, HEAD.Y);
		for(int i = 1; i < TAIL.size(); i++)
			TAIL.get(i).moveTO(TAIL.get(i - 1).X, TAIL.get(i - 1).Y);
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
//		HEAD.moveIncremental(fluxoX, fluxoY);
//		if(Math.abs(HEAD.X)>this.MAX_X) HEAD.X = -HEAD.X;
//		if(Math.abs(HEAD.Y)>this.MAX_Y) HEAD.Y = -HEAD.Y;
		
		HEAD.moveIncremental(fluxoX, fluxoY);
		if(HEAD.X+Point.SIZE*2>MAX_X) HEAD.X = -(MAX_X)+Point.SIZE;
		else if(HEAD.X-Point.SIZE<-MAX_X) HEAD.X = (MAX_X-Point.SIZE*2);
		else if(HEAD.Y+Point.SIZE*2>MAX_Y) HEAD.Y = -(MAX_Y)+Point.SIZE;
		else if(HEAD.Y-Point.SIZE<-MAX_Y) HEAD.Y = (MAX_Y-Point.SIZE*2);
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

/* Observacao sobre Movimento:
 * fluxoX diz o sentido que cobra segue na coordenada X do plano cartesiano;
 * fluxoY diz o sentido que cobra segue na coordenada Y do plano cartesiano;
 * Em fluxoX==0 ou fluxoY==0 diz que esse movimento e estavel, 
 * respectivamente para sentidos X e Y, nao existindo movimento;
 * fluxoX ou fluxoY caminham ao passo +-Point.SIZE.
 */

