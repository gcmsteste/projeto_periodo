package br.com.projetoperiodo.model.instituto.orientador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPAOrientadorDao implements OrientadorDao
{
	
	public void salvar(Orientador orientador)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(orientador);
		transaction.commit();
		entma.close();	
	}

	public void atualizar(Orientador orientador)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();		

		EntityTransaction transaction = entma.getTransaction();	
		transaction.begin();
		entma.merge(orientador);
		transaction.commit();
		entma.close();
	}	

	public void remover(Orientador orientador)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entma.getTransaction();
		transaction.begin();
		entma.merge(orientador);
		entma.remove(orientador);
		transaction.commit();
		entma.close();
	}

	public List<Orientador> listar()
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();
		@SuppressWarnings("unchecked")
		List<Orientador> orientador = entma.createQuery("from Orientador").getResultList();
		entma.close();
		return orientador;
		
	}

	public Orientador buscar(int primaryKey)
	{
		EntityManager entma = JPAUtil.getEntityManagerFactory().createEntityManager();		

		Orientador orientador = (Orientador) entma.find(Orientador.class,primaryKey);
		entma.close();
		return orientador;
	}

	@Override
	public List<Orientador> getList(String condicao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orientador salvar(Long chavePrimaria, String condicao)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
