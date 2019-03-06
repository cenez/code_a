package app_space;
import java.awt.event.KeyEvent;

import app_space.geometrics.Nave;
import commons.JPanelDraw;
import geometrics.PlanoCartesiano;

@SuppressWarnings("serial")
public class JPanelSpace extends JPanelDraw {
	private Nave nave;
	private PlanoCartesiano plano;
	private boolean up=false, down=false;
	public JPanelSpace(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	public void loop() {
		this.sleeping(100);
		if(this.up)         this.up    = nave.up();
		else if(this.down)  this.down  = nave.down();
		this.update();
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { 
		int k = e.getKeyCode();
		this.up = this.down = false;
		
		if(k == KeyEvent.VK_UP)    { this.up = nave.up();       this.down = this.up?false:true;    }
		if(k == KeyEvent.VK_DOWN)  { this.down = nave.down();   this.up = this.down?false:true;    }
		if(k == KeyEvent.VK_LEFT)  { nave.left();   }
		if(k == KeyEvent.VK_RIGHT) { nave.right(); }
	}
	protected void inicializar() { 
		nave = new Nave(this);
		plano = new PlanoCartesiano();
	}
	protected void update() { 
		this.tela.clear();
		this.renderizar(); 
		this.tela.plot();
	}
	protected void renderizar() {
		this.tela.draw(nave);
		this.tela.draw(plano);
	}
}
