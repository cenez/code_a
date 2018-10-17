package br.unifor.poo.view.teste;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unifor.poo.model.Funcionario;
import br.unifor.poo.view.componentes.Tabela;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int auto_increment = 0;
	protected JButton btnOK = new JButton("OK");
	protected JTextField jTextNome = new JTextField(30);
	protected Tabela<Funcionario> tabela = new Tabela<Funcionario>();
	protected JPanel west = new JPanel();
	
	public void iniciar(String titulo){
		this.setTitle(titulo);
		this.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		west.setLayout(new FlowLayout(FlowLayout.LEFT));
		west.add(jTextNome, BorderLayout.NORTH);
		west.add(btnOK, BorderLayout.NORTH);
		this.add(west, BorderLayout.WEST);
		this.add(tabela, BorderLayout.CENTER);

		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		
		jTextNome.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addItem();
				jTextNome.setText("");
			}
		});
		
		this.pack();
		this.setVisible(true);
	}
	private void addItem() {
		Funcionario f = new Funcionario(++auto_increment, jTextNome.getText().toUpperCase(), "Sem Profissão");
		tabela.addItem(f);
	}
}
