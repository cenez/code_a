package teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestaLayout extends JFrame {
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JPanel west = new JPanel();
	private JPanel east = new JPanel();
	private JPanel center = new JPanel();

	private JButton btn1 = new JButton("Botao 1");

	public TestaLayout() {
		int n = 10;
		this.setLayout(new GridLayout(n, n));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				this.add(new JButton(i + ":" + j));

		// north.setLayout(new FlowLayout(FlowLayout.LEFT));
		// this.add(north, BorderLayout.NORTH); north.setBackground(Color.BLUE);
		// this.add(south, BorderLayout.SOUTH); south.setBackground(Color.YELLOW);
		// this.add(west, BorderLayout.WEST); west.setBackground(Color.GREEN);
		// this.add(east, BorderLayout.EAST); east.setBackground(Color.RED);
		// this.add(center, BorderLayout.CENTER); center.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		// north.add(btn1);
		// btn1.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// JOptionPane.showMessageDialog(null, "OLA");
		//
		// }
		// });
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TestaLayout app = new TestaLayout();

	}
}
