package associacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.unifor.poo.controller.XMLControll;

public class PanelScrollTableCRUD<T> extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String PASTA = "./";
	private JTable tabela;
	private TableModel<T> modelo;
	private JButton botaoCarregar;
	private JButton botaoSair;
	private JButton botaoClear;
	private JPanel painelBotoes;
	private Class<T> entity;

	private String getEntityName() {
		String s = entity.getName();
		String[] x = s.split("[.]");
		return x[x.length-1];
	}
	public PanelScrollTableCRUD(Class<T> t) {
		this.setLayout(new BorderLayout());
		painelBotoes = new JPanel();
		this.add(painelBotoes,BorderLayout.SOUTH); painelBotoes.setBackground(Color.green); 
		
		entity = t;
		tabela = new JTable();
		//tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(tabela);//, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
		preparaBotaoCarregar();
		preparaBotaoSair();
		preparaBotaoClear();
	}
	private void preparaBotaoCarregar() {
		botaoCarregar = new JButton("Carregar XML "+getEntityName());
		botaoCarregar.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
		    List<T> lista = new EscolhedorDeXML<T>().escolhe(PASTA);
		    modelo = new TableModel<T>(lista);
		    tabela.setModel(modelo);
		  }
		});
		painelBotoes.add(botaoCarregar);
	}
	private void preparaBotaoSair() {
		botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelBotoes.add(botaoSair);
	}
	private void preparaBotaoClear() {
		botaoClear = new JButton("Limpar");
		botaoClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				modelo.fireTableDataChanged(); //modelo.fireTableRowsUpdated(0, size);
			}
		});
		painelBotoes.add(botaoClear);
	}
	public class EscolhedorDeXML<TT> {
		public List<TT> escolhe(String path) {
			try {
				JFileChooser chooser = new JFileChooser(path);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos XML","xml");
				chooser.setFileFilter(filter);
				int retorno = chooser.showOpenDialog(null);

				if (retorno == JFileChooser.APPROVE_OPTION) {
					FileReader reader = new FileReader(chooser.getSelectedFile());
					return new XMLControll<TT>().carrega(reader);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return Collections.emptyList();
		}
	}
}
