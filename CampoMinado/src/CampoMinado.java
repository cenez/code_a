import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CampoMinado extends JFrame {
	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu menu = new JMenu("Campo");
	protected JMenuItem fechar = new JMenuItem("Fechar");
	protected JPanel center = new JPanel();
	
	protected int lin = 0;
	protected int col = 0;
	protected Mina[][] minas;
	
	public void start(int size) {
		this.lin = size;
		this.col = size;
		minas = new Mina[lin][];
		CampoMinadoConfiguration config = new CampoMinadoConfiguration(this);
		config.minas();
		config.visinhos();
		this.menu();
		this.dimensionsConfig(size);
	}
	public void menu() {
		this.menuBar.add(this.menu);
		this.menu.add(this.fechar);
		this.fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(this.menuBar, BorderLayout.NORTH);
	}
	public void dimensionsConfig(final int MAX) {
		final int PROPORCAO = 30 * MAX;
		this.setTitle("Jogo do campo minado!!!");
		this.setPreferredSize(new Dimension(PROPORCAO, PROPORCAO));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
