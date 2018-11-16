package br.unifor.poo.model.servicos;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.util.Logger;

public class RHDesalocaServices implements IRHVisitor {
	private IRHManager gerente;
	
	public RHDesalocaServices(IRHManager gerente) {
		this.gerente = gerente;
	}
	@Override
	public boolean visitar(Departamento departamento) {
//		if(departamento==null) return false;
//		Funcionario funcionario = departamento.desagendaFuncionario();
//		boolean ok = funcionario!=null;
//		while(funcionario!=null) {
//			ok = ok && this.visitar(departamento, funcionario);
//			funcionario = departamento.desagendaFuncionario();
//		}
//		return ok;
		return false;
	}

	@Override
	public boolean visitar(Departamento departamento, Funcionario funcionario) {
		return funcionario.setDepartamento(null);
//		if(departamento!=null) {
//			boolean isFuncionario = departamento.isFuncionario(funcionario);
//			if(isFuncionario) {
//				Logger.add(gerente+" Desalocou funcionario "+funcionario.getNome()+" do departamento "+funcionario.getDepartamento().getNome());
//				isFuncionario = isFuncionario && departamento.remove(funcionario);
//				funcionario.setDepartamento(null);
//				return isFuncionario;
//			}
//		}
//		return false;
	}
}
