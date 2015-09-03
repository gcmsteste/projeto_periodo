package br.com.projetoperiodo.model.relatorio.semana;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPASemanaDao implements SemanaDao 
{

	@Override
	public void salvar(Semana semana) {

		EntityManager entityManager = JPAUtil.
						getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(semana);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void remover(Semana semana) {

		EntityManager entityManager = JPAUtil.
						getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(semana);
		entityTransaction.commit();
		entityManager.close();
		
		
	}

	@Override
	public void alterar(Semana semana) {

		EntityManager entityManager = JPAUtil.
						getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(semana);
		entityTransaction.commit();
		entityManager.close();
		
		
	}

	@Override
	public List<Semana> listar() {

		EntityManager entityManager = JPAUtil.
						getEntityManagerFactory().createEntityManager();
		List<Semana> semanas = entityManager.
						createQuery("from Semana").getResultList();
		entityManager.close();
		return semanas;
	}

	@Override
	public Semana buscar(int primaryKey) {

		EntityManager entityManager = JPAUtil.
						getEntityManagerFactory().createEntityManager();
		Semana semana = entityManager.find(Semana.class, primaryKey);
		entityManager.close();
		return semana;
	}

}
