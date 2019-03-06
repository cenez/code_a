package fiscal.impostos;

import fiscal.tributario.Tributavel;

/* Imposto Estadual
 * Imposto sobre Circulação de Mercadorias e Serviços
 */
public class ICMS extends ImpostoEstadual {
	@Override
	public double calcular(Tributavel tributavel) {
		return tributavel.valor()*0.1;
	}

}
