package br.unifor.poo.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.unifor.poo.model.Departamento;
import br.unifor.poo.model.Funcionario;
import br.unifor.poo.model.dao.DAO;

public class TestaBanco {
	public static void main(String[] args) {
		DAO<Departamento,Long> daoDp = new DAO<>(ConnectionFactory.currentManager(), Departamento.class);
	
		Departamento depto = daoDp.load(2l);
		if(depto!=null) {
			depto.listaColaboradores();
		}else System.out.println("Nao existe");
	}
	public static Departamento newOrGetDepto(EntityManager manager, String nome) {
		Departamento depto = findDepto(manager,nome);
		if(depto!=null) return depto;
		depto = new Departamento();
		depto.setNome(nome);
		return depto;
	}
	public static Funcionario setFuncionario(String nome, Departamento depto) {
		Funcionario aluno = new Funcionario();		
		aluno.setNome(nome);
		aluno.setDepartamento(depto);
		return aluno;
	}
	public static Departamento findDepto(EntityManager manager, String nome) {
		List<Departamento> lista = ( (List<Departamento>) manager.createQuery("SELECT d FROM Departamento d WHERE d.nome LIKE ?1").setParameter(1, nome).getResultList() );
		if(lista.size()>0) return lista.get(0);
		return null;
	}
}






















