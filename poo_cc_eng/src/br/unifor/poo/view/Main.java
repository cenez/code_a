package br.unifor.poo.view;

import java.util.Collection;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.view.teste.Principal;

public class Main {
	public static void main(String[] args) {
		Departamento computacao = new Departamento(1, "Computacao");
		Departamento fisica = new Departamento(2, "Fisica");
		Departamento matematica = new Departamento(3, "Matematica");
		
		Funcionario pedro = new Funcionario(1, "Pedro", "Programador");
		Funcionario joao = new Funcionario(2, "Joao", "Analista");
		Funcionario maria = new Funcionario(3, "Maria", "Professora");
		pedro.setDepto(computacao);
		joao.setDepto(fisica);
		maria.setDepto(fisica);
		
		if(joao.equals(maria))
			System.out.println("joao igual maria");
		
		fisica.addFuncionario(joao);
		fisica.addFuncionario(maria);
		
		Collection<Funcionario> lista = fisica.getFuncionarios();
		for (Funcionario funcionario : lista) {
			System.out.println(funcionario+" -> "+funcionario.LEMA);
		}
		Principal p = new Principal();
	}
}
