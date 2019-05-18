package componente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class MainTestaUso extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private TableModel<Funcionario> modelo;
	private JButton btnLoad = new JButton("Load");
	private JButton btnSair = new JButton("Exit");
	private JButton btnClear = new JButton("Clear");
	private JButton btnNew= new JButton("New");
	private JPanel painelBotoes = new JPanel();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainTestaUso().setVisible(true);
			}
		});
	}
	public MainTestaUso() {
		this.setTitle("Teste componente table model");
		this.setLayout(new BorderLayout());
		this.add(painelBotoes,BorderLayout.SOUTH); 
		painelBotoes.setBackground(Color.green); 
		
		tabela = new JTable();
		JScrollPane scroll = new JScrollPane(tabela);
		this.add(scroll);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		preparaBotaoCarregar();
		preparaBotaoSair();
		preparaBotaoClear();
		preparaBotaoNew();
	}
	private void preparaBotaoCarregar() {
		btnLoad.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
		    modelo = new TableModel<Funcionario>();
		    Departamento cc = new Departamento(1,"Computacao");
		    modelo.add(new Funcionario(1,"Joao","Professor",cc));
		    modelo.add(new Funcionario(2,"Ana","Pesquisadora",cc));
		    modelo.add(new Funcionario(3,"Paulo","Pesquisador",cc));
		    tabela.setModel(modelo);
		  }
		});
		painelBotoes.add(btnLoad);
	}
	private void preparaBotaoSair() {
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelBotoes.add(btnSair);
	}
	private void preparaBotaoClear() {
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				modelo.fireTableDataChanged();
			}
		});
		painelBotoes.add(btnClear);
	}
	private void preparaBotaoNew() {
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    Departamento fis = new Departamento(2,"Fisica");
			    
			    modelo.add(new Funcionario(4,"Fernando","Analista",fis));
				modelo.fireTableDataChanged();
			}
		});
		painelBotoes.add(btnNew);
	}
}
