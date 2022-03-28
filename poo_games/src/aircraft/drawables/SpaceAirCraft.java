package aircraft.drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import core.IDrawable;
import core.Canvas;

public class SpaceAirCraft implements IDrawable {
	private final AirCraft body;

	private int mvx=-AirCraft.SIZE, mvy=0;
	private int move = 5;

	public SpaceAirCraft(ImageObserver o) { body = new AirCraft(50, o, -25, -1*Canvas.HEIGHT/2.0); } 
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
		if(this.body.X>(Canvas.WIDTH/2.0 - AirCraft.SIZE)) this.body.X = 1*Canvas.WIDTH/2.0 - AirCraft.SIZE;
		if(this.body.X<-1*Canvas.WIDTH/2.0) this.body.X = -1*Canvas.WIDTH/2.0;
		if(this.body.Y>(Canvas.HEIGHT/2.0 - AirCraft.SIZE)) this.body.Y = 1*Canvas.HEIGHT/2.0 - AirCraft.SIZE;
		if(this.body.Y<-1*Canvas.HEIGHT/2.0) this.body.Y = -1*Canvas.HEIGHT/2.0;
	}
	@Override
	public void draw(Graphics2D g2d) {//, double maxX, double maxY) {
		body.draw(g2d, Color.WHITE);
	}
}
