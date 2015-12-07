package br.com.projetoperiodo.model.instituto.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.util.persistencia.jpa.JPAConnectionFactory;

public class JPACursoDao implements CursoDao
{
	
	public void salvar(Curso curso)
	{
		EntityManager entma =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(curso);
		transaction.commit();
		entma.close();	
	}

	public void atualizar(Curso curso)
	{
		EntityManager entma =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();	

		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(curso);
		transaction.commit();
		entma.close();
	}	

	public void remover(Curso curso)
	{
		EntityManager entma =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(curso);
		entma.remove(curso);
		transaction.commit();
		entma.close();
	}
	@Override
	public List<Curso> listar(String condicao)
	{
		EntityManager entma =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Curso> curso = entma.createQuery(condicao).getResultList();
		entma.close();
		return curso;
		
	}
	@Override
	public Curso buscar(long primaryKey)
	{
		EntityManager entma =  JPAConnectionFactory.getInstance().getEntityManagerFactory().createEntityManager();	

		Curso curso = (Curso) entma.find(CursoImpl.class,primaryKey);
		entma.close();
		return curso;
	}

	

	


}
