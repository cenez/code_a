package associacao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AppMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private TableModel<Funcionario> modelo;
	private JTable tabela = new JTable();
	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JButton btnLoad = new JButton("Load Default");
	private JButton btnAdd = new JButton("ADD");
	private JTextField fieldFunc = new JTextField(20);
	
	public AppMain() {
		this.setTitle("Sistemas Unifor Corporation");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout());
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		panelNorth.add(fieldFunc);
	    
		btnsConfig();
		
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setPreferredSize(new Dimension(800, 600));
        panelCenter.add(scroll);
        
        this.pack();
	}
	private void btnsConfig() {
		btnLoad.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
			List<Funcionario> lista = new ArrayList<Funcionario>();
			lista.add(new Funcionario(1,"Joao", "Professor"));
			lista.add(new Funcionario(2,"Maria", "Pesquisadora"));
			
		    modelo = new TableModel<Funcionario>();
			for (Funcionario funcionario : lista)
				modelo.add(funcionario);
			
			tabela.setModel(modelo);
		  }
		});
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = fieldFunc.getText();
				if(tabela.getModel() instanceof TableModel) {
					@SuppressWarnings("unchecked")
					TableModel<Funcionario> model = (TableModel<Funcionario>) tabela.getModel();
				    model.add(new Funcionario(1, nome, "Sem Atribuicao"));
				    model.fireTableDataChanged();
				}
			}
		});
        panelNorth.add(btnAdd);
        panelNorth.add(btnLoad);
	}
	public static void main(String[] args) {
		JFrame app = new AppMain();
		app.setVisible(true);
	}
}

