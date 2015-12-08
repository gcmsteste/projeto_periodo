package br.com.projetoperiodo.model.relatorio.semana.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.model.relatorio.semana.impl.SemanaImpl;
import br.com.projetoperiodo.util.persistencia.connection.JPAUtil;
import br.com.projetoperiodo.util.persistencia.fabrica.FabricaJPA;

public class JPASemanaDao implements SemanaDao 
{

	@Override
	public void salvar(Semana semana) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(semana);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void remover(Semana semana) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		semana  = (SemanaImpl)entityManager.merge(semana);
		entityManager.remove(semana);
		entityTransaction.commit();
		entityManager.close();
		
		
	}

	@Override
	public void alterar(Semana semana) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(semana);
		entityTransaction.commit();
		entityManager.close();
		
		
	}

	@Override
	public List<Semana> listar(String condicao) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		List<Semana> semanas = entityManager.
						createQuery(condicao).getResultList();
		entityManager.close();
		return semanas;
	}

	@Override
	public Semana buscar(long primaryKey) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		SemanaImpl semana = entityManager.find(SemanaImpl.class, primaryKey);
		entityManager.close();
		return semana;
	}

	
}
