package swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppMain extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel painel = new JPanel();
	public JButton btnGordo = new JButton("Gordo");
	public JButton btnMagro = new JButton("Magro");
	public JTextField fieldNum = new JTextField(30);
	
	public AppMain() {
		this.setTitle("Sistemas Unifor Corporation");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.add(painel);
		painel.add(fieldNum);
		painel.add(btnGordo);
		painel.add(btnMagro);
		
		btnGordo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(fieldNum.getText());
				IFibonacci gordo = new FibonacciGordo(n);
				gordo.fibonacci();
			}
		});
		
		btnMagro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(fieldNum.getText());
				IFibonacci magro = new FibonacciMagro(n);
				new Thread((Runnable)magro).start();
			}
		});
	}
	public static void main(String[] args) {
		JFrame app = new AppMain();
		app.setVisible(true);
	}
}

