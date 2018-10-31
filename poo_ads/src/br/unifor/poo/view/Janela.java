package br.unifor.poo.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.view.componentes.Tabela;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	protected JButton btnOK = new JButton("OK");
	protected JTextField jTextNome = new JTextField(30);
	protected Tabela<Funcionario> tabela = new Tabela<Funcionario>();
	protected Tabela<Departamento> tabelaDp = new Tabela<Departamento>();
	protected JPanel west = new JPanel();
	
	public void iniciar(String titulo){
		this.setTitle(titulo);
		this.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		west.setLayout(new FlowLayout(FlowLayout.LEFT));
		west.add(jTextNome);
		west.add(btnOK);
		
		this.add(west, BorderLayout.WEST);
		this.add(tabela, BorderLayout.CENTER);
		this.add(tabelaDp, BorderLayout.SOUTH);
		
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
		Funcionario f = new Funcionario(jTextNome.getText().toUpperCase(), "Sem Profissao");
		Departamento dp = new Departamento(jTextNome.getText().toUpperCase());
		f.setDepartamento(dp);
		tabela.addItem(f);
		tabelaDp.addItem(dp);
	}
}
