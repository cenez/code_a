package snake;
import java.awt.event.KeyEvent;

import core.JPanelDraw;
import drawables.CartesianPlane;
import snake.drawables.Snake;

@SuppressWarnings("serial")
public class JPanelSnake extends JPanelDraw {
	private Snake cobra;
	private CartesianPlane plano;
	public JPanelSnake(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	public void loop() {
		this.sleeping(100);
		this.update();
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { 
		cobra.move(e);
	}
	protected void inicializar() { 
		cobra = new Snake(tela.halfWidth(), tela.halfHeight());
		plano = new CartesianPlane(tela.halfWidth(), tela.halfHeight());
	}
	protected void update() { 
		this.tela.clear();
		this.renderizar(); 
		this.tela.plot();
	}
	protected void renderizar() {
		this.tela.draw(cobra);
		this.tela.draw(plano);
	}
}
