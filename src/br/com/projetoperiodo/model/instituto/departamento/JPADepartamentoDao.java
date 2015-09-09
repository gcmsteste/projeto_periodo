package br.com.projetoperiodo.model.instituto.departamento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.JPAUtil;
import br.com.projetoperiodo.model.instituto.departamento.DepartamentoDao;

public class JPADepartamentoDao implements DepartamentoDao
{
	
	public List<Departamento> listar()
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Departamento> departamento = entma.createQuery("from Departamento").getResultList();
		entma.close();
		return departamento;
	}


	public void salvar(Departamento departamento)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(departamento);
		transaction.commit();
		entma.close();
	}

	public void remover(Departamento departamento)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(departamento);
		entma.remove(departamento);
		transaction.commit();
		entma.close();

	}

	public void atualizar(Departamento departamento)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(departamento);
		transaction.commit();
		entma.close();
	}

	public Departamento buscar(int primarykey)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unused")
		EntityTransaction transaction = entma.getTransaction();
		Departamento departamento = (Departamento) entma.find

	(Departamento.class,primarykey);
		entma.close();
		return departamento;
	}


}
