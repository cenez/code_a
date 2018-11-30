package br.unifor.tecnicas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Diploma> listar(long id) {
		Query query = manager.createQuery("from Diploma where aluno_id = :id");
		query.setParameter("id", id);
		List<Diploma> list = query.getResultList();		
		return list;
	}
}
