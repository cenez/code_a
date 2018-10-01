package poo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Principal extends JFrame {
	protected JButton btn1 = new JButton("Mensagem");
	protected JTextField field1 = new JTextField(30);
	public Principal(){
		this.setTitle("Minha Janela");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setSize(500, 800);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(field1);
		this.add(btn1);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, field1.getText());
			}
		});
		
		this.pack();
		this.setVisible(true);
	}
}
