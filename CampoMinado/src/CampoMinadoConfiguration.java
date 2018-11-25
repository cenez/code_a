import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CampoMinadoConfiguration {
	private CampoMinado campoMinado;

	public CampoMinadoConfiguration(CampoMinado campoMinado) {
		this.campoMinado = campoMinado;
	}

	public void menuConf() {
		campoMinado.menuBar.add(campoMinado.menu);
		campoMinado.menu.add(campoMinado.fechar);
		campoMinado.fechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		campoMinado.add(campoMinado.menuBar, BorderLayout.NORTH);
	}

	public void insereMinas() {
		campoMinado.center.setLayout(new GridLayout(campoMinado.lin, campoMinado.col));
		campoMinado.add(campoMinado.center, BorderLayout.CENTER);
		for (int i = 0; i < campoMinado.lin; i++) {
			campoMinado.minas[i] = new Mina[campoMinado.col];
			for (int j = 0; j < campoMinado.col; j++) {
				Mina mina = new Mina(i, j);
				campoMinado.center.add(mina);
				campoMinado.minas[i][j] = mina;
				mina.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						testaMina(mina);
					}
				});
			}
		} // setar as minas perimetrais
		for (int i = 0; i < campoMinado.lin; i++) {
			for (int j = 0; j < campoMinado.col; j++) {
				Mina mina = campoMinado.minas[i][j];
				mina.setPerimetro(campoMinado.minas);
			}
		}
	}

	private void testaMina(Mina mina) {
		if (mina.isEnabled()) {
			if (mina.isBomba) {
				mina.setBackground(Color.BLACK);
				finaliza();
				return;
			}
			mina.setBackground(Color.GRAY);
			mina.perimetros().forEach(v -> {
				if (v != null) {
					if (!v.isBomba)
						v.setBackground(Color.GRAY);
					else
						v.setBackground(Color.WHITE);
					v.setEnabled(false);
				}
			});
		}
		mina.setEnabled(false);
	}

	private void finaliza() {
		for (int i = 0; i < campoMinado.lin; i++) {
			for (int j = 0; j < campoMinado.col; j++) {
				Mina mina = campoMinado.minas[i][j];
				if (mina.isBomba)
					mina.setBackground(Color.BLACK);
				else
					mina.setBackground(Color.GRAY);
				mina.setEnabled(false);
			}
		}
	}

	public void dimensionsConfig(final int MAX) {
		final int PROPORCAO = 30 * MAX;
		campoMinado.setTitle("Jogo do campo minado!!!");
		campoMinado.setPreferredSize(new Dimension(PROPORCAO, PROPORCAO));
		campoMinado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		campoMinado.setVisible(true);
		campoMinado.pack();
		campoMinado.setLocationRelativeTo(null);
	}
}
