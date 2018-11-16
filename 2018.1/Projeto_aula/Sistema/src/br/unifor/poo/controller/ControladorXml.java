package br.unifor.poo.controller;

import java.util.ArrayList;
import java.util.List;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.model.dao.XMLDao;
import br.unifor.poo.util.FileUtil;

public class ControladorXml {
	
	private XMLDao<Departamento> xmlDaoDepto = new XMLDao<Departamento>();
	private XMLDao<Funcionario> xmlDaoFunc= new XMLDao<Funcionario>();
	
	private static List<Departamento> departamentos;
	private static List<Funcionario> funcionarios;
	
	private String pathDpto = "departamentos.xml";
	private String pathFunc= "funcionarios.xml";
	
	public ControladorXml(){
		if(!FileUtil.existsFile(pathDpto)) {
			departamentos = new ArrayList<Departamento>();
			funcionarios = new ArrayList<Funcionario>();
			this.salvaFuncDepto();
		}
		departamentos = ((List<Departamento>) xmlDaoDepto.fromXMLFile(pathDpto));
		funcionarios = ((List<Funcionario>) xmlDaoFunc.fromXMLFile(pathFunc));
		sinc();
	}
	private void sinc() {
		for (Funcionario f : funcionarios) {
			if(f.getDepartamento()!=null) {
				departamentos.remove(f.getDepartamento());
				departamentos.add(f.getDepartamento());
			}
		}
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void salvaFuncDepto() {
		xmlDaoDepto.toXMLFile(ControladorXml.departamentos, pathDpto);
		xmlDaoFunc.toXMLFile(ControladorXml.funcionarios, pathFunc);
	}
}
