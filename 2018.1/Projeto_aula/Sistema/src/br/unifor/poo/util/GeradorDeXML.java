package br.unifor.poo.util;

import java.util.ArrayList;
import java.util.List;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.model.dao.XMLDao;

public class GeradorDeXML {
	public static void geraDados() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for(Long i = 1l; i < 200; i++) {
			Funcionario f = new Funcionario();
			f.setId(i);
			f.setNome("Maria"+i);
			f.setAtribuicao("Atribuicao"+i);
			funcionarios.add(f);
		}
		List<Departamento> departamentos = new ArrayList<Departamento>();
		for(Long i = 1l; i < 4; i++) {
			Departamento dp = new Departamento();
			dp.setId(i);
			dp.setNome("Departamento"+i);
			departamentos.add(dp);
		}
		for (Funcionario funcionario : funcionarios) {
			Departamento dp = departamentos.get( funcionario.getId().intValue() % departamentos.size() );
			funcionario.setDepartamento(dp);
		}
		
		XMLDao<Funcionario> xml2 = new XMLDao<Funcionario>();
		XMLDao<Departamento> xml3 = new XMLDao<Departamento>();
		
		xml2.toXMLFile(funcionarios, "/tmp/funcionarios.xml");
		xml3.toXMLFile(departamentos, "/tmp/departamentos.xml");
	}
}
