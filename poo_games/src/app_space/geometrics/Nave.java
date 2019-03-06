package app_space.geometrics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import commons.Tela;
import geometrics.IDrawable;

public class Nave implements IDrawable {
	private final Body body;

	private int mvx=-Body.SIZE, mvy=0;
	private int move = 5;

	public Nave(ImageObserver o) { body = new Body(50, o, -25, -1*Tela.HEIGHT/2.0); } 
	public boolean up() {
		this.mvy = move;
		this.mvx = 0;
		return update();
	}
	public boolean down() {
		this.mvy = -1*move;
		this.mvx = 0;
		return update();
	}
	public boolean left() {
		this.mvy = 0;
		this.mvx = -1*move;
		return update();
	}
	public boolean right() {
		this.mvy = 0;
		this.mvx = move;
		return update();
	}
	private boolean update() {
		this.body.move(this.mvx, this.mvy);
		this.outBound();
		return true;
	}
	private void outBound() {
		if(this.body.X>(Tela.WIDTH/2.0 - Body.SIZE)) this.body.X = 1*Tela.WIDTH/2.0 - Body.SIZE;
		if(this.body.X<-1*Tela.WIDTH/2.0) this.body.X = -1*Tela.WIDTH/2.0;
		if(this.body.Y>(Tela.HEIGHT/2.0 - Body.SIZE)) this.body.Y = 1*Tela.HEIGHT/2.0 - Body.SIZE;
		if(this.body.Y<-1*Tela.HEIGHT/2.0) this.body.Y = -1*Tela.HEIGHT/2.0;
	}
	@Override
	public void draw(Graphics2D g2d, double maxX, double maxY) {
		body.draw(g2d, Color.WHITE);
	}
}
