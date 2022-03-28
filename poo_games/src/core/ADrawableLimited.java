package core;

public abstract class ADrawableLimited implements IDrawable {
	public final double MAX_X;
	public final double MAX_Y;
	
	public ADrawableLimited(double maxX, double maxY) {
		this.MAX_X = maxX;
		this.MAX_Y = maxY;
	}
}
