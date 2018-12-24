package fecho;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Container extends JPanel implements Runnable, KeyListener {
	//Controle de plotagem e refresh
	private int sleep = 2000;
	private Tela tela;
	private JProgressBar bar = new JProgressBar(0, 100);
	
	//Componentes visuais
	private Graham graham;
	private PlanoCartesiano plano;
	
	public Container(int largura, int altura) {
		this.setSize(largura, altura);
		this.tela = new Tela(this);
		this.setFocusable(true);
		addKeyListener(this);
	}
	@Override
	public void addNotify() {
		super.addNotify();
		new Thread(this).start();
	}
	@Override
	public void run() {
		this.load();
		while (true) {
			this.update();
			try { Thread.sleep(sleep); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { }
	private void load() { 
		graham = new Graham();
		plano = new PlanoCartesiano();
		
		/*tempo de carga */
		this.add(bar); for(int i = 0; i<100;i++) {
			try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
			bar.setValue(i);
		} this.remove(bar);
	}
	private void update() { 
		graham.setPoints(ServicePontos.pontos());
		this.tela.clear();
		this.renderizar(); 
		this.tela.plot();
	}
	private void renderizar() {
		this.tela.draw(plano);
		this.tela.draw(graham);
	}
}
