package swing.modal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Main extends JFrame {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuCadastro = new JMenu("Cadastro");
	private JMenuItem menuCadastroPessoa = new JMenuItem("Pessoa");
	public Main() {
		int largura = 500, altura = 530;
		setTitle("Snake 2D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(menuBar, BorderLayout.NORTH);
		add(new JTextField(30), BorderLayout.SOUTH);
		menuBar.add(menuCadastro);
		menuCadastro.add(menuCadastroPessoa);
		menuCadastroPessoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubJanela modal = new SubJanela("Pessoas");
			}
		});		
		setSize(largura, altura);
		setLocationRelativeTo(null);
	}
	public Main self() { return this; };
	
	public class SubJanela extends JFrame {//extends JDialog{
		public SubJanela(String titulo) {
			this.setTitle(titulo);
			this.setSize(200, 200);
			this.setLocationRelativeTo(self());
			//this.setModal(true);
			//this.setAlwaysOnTop(true);
			this.setVisible(true);
		}
	}

	public static void main(String[] args) {
		Main app = new Main();
		app.setVisible(true);
	}
}
