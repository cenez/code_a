package app_snake;
import java.awt.event.KeyEvent;

import commons.JPanelDraw;
import geometrics.PlanoCartesiano;
import geometrics.Snake;

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
		this.sleeping(10);
		
		if(this.up)         this.up    = cobra.up();
		else if(this.down)  this.down  = cobra.down();
		else if(this.left)  this.left  = cobra.left();
		else if(this.right) this.right = cobra.right();
		
		this.update();
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { 
		int k = e.getKeyCode();
		this.up = this.down = this.left = this.right = false;
		
		if(k == KeyEvent.VK_UP)    { this.up = cobra.up();       this.down = this.up?false:true;    }
		if(k == KeyEvent.VK_DOWN)  { this.down = cobra.down();   this.up = this.down?false:true;    }
		if(k == KeyEvent.VK_LEFT)  { this.left = cobra.left();   this.right = this.left?false:true; }
		if(k == KeyEvent.VK_RIGHT) { this.right = cobra.right(); this.left = this.right?false:true; }
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
