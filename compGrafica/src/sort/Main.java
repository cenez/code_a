package sort;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public Main() {
		int largura = 400, altura = 430;
		setTitle("Algoritmos de Ordenação");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new JPanelSort(largura, altura, this));
		setSize(largura, altura);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
