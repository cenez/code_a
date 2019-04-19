package br.unifor.poo.util;

import java.util.ArrayList;
import java.util.List;

import associacao.Departamento;
import associacao.Funcionario;
import br.unifor.poo.controller.XMLControll;

public class GeradorDeXML {
	public static void geraDados() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for(int i = 1; i < 10; i++) {
			Funcionario f = new Funcionario(i, "Nome."+i, "Atribuicao"+i);
			funcionarios.add(f);
		}
		List<Departamento> departamentos = new ArrayList<Departamento>();
		for(int i = 1; i < 4; i++) {
			Departamento dp = new Departamento(1, "Departamento."+i);
			departamentos.add(dp);
		}
		for (Funcionario funcionario : funcionarios) {
			Departamento dp = departamentos.get(funcionario.getMatricula() % departamentos.size());
			funcionario.setDepartamento(dp);
		}
		
		XMLControll<Funcionario> xml2 = new XMLControll<Funcionario>();
		XMLControll<Departamento> xml3 = new XMLControll<Departamento>();
		
		xml2.toXMLFile(funcionarios, "./funcionarios.xml");
		xml3.toXMLFile(departamentos, "./departamentos.xml");
	}
}
