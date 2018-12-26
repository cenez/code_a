package arvore_avl;
import java.awt.event.KeyEvent;
import java.util.List;

import commons.JPanelDraw;

@SuppressWarnings("serial")
public class JPanelAVL extends JPanelDraw {
	//Componentes visuais
	
	AVL<Integer> inteiros;
	public JPanelAVL(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	public void loop() {
		this.sleeping(10);
		this.update();
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { }
	protected void inicializar() { 
		inteiros = ServiceAvl.arvore(this.tela.largura(), this.tela.altura());
	}
	protected void update() { 
		this.tela.clear();
		List<NO<Integer>> s = inteiros.dados(this.tela.largura(), this.tela.altura());
		for (NO<Integer> no : s) {
			tela.draw(no);
		}
		this.tela.plot();
	}
	protected void renderizar() {

	}
	public void removerDado(String txt) {
		inteiros.delete(Integer.parseInt(txt));
		
	}
}
