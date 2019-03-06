package fiscal.impostos;

import fiscal.tributario.Tributavel;

/* Imposto Federal
 * Imposto de Importação
 */
public class II extends ImpostoFederal {

	@Override
	public double calcular(Tributavel tributavel) {
		return tributavel.valor()*0.25;
	}

}
