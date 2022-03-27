package sort;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import commons.JPanelDraw;
import geometrics.Point;
import util.ServicePontosSort;

@SuppressWarnings("serial")
public class JPanelSort extends JPanelDraw {
	private SelectionSortPlot ssortPlot;
	private InsertionSortPlot isortPlot;
	private MergeSortPlot msortPlot;
	private JFrame frame = null;
	private int numPointsGenerated = 200;
	private long[] tempo = new long[3];
	public JPanelSort(int largura, int altura, JFrame frm) {
		super(largura, altura);
		frame = frm;
	}
	@Override
	public void loop() {
		this.sleeping(1000);
		this.update();
		System.exit(0);
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { }
	protected void inicializar() { 
		ssortPlot = new SelectionSortPlot();
		isortPlot = new InsertionSortPlot();
		msortPlot = new MergeSortPlot();
	}
	protected void update() { 
		Point[] pointss = ServicePontosSort.pontos(numPointsGenerated);
		Point[] pointms = new Point[pointss.length];
		Point[] pointis = new Point[pointss.length];
		for (int i =0; i < pointss.length; i++) {
			pointms[i] = new Point(5, pointss[i].x, pointss[i].y);
			pointis[i] = new Point(5, pointss[i].x, pointss[i].y);
		}
		int time = 1;
		ssortPlot.setPoints(pointss,time);
		isortPlot.setPoints(pointis,time);
		msortPlot.setPoints(pointms,time);
		
		this.tela.clear();
		this.renderizar();
	}
	protected void renderizar() {
		JOptionPane.showMessageDialog(null, "Selection Sort!!!");
		tempo[0] = System.currentTimeMillis();
		frame.setTitle("Selection Sort Processing");
		this.tela.draw(ssortPlot);
		this.tela.plot();
		tempo[0] = System.currentTimeMillis()-tempo[0];
		
		JOptionPane.showMessageDialog(null, "Insertion Sort!!!");
		tempo[1] = System.currentTimeMillis();
		this.tela.clear();
		frame.setTitle("Insertion Sort Processing");
		this.tela.draw(isortPlot);
		this.tela.plot();
		tempo[1] = System.currentTimeMillis()-tempo[1];
		
		JOptionPane.showMessageDialog(null, "Merge Sort!!!");
		tempo[2] = System.currentTimeMillis();
		this.tela.clear();
		frame.setTitle("Merge Sort Processing");
		this.tela.draw(msortPlot);
		this.tela.plot();
		tempo[2] = (System.currentTimeMillis()-tempo[2]);
		String msg = 
				"SELECTION: "+tempo[0]+" ms\n"+
				"INSERTION: "+tempo[1]+" ms\n"+
				"MERGE: "+tempo[2]+" ms\n";
		JOptionPane.showMessageDialog(null, msg);
	}
}
