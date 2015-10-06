package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPAMonitorDao implements MonitorDao{

	@Override
	public void salvar(Monitor monitor) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(monitor);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void atualizar(MonitorImpl monitor) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(monitor);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(MonitorImpl monitor) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Monitor monitorAtualizado = (Monitor)entityManager.merge(monitor);
		entityManager.remove(monitorAtualizado);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<MonitorImpl> listar() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<MonitorImpl> monitores = entityManager.createQuery("from Monitor").getResultList();
		entityManager.close();
			
		return monitores;
	}

	@Override
	public Monitor buscar(int primaryK) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Monitor monitor = entityManager.find(MonitorImpl.class, primaryK);
		entityTransaction.commit();
		entityManager.close();
		
		return monitor;
	}

}
