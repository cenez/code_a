package app_snake;
import java.awt.event.KeyEvent;

import app_snake.geometric.Snake;
import commons.JPanelDraw;
import geometrics.PlanoCartesiano;

@SuppressWarnings("serial")
public class JPanelSnake extends JPanelDraw {
	private Snake cobra;
	private PlanoCartesiano plano;
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
		plano = new PlanoCartesiano(tela.halfWidth(), tela.halfHeight());
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
