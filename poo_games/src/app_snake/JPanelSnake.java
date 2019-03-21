package app_snake;
import java.awt.event.KeyEvent;

import app_snake.geometric.Snake;
import commons.JPanelDraw;
import geometrics.PlanoCartesiano;

@SuppressWarnings("serial")
public class JPanelSnake extends JPanelDraw {
	private Snake cobra;
	private PlanoCartesiano plano;
	private boolean up=false, down=false, left=false, right = false;
	public JPanelSnake(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	public void loop() {
		this.sleeping(100);
		
		if(this.up)         cobra.up();
		else if(this.down)  cobra.down();
		else if(this.left)  cobra.left();
		else if(this.right) cobra.right();
		
		this.update();
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { 
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_UP)     { this.up =    true; this.right = this.left  = this.down  = false;}
		if(k == KeyEvent.VK_DOWN)   { this.down =  true; this.up    = this.right = this.left  = false;}
		if(k == KeyEvent.VK_LEFT)   { this.left =  true; this.down  = this.up    = this.right = false;}
		if(k == KeyEvent.VK_RIGHT)  { this.right = true; this.left  = this.down  = this.up    = false;}
	}
	protected void inicializar() { 
		cobra = new Snake();
		plano = new PlanoCartesiano();
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
