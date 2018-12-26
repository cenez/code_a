package arvore_avl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public Main() {
		int largura = 800, altura = 830;
		setSize(largura, altura);
		setTitle("AVL 2D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanelAVL avl = new JPanelAVL(this.getWidth(), this.getHeight());
		add(avl);
		
		setLocationRelativeTo(null);
		
		JPanel top = new JPanel();
		JTextField texto = new JTextField(30);
		top.add(texto);
		this.add(top, BorderLayout.NORTH);
		texto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				avl.removerDado(texto.getText());
				texto.setText("");
			}
		});
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
