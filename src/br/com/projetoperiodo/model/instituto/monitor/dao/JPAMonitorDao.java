package br.com.projetoperiodo.model.instituto.monitor.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class JPAMonitorDao implements MonitorDao{

	@Override
	public void salvar(Monitor monitor) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(monitor);
		entityTransaction.commit();
		entityManager.close();
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
		Monitor monitorAtualizado = (Monitor)entityManager.merge(monitor);
		entityManager.remove(monitorAtualizado);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<Monitor> listar() {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		List<Monitor> monitores = entityManager.createQuery("from MonitorImpl").getResultList();
		entityManager.close();
			
		return monitores;
	}

	@Override
	public Monitor buscar(long primaryK) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Monitor monitor = entityManager.find(MonitorImpl.class, primaryK);
		entityTransaction.commit();
		entityManager.close();
		
		return monitor;
	}

	@Override
	public List<Monitor> buscar(HashMap<String, Object> filter) throws NegocioException {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery  criteria = builder.createQuery(MonitorImpl.class);
		Root root = criteria.from(MonitorImpl.class);
		
		if ( filter.containsKey(Monitor.ATRIBUTO_CHAVE_PRIMARIA) ) {
			criteria.where( builder.like(root.get(Monitor.ATRIBUTO_CHAVE_PRIMARIA), 
					String.valueOf(filter.get(Monitor.ATRIBUTO_CHAVE_PRIMARIA)) ) );
			 
			
		}
		List<Monitor> monitores;
		try {
			monitores =  entityManager.createQuery(criteria).getResultList();
		} catch( NoResultException e ) {
			throw new NegocioException(Constantes.ENTIDADE_NAO_ENCONTRADA);
		}
		entityManager.close();
		return monitores;
	}

}
