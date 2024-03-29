package geometrics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

public class PlanoCartesiano implements IDrawable {
	private final int recuo = 30;
	public void draw(Graphics2D paint, double maxX, double maxY) {
		Stroke tmp = paint.getStroke();
		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		paint.setStroke(dashed);
		
		paint.draw(new Line2D.Double(
				-1*maxX+recuo, 0, 
				maxX-recuo, 0));
		paint.draw(new Line2D.Double(
				0, -1*maxY+recuo, 
				0, maxY-recuo));

		paint.setStroke(tmp);
		
//		g2d.scale(1, -1);
//		g2d.drawString("Q0", 200, -200);
//		g2d.drawString("Q1", -200, -200);
//		g2d.drawString("Q2", -200, 200);
//		g2d.drawString("Q3", 200, 200);
//		g2d.scale(1, -1);
	}
}
