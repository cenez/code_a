package fiscal.impostos;

import fiscal.tributario.Tributavel;

public abstract class Imposto {
	public abstract double calcular(Tributavel tributavel);
}
