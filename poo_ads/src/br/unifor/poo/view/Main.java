package br.unifor.poo.view;

import java.util.Arrays;
import java.util.List;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;

public class Main {
	public static void main(String[] args) {
		Departamento cc = new Departamento("C.Computacao");
		Departamento ads = new Departamento("Ads");
		Departamento engcomp = new Departamento("Eng.Computacao");
		Departamento fisica = new Departamento("Fisica");
		
		Funcionario joao = new Funcionario("Joao","Programador");
		Funcionario maria = new Funcionario("Maria","Analista");
		Funcionario ana = new Funcionario("Ana","Professora");
		Funcionario pedro = new Funcionario("Pedro","Coordenador");
		
		cc.addFuncionario(joao);
		cc.addFuncionario(maria);
		ads.addFuncionario(ana);
		ads.addFuncionario(pedro);
		
		joao.setDepartamento(cc);
		maria.setDepartamento(cc);
		ana.setDepartamento(ads);
		pedro.setDepartamento(ads);
		
		List<Funcionario> funcs = Arrays.asList(joao,maria,ana,pedro);
		List<Departamento> deptos = Arrays.asList(cc,ads,engcomp,fisica);
		funcs.forEach(t-> { System.out.println(t);});
		System.out.println("*******************");
		deptos.forEach(t-> { System.out.println(t);});
	}
}
