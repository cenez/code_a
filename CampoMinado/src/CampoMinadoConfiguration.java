import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampoMinadoConfiguration {
	private CampoMinado campoMinado;
	public CampoMinadoConfiguration(CampoMinado campoMinado) {
		this.campoMinado = campoMinado;
	}
	public void minas() {
		for (int i = 0; i < campoMinado.lin; i++) {
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
		this.visinhos();
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
	private void visinhos() {
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
