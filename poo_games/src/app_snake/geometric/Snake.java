package app_snake.geometric;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import geometrics.BaseLimitedDrawable;
import geometrics.Point;

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
	
	private int sentidoX=-Point.SIZE, sentidoY=0; 

	public Snake(double xMax, double yMax) {
		super(xMax, yMax);
		tail.add(new Point(Point.SIZE * 1, 0));
		tail.add(new Point(Point.SIZE * 2, 0));
	}
	public void up() {
		if(sentidoY == 0) {
			sentidoY = Point.SIZE;
			sentidoX = 0;
		} 
	}
	public void down() {
		if(sentidoY == 0) {
			sentidoY = -Point.SIZE;
			sentidoX = 0;
		} 
	}
	public void left() {
		if(sentidoX == 0) {
			sentidoY = 0;
			sentidoX = -Point.SIZE;
		} 
	}
	public void right() {
		if(sentidoX == 0) {
			sentidoY = 0;
			sentidoX = Point.SIZE;
		} 
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
		head.moveIncremental(sentidoX, sentidoY);
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

