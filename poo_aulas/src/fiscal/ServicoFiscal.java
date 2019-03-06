package fiscal;

import fiscal.impostos.Imposto;
import fiscal.impostos.ImpostoEstadual;
import fiscal.impostos.ImpostoFederal;
import fiscal.tributario.Tributavel;

public class ServicoFiscal {
	public static void imprimeTributo(Imposto imposto, Tributavel tributavel) {
		System.out.println("Competencia irrelevante: " + imposto.calcular(tributavel));
	}
	public static void imprimeTributo(ImpostoEstadual imposto, Tributavel tributavel) {
		System.out.println("Competencia estadual: " + imposto.calcular(tributavel));
	}
	public static void imprimeTributo(ImpostoFederal imposto, Tributavel tributavel) {
		System.out.println("Competencia federal: " + imposto.calcular(tributavel));
	}
}
