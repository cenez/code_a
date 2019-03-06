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
	private boolean _die = false;
	
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
	public boolean up() {
		if(this.mvy == 0) {
			this.mvy = Point.SIZE;
			this.mvx = 0;
		} 
		if(this.mvy > 0) return update();
		return false;
	}
	public boolean down() {
		if(this.mvy == 0) {
			this.mvy = -Point.SIZE;
			this.mvx = 0;
		} 
		if(this.mvy < 0) return update();
		return false;
	}
	public boolean left() {
		if(this.mvx == 0) {
			this.mvy = 0;
			this.mvx = -Point.SIZE;
		} 
		if(this.mvx < 0) return update();
		return false;
	}
	public boolean right() {
		if(this.mvx == 0 && this.mvy != 0) {
			this.mvy = 0;
			this.mvx = Point.SIZE;
		} 
		if(this.mvx > 0) return update();
		return false;
	}
	private boolean update() {
		if(!this._die) { //if(this.mvx != 0 || this.mvy !=0) { 
			for(int i = this.tail.size() - 1; i > 0; i--) {
				this.tail.get(i).setXY(this.tail.get(i - 1).X, this.tail.get(i - 1).Y);
			}
			this.tail.get(0).setXY(this.head.X, this.head.Y);
			this.head.move(this.mvx, this.mvy);
			this.outBound();
			return true;
		}
		return false;
	}
	private void outBound() {
		if(this.head.X>Tela.WIDTH/2.0) this.head.X = -1*Tela.WIDTH/2.0 + Point.SIZE;
		if(this.head.X<-1*Tela.WIDTH/2.0) this.head.X = Tela.WIDTH/2.0 - Point.SIZE;
		if(this.head.Y>Tela.HEIGHT/2.0) this.head.Y = -1*Tela.HEIGHT/2.0 + Point.SIZE;
		if(this.head.Y<-1*Tela.HEIGHT/2.0) this.head.Y = Tela.HEIGHT/2.0 - Point.SIZE;
	}
	public void die() { _die = true; }
	@Override
	public void draw(Graphics2D g2d, double maxX, double maxY) {
		head.draw(g2d, corHead);
		for (Point p : tail)
			p.draw(g2d, corTail);
	}
}
