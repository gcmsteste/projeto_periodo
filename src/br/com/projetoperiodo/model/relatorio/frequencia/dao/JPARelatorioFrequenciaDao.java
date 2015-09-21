package br.com.projetoperiodo.model.relatorio.frequencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.semana.SemanaDao;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPARelatorioFrequenciaDao implements RelatorioFrequenciaDao
{
	
	@Override
	public void salvar(RelatorioFrequencia relatorio) {

		EntityManager entityManager = FabricaJPA.getInstancia().
				getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(relatorio);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void atualizar(RelatorioFrequencia relatorio) {

		EntityManager entityManager = FabricaJPA.getInstancia().
				getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(relatorio);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void remover(RelatorioFrequencia relatorio) {

		EntityManager entityManager = FabricaJPA.getInstancia().
				getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		relatorio = entityManager.merge(relatorio);
		entityManager.remove(relatorio);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<RelatorioFrequencia> listar() {

		EntityManager entityManager = FabricaJPA.getInstancia().
				getEntityManagerFactory().createEntityManager();
		return entityManager.createQuery("from RelatorioFrequencia").getResultList();
	}

	@Override
	public RelatorioFrequencia buscar(int primaryKey) {

		EntityManager entityManager = FabricaJPA.getInstancia().
				getEntityManagerFactory().createEntityManager();
		return entityManager.find(RelatorioFrequencia.class, primaryKey);
	}

}
