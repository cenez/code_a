package snake;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.GFrame;
import drawables.BodySnakeImg;
import drawables.Circulo;
import drawables.Retangulo;
import drawables.RetanguloImg;
import snake.drawables.Snake;

@SuppressWarnings("serial")
public class JPanelSnake extends GFrame {
	private Snake cobra;
	//private Retangulo borda;
	private Retangulo obstaculo;
	private RetanguloImg fundo;
	private Circulo comida;//comida não pode surgir sobre a cobra
	private KeyEvent e = null;
	public JPanelSnake(int largura, int altura) {
		super(((int)largura/Circulo.SIZE)*Circulo.SIZE, ((int)altura/Circulo.SIZE)*Circulo.SIZE);
	}
	@Override
	protected void inicializar() { 
		cobra = new Snake(tela.halfWidth(), tela.halfHeight(), this);
		//borda = new Retangulo(tela.halfWidth(), tela.halfHeight());
		
		fundo = new RetanguloImg(tela.halfWidth(), tela.halfHeight(), this);
		
		obstaculo = new Retangulo(-30, 60, 40, 100, Color.BLACK, true);
		int[] xy = getRandomCoord();
		comida = new Circulo(xy[0], xy[1], Color.ORANGE);
	}
	@Override
	public void loop() {
		this.sleeping(50);
		
		if(comida.equals(cobra.getHEAD())) {
			cobra.addToTail(new BodySnakeImg(comida.X, comida.Y, this));
			
			int[] xy = getRandomCoord();
			comida.moveTO(xy[0], xy[1]);
			while(obstaculo.intersects(comida.CIRCULO)) {
				xy = getRandomCoord();
				comida.moveTO(xy[0], xy[1]);
			}
		}
		if(e!=null) cobra.listenKey(e);
		cobra.update();
		if(obstaculo.intersects(cobra.getHEAD().CIRCULO)) {
			cobra.fluxoX *=  -1;
			cobra.fluxoY *=  -1;
			cobra.getHEAD().X += cobra.fluxoX*2;
			cobra.getHEAD().Y += cobra.fluxoY*2;
		}
	}
	@Override
	protected void renderizar() {
		//this.tela.draw(borda);
		this.tela.draw(fundo);
		this.tela.draw(cobra);
		this.tela.draw(comida);
		this.tela.draw(obstaculo);
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		this.e = e;
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	
	private int[] getRandomCoord() { 
		Random r = new Random();
		int[] xy = new int[2];
		xy[0] = r.nextInt()*2%((int)tela.halfWidth()-Circulo.SIZE*2);
		xy[1] = r.nextInt()*2%((int)tela.halfHeight()-Circulo.SIZE*2);
		return xy;
	}
}
