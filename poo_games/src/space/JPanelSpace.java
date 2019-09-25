package space;
import java.awt.event.KeyEvent;

import core.JPanelDraw;
import drawables.CartesianPlane;
import drawables.Star;
import space.drawables.SpaceCraftManager;

@SuppressWarnings("serial")
public class JPanelSpace extends JPanelDraw {
	private SpaceCraftManager nave;
	private CartesianPlane plano;
	private Star star;
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
		nave = new SpaceCraftManager(this);
		plano = new CartesianPlane(tela.halfWidth(), tela.halfHeight());
		star = new Star(tela.halfWidth(), tela.halfHeight());
	}
	protected void update() { 
		this.tela.clear();
		this.renderizar(); 
		this.tela.plot();
	}
	protected void renderizar() {
		this.rainOfStars(20);
		this.tela.draw(nave);
		this.tela.draw(plano);
	}
	protected void rainOfStars(int qtd) {
		for(int i = 1; i <= qtd; i++) {
			star.randomize();
			this.tela.draw(star);
		}
	}
}
