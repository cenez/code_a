package br.unifor.poo.model.servicos;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.util.Logger;

public class RHAlocaServices implements IRHVisitor {
	
	private IRHVisitor desaloca;
	private IRHManager gerente;
	
	public RHAlocaServices(IRHManager gerente) {
		this.gerente = gerente;
		this.desaloca = new RHDesalocaServices(this.gerente);
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
		return funcionario.setDepartamento(departamento);
//		if(departamento==null) return false;
//		if(!departamento.isFuncionario(funcionario) && funcionario.getMatricula()>=0) {
//			Departamento anterior = funcionario.getDepartamento();
//			if(anterior!=null) 
//				desaloca.visitar(anterior, funcionario);
//			departamento.add(funcionario);
//			funcionario.setDepartamento(departamento);
//			Logger.add(gerente+" Alocou funcionario "+funcionario.getNome()+" ao departamento "+funcionario.getDepartamento().getNome());				
//			return true;
//		}
//		else return false;
	}
}
