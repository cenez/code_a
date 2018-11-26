package br.unifor.tecnicas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.tecnicas.model.Aluno;
import br.unifor.tecnicas.model.Diploma;

@Repository
@Transactional
public class DiplomaDao {
	@PersistenceContext
	private EntityManager manager;
	public void gravar(Diploma diploma) {
		manager.persist(diploma);
	}
	public List<Diploma> listar() {
		return manager.createQuery("select p from Diploma p", Diploma.class)
				.getResultList();
	}
	public List<Aluno> listarAlunos() {
		return manager.createQuery("select p from Aluno p", Aluno.class)
				.getResultList();
	}
}
