package fiscal.impostos;

import fiscal.tributario.Tributavel;

/* Imposto Estadual
 * Imposto sobre a Propriedade de Veículos Automotores 
 */
public class IPVA extends ImpostoEstadual {

	@Override
	public double calcular(Tributavel tributavel) {
		return tributavel.valor()*0.02;
	}

}
