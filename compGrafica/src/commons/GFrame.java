package commons;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public abstract class GFrame extends JPanel implements Runnable, KeyListener {
	//Controle de plotagem e refresh
	protected final Canvas tela;
	private final JProgressBar bar = new JProgressBar(0, 100);
	private int sleeper = 0;
	
	public GFrame(int largura, int altura) {
		super();
		this.setSize(largura, altura);
		this.tela = new Canvas(this);
		this.setFocusable(true);
		addKeyListener(this);
	}
	@Override
	public final void addNotify() {
		super.addNotify();
		new Thread(this).start();
	}
	
	/*
	 * loop() roda constantemente. 
	 * O tempo de espera é dado por sleeping(tempo) no filho! */
	@Override
	public final void run() {
		this.load();
		inicializar();
		while(true) {
			loop();
			try { Thread.sleep(Math.abs(sleeper)); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	protected final void sleeping(int _sleeper) { this.sleeper = _sleeper; }

	/*tempo de carga */
	private final void load() { 
		this.add(bar); for(int i = 0; i<100;i++) {
			try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
			bar.setValue(i);
		} this.remove(bar);
	}

	protected abstract void inicializar();
	protected abstract void loop();
	protected abstract void update();
	protected abstract void renderizar();
}
