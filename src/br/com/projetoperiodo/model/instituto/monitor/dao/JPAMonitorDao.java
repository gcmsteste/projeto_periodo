package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class JPAMonitorDao implements MonitorDao{

	@Override
	public Monitor salvar(Monitor monitor) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(monitor);
		entityTransaction.commit();
		entityManager.close();
		return monitor;
	}

	@Override
	public void atualizar(Monitor monitor) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(monitor);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Monitor monitor) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		monitor = entityManager.find(MonitorImpl.class, monitor.getChavePrimaria());
		entityManager.remove(monitor);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<Monitor> listar(String condicao) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		List<Monitor> monitores = entityManager.createQuery(condicao).getResultList();
		entityManager.close();
		return monitores;
	}

	@Override
	public Monitor buscar(long primaryK) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Monitor monitor = entityManager.find(MonitorImpl.class, primaryK);
		entityManager.close();
		
		return monitor;
	}



	
	

}
