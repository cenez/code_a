package br.unifor.tecnicas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.tecnicas.model.Aluno;
import br.unifor.tecnicas.model.Diploma;

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
	public List<Diploma> diplomasOf(long id) {
		Query query = manager.createQuery("from Diploma where aluno_id = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}
	public void remove(Aluno aluno) {
		Query query = manager.createQuery("delete Diploma where aluno_id = :id");
		query.setParameter("id", aluno.getId());
		query.executeUpdate();
		
		query = manager.createQuery("delete Aluno where id = :id");
		query.setParameter("id", aluno.getId());
		query.executeUpdate();
	}
}
