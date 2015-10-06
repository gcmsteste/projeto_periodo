package br.com.projetoperiodo.model.instituto.professor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.instituto.professor.impl.ProfessorImpl;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPAProfessorDao implements ProfessorDao
{
	
	public void salvar(Professor professor)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(professor);
		transaction.commit();
		entma.close();	
	}

	public void atualizar(Professor professor)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();		

		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(professor);
		transaction.commit();
		entma.close();
	}	

	public void remover(Professor professor)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(professor);
		entma.remove(professor);
		transaction.commit();
		entma.close();
	}

	public List<Professor> listar()
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Professor> professor = entma.createQuery("from ProfessorImpl").getResultList();
		entma.close();
		return professor;
		
	}

	public Professor buscar(int primaryKey)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();		

		Professor professor = (Professor) entma.find(ProfessorImpl.class,primaryKey);
		entma.close();
		return professor;
	}

	

}
