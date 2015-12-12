package br.com.projetoperiodo.model.instituto.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;

public class JPACursoDao implements CursoDao
{
	private EntityManagerFactory entityManagerFactory;
	
	
	public JPACursoDao(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}
	
	public void salvar(Curso curso)
	{
		EntityManager entma =  entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(curso);
		transaction.commit();
		entma.close();	
	}

	public void atualizar(Curso curso)
	{
		EntityManager entma = entityManagerFactory.createEntityManager();	

		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(curso);
		transaction.commit();
		entma.close();
	}	

	public void remover(Curso curso)
	{
		EntityManager entma =  entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(curso);
		entma.remove(curso);
		transaction.commit();
		entma.close();
	}
	@Override
	public List<Curso> listar()
	{
		EntityManager entma =  entityManagerFactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Curso> curso = entma.createQuery("from CursoImpl").getResultList();
		entma.close();
		return curso;
		
	}
	@Override
	public Curso buscar(long primaryKey)
	{
		EntityManager entma =  entityManagerFactory.createEntityManager();	

		Curso curso = (Curso) entma.find(CursoImpl.class,primaryKey);
		entma.close();
		return curso;
	}

	

	


}
