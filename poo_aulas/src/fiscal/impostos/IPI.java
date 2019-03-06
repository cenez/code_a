package fiscal.impostos;

import fiscal.tributario.Tributavel;

/* Imposto Federal
 * Imposto sobre Produtos Industrializados (IPI)
 */
public class IPI extends ImpostoFederal {

	@Override
	public double calcular(Tributavel tributavel) {
		return tributavel.valor()*0.07;
	}

}
