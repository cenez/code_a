package fecho;
import java.awt.event.KeyEvent;

import fecho.common.PlanoCartesiano;
import fecho.util.ServicePontos;
import fecho.view.ContainerBase;

@SuppressWarnings("serial")
public class Container extends ContainerBase {
	//Componentes visuais
	private Graham graham;
	private PlanoCartesiano plano;
	
	public Container(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	public void loop() {
		this.sleeping(1000);
		this.update();
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { }
	protected void inicializar() { 
		graham = new Graham();
		plano = new PlanoCartesiano();
	}
	protected void update() { 
		graham.setPoints(ServicePontos.pontos());
		this.tela.clear();
		this.renderizar(); 
		this.tela.plot();
	}
	protected void renderizar() {
		this.tela.draw(plano);
		this.tela.draw(graham);
	}
}
