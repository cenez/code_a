package fecho;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fecho.view.Container;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public Main() {
		int largura = 800, altura = 830;
		setTitle("Graham 2D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Container(largura, altura));
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
