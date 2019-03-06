package fiscal.impostos;

import fiscal.tributario.Tributavel;

/* Imposto Federal
 * Imposto sobre Operações Financeiras
 */
public class IOF extends ImpostoFederal {

	@Override
	public double calcular(Tributavel tributavel) {
		return tributavel.valor()*0.05;
	}

}
