package snake.drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import core.BaseLimitedDrawable;
import drawables.Point;

/* Movimento
 * mvx diz o sentido que cobra segue na coordenada X do plano cartesiano
 * mvy diz o sentido que cobra segue na coordenada Y do plano cartesiano
 * mvx==0 ou mvy==0 diz que esse movimento é estável respectivamente para sentidos X e Y
 */
public class Snake extends BaseLimitedDrawable {
	private final Color corHead = Color.RED;
	private final Color corTail = Color.WHITE;
	private final Point head = new Point(0, 0);
	private final List<Point> tail = new ArrayList<>();
	
	private int fluxoX=-Point.SIZE, fluxoY=0; 
	
	public Snake(double xMax, double yMax) {
		super(xMax, yMax);
		for(int i = 1; i <= 4; i++)
			tail.add(new Point(Point.SIZE * i, 0));
	}
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
		if(head.X >    MAX_X) head.X = -1*MAX_X + Point.SIZE;
		if(head.X < -1*MAX_X) head.X =    MAX_X - Point.SIZE;
		if(head.Y >    MAX_Y) head.Y = -1*MAX_Y + Point.SIZE;
		if(head.Y < -1*MAX_Y) head.Y =    MAX_Y - Point.SIZE;
	}
	private void update() {
		for(int i = tail.size() - 1; i > 0; i--)
			tail.get(i).moveTO(tail.get(i - 1).X, tail.get(i - 1).Y);
		
		tail.get(0).moveTO(head.X, head.Y);
		head.moveIncremental(fluxoX, fluxoY);
		ring();
	}
	@Override
	public void draw(Graphics2D g2d) {
		update();
		
		g2d.setColor(corHead);
		head.draw(g2d);
		g2d.setColor(corTail);
		for (Point p : tail)
			p.draw(g2d);
	}
}

