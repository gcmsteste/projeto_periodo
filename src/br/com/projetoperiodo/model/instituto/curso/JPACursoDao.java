package br.com.projetoperiodo.model.instituto.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPACursoDao implements CursoDao
{
	
	public void salvar(Curso curso)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(curso);
		transaction.commit();
		entma.close();	
	}

	public void atualizar(Curso curso)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();		

		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(curso);
		transaction.commit();
		entma.close();
	}	

	public void remover(Curso curso)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(curso);
		entma.remove(curso);
		transaction.commit();
		entma.close();
	}

	public List<Curso> listar()
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Curso> curso = entma.createQuery("from Curso").getResultList();
		entma.close();
		return curso;
		
	}

	public Curso buscar(int primaryKey)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();		

		Curso curso = (Curso) entma.find(Curso.class,primaryKey);
		entma.close();
		return curso;
	}

	@Override
	public List<Curso> listar(String condicao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso salvar(String descricao, String condicao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
