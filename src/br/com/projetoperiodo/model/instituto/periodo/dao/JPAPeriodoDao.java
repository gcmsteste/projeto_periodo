package br.com.projetoperiodo.model.instituto.periodo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.instituto.periodo.impl.PeriodoImpl;
import br.com.projetoperiodo.util.persistencia.jpa.JPAConnectionFactory;

public class JPAPeriodoDao implements PeriodoDao
{

	@Override
	public void salvar(Periodo periodo) {
		EntityManager entityManager =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(periodo);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void atualizar(Periodo periodo) {
		EntityManager entityManager =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(periodo);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void remover(Periodo periodo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Periodo buscar(long l) {
		EntityManager entityManager =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Periodo periodo = entityManager.find(PeriodoImpl.class, l);
		entityTransaction.commit();
		entityManager.close();
		
		return periodo;
	}

	@Override
	public List<Periodo> listar(String condicao) {
		EntityManager entityManager =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		List<Periodo> monitores = entityManager.createQuery(condicao).getResultList();
		entityManager.close();
			
		return monitores;
	}

}
