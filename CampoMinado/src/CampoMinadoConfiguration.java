import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampoMinadoConfiguration {
	private CampoMinado campoMinado;
	public CampoMinadoConfiguration(CampoMinado campoMinado) {
		this.campoMinado = campoMinado;
	}
	public void minas() {
		campoMinado.center.setLayout(new GridLayout(campoMinado.lin, campoMinado.col));
		campoMinado.add(campoMinado.center, BorderLayout.CENTER);
		for (int i = 0; i < campoMinado.lin; i++) {
			campoMinado.minas[i] = new Mina[campoMinado.col];
			for (int j = 0; j < campoMinado.col; j++) {
				Mina mina = new Mina(i, j);
				campoMinado.center.add(mina);
				campoMinado.minas[i][j] = mina;
				mina.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						testaMina(mina);
					}
				});
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
				if (!v.isBomba)
					v.setBackground(Color.GRAY);
				else
					v.setBackground(Color.WHITE);
				v.setEnabled(false);
			});
			mina.setEnabled(false);
		}
	}
	public void visinhos() {
		for (int i = 0; i < campoMinado.lin; i++) {
			for (int j = 0; j < campoMinado.col; j++) {
				Mina mina = campoMinado.minas[i][j];
				mina.setPerimetro(campoMinado.minas);
			}
		}
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
}
