package app_snake.geometric;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import commons.Tela;
import geometrics.IDrawable;
import geometrics.Point;

public class Snake implements IDrawable {
	private final Color corHead = Color.RED;
	private final Color corTail = Color.WHITE;
	private final Point head = new Point(0, 0);
	private final List<Point> tail = new ArrayList<>();
	
	/* Movimento
	 * mvx diz o sentido que cobra segue na coordenada X do plano cartesiano
	 * mvy diz o sentido que cobra segue na coordenada Y do plano cartesiano
	 * mvx==0 ou mvy==0 diz que esse movimento é estável respectivamente para sentidos X e Y
	 */
	private int mvx=-Point.SIZE, mvy=0; 

	public Snake() {
		tail.add(new Point(Point.SIZE * 1, 0));
		tail.add(new Point(Point.SIZE * 2, 0));
	}
	public void up() {
		if(this.mvy == 0) {
			this.mvy = Point.SIZE;
			this.mvx = 0;
		} 
		update();
	}
	public void down() {
		if(this.mvy == 0) {
			this.mvy = -Point.SIZE;
			this.mvx = 0;
		} 
		update();
	}
	public void left() {
		if(this.mvx == 0) {
			this.mvy = 0;
			this.mvx = -Point.SIZE;
		} 
		update();
	}
	public void right() {
		if(this.mvx == 0) {
			this.mvy = 0;
			this.mvx = Point.SIZE;
		} 
		update();
	}
	private void update() {
		for(int i = this.tail.size() - 1; i > 0; i--) {
			this.tail.get(i).setXY(this.tail.get(i - 1).X, this.tail.get(i - 1).Y);
		}
		this.tail.get(0).setXY(this.head.X, this.head.Y);
		this.head.move(this.mvx, this.mvy);
		this.outBound();
	}
	private void outBound() {
		if(this.head.X>Tela.WIDTH/2.0) this.head.X = -1*Tela.WIDTH/2.0 + Point.SIZE;
		if(this.head.X<-1*Tela.WIDTH/2.0) this.head.X = Tela.WIDTH/2.0 - Point.SIZE;
		if(this.head.Y>Tela.HEIGHT/2.0) this.head.Y = -1*Tela.HEIGHT/2.0 + Point.SIZE;
		if(this.head.Y<-1*Tela.HEIGHT/2.0) this.head.Y = Tela.HEIGHT/2.0 - Point.SIZE;
	}
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(corHead);
		head.draw(g2d);
		g2d.setColor(corTail);
		for (Point p : tail)
			p.draw(g2d);
	}
}
