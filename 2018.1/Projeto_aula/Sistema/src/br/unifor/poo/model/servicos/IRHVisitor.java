package br.unifor.poo.model.servicos;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;

public interface IRHVisitor {
	public boolean visitar(Departamento departamento);
	public boolean visitar(Departamento departamento, Funcionario funcionario);
}
