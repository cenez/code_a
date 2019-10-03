package snake;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.JPanelDraw;
import drawables.CartesianPlane;
import drawables.Point;
import snake.drawables.Snake;

@SuppressWarnings("serial")
public class JPanelSnake extends JPanelDraw {
	private Snake cobra;
	private CartesianPlane plano;
	private Point comida;
	public JPanelSnake(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	protected void inicializar() { 
		cobra = new Snake(tela.halfWidth(), tela.halfHeight());
		plano = new CartesianPlane(tela.halfWidth(), tela.halfHeight());
		int[] xy = getRandomCoord();
		comida = new Point(xy[0], xy[1]);
	}
	@Override
	public void loop() {
		this.sleeping(100);
		
		if(comida.equals(cobra.getHEAD())) {
			cobra.addToTail(new Point(comida.X, comida.Y));
			int[] xy = getRandomCoord();			
			comida.moveTO(xy[0], xy[1]);
		}
	}
	@Override
	protected void renderizar() {
		this.tela.draw(cobra);
		this.tela.draw(plano);
		this.tela.draw(comida);
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		cobra.move(e);
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	
	private int[] getRandomCoord() { 
		Random r = new Random();
		int[] xy = new int[2];
		xy[0] = r.nextInt()*2%((int)tela.halfWidth());
		xy[1] = r.nextInt()*2%((int)tela.halfHeight());
		return xy;
	}
}
