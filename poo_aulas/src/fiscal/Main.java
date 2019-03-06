package fiscal;

import fiscal.impostos.ICMS;
import fiscal.impostos.II;
import fiscal.impostos.IPI;
import fiscal.impostos.Imposto;
import fiscal.impostos.ImpostoEstadual;
import fiscal.impostos.ImpostoFederal;
import fiscal.tributario.Veiculo;
import fiscal.tributario.Bebida;
import fiscal.tributario.Tributavel;

public class Main {
	public static void main(String[] args) {
		Main app = new Main();
		app.testar();
	}
	public void testar() {
		Imposto ipi = new IPI();
		ImpostoEstadual icms = new ICMS();
		ImpostoFederal ii = new II();
		
		Veiculo mustang = new Veiculo(30000);
		ServicoFiscal.imprimeTributo(ipi, mustang);
		ServicoFiscal.imprimeTributo(icms, mustang);
		ServicoFiscal.imprimeTributo(ii, mustang);
		
		Tributavel skol = new Bebida(7);
		ServicoFiscal.imprimeTributo(ipi, skol);
		ServicoFiscal.imprimeTributo(icms, skol);
		ServicoFiscal.imprimeTributo(ii, skol);		
	}
}
