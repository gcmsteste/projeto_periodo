package br.com.projetoperiodo.model.instituto.disciplina;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
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
	public void atualizar(Disciplina disciplina) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(disciplina);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Disciplina disciplina) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Disciplina disciplinaAtualizada = (Disciplina)entityManager.merge(disciplina);
		entityManager.remove(disciplinaAtualizada);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public List<Disciplina> listar() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Disciplina> disciplinas = entityManager.createQuery("from Disciplina").getResultList();
		entityManager.close();
		
		return disciplinas;
	}

	@Override
	public Disciplina buscar(int primaryK) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Disciplina disciplina = entityManager.find(Disciplina.class, primaryK);
		entityTransaction.commit();
		entityManager.close();
		
		return disciplina;
	}

}
