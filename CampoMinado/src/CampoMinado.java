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
		CampoMinadoConfiguration.menuConf(this);
		CampoMinadoConfiguration.insereMinas(this);
		CampoMinadoConfiguration.dimensionsConfig(this, size);
	}
}
