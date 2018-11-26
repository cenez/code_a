package br.unifor.tecnicas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.tecnicas.model.Aluno;

@Repository
@Transactional
public class AlunoDao {
	@PersistenceContext
	private EntityManager manager;
	public void gravar(Aluno aluno) {
		manager.persist(aluno);
	}
	public List<Aluno> listar() {
		return manager.createQuery("select p from Aluno p", Aluno.class)
				.getResultList();
	}
	public Aluno load(long id) {
		Aluno a = (Aluno) manager.find(Aluno.class, id);
		return a;
	}
}
