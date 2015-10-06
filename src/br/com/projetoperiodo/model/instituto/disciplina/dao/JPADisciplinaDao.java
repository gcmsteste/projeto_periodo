package br.com.projetoperiodo.model.instituto.disciplina.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPADisciplinaDao implements DisciplinaDao{

	@Override
	public void salvar(Disciplina disciplina) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(disciplina);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void atualizar(DisciplinaImpl disciplina) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(disciplina);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(DisciplinaImpl disciplina) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Disciplina disciplinaAtualizada = (Disciplina)entityManager.merge(disciplina);
		entityManager.remove(disciplinaAtualizada);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public List<DisciplinaImpl> listar() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<DisciplinaImpl> disciplinas = entityManager.createQuery("from Disciplina").getResultList();
		entityManager.close();
		
		return disciplinas;
	}

	@Override
	public Disciplina buscar(int primaryK) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Disciplina disciplina = entityManager.find(DisciplinaImpl.class, primaryK);
		entityTransaction.commit();
		entityManager.close();
		
		return disciplina;
	}

}
