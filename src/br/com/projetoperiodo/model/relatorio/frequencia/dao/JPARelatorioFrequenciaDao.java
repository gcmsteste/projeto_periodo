package br.com.projetoperiodo.model.relatorio.frequencia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.dao.SemanaDao;
import br.com.projetoperiodo.util.persistencia.jpa.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class JPARelatorioFrequenciaDao implements RelatorioFrequenciaDao
{
	
	@Override
	public void salvar(RelatorioFrequencia relatorio) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(relatorio);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void atualizar(RelatorioFrequencia relatorio) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(relatorio);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void remover(RelatorioFrequencia relatorio) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		relatorio = entityManager.merge(relatorio);
		entityManager.remove(relatorio);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<RelatorioFrequencia> listar(String condicao) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		List<RelatorioFrequencia> lista = entityManager.
						createQuery(condicao).getResultList();
		entityManager.close();
		return lista;
	}

	@Override
	public RelatorioFrequencia buscar(long primaryKey) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		return entityManager.find(RelatorioFrequenciaImpl.class, primaryKey);
	}

}
