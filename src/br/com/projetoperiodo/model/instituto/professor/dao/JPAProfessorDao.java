package br.com.projetoperiodo.model.instituto.professor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.instituto.professor.impl.ProfessorImpl;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class JPAProfessorDao implements ProfessorDao
{
	
	public Professor salvar(Professor professor)
	{
		EntityManager entma =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(professor);
		transaction.commit();
		entma.close();
		return professor;
	}

	public void atualizar(Professor professor)
	{
		EntityManager entma =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();		

		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(professor);
		transaction.commit();
		entma.close();
	}	

	public void remover(Professor professor)
	{
		EntityManager entma =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(professor);
		entma.remove(professor);
		transaction.commit();
		entma.close();
	}

	public List<Professor> listar(String condicao)
	{
		EntityManager entma =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Professor> professor = entma.createQuery(condicao).getResultList();
		entma.close();
		return professor;
		
	}

	public Professor buscar(int primaryKey)
	{
		EntityManager entma =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();	

		Professor professor = (Professor) entma.find(ProfessorImpl.class,primaryKey);
		entma.close();
		return professor;
	}

	

}
