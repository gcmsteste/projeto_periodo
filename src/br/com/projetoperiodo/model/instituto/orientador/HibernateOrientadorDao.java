package br.com.projetoperiodo.model.instituto.orientador;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.sql.Delete; 

public class HibernateOrientadorDao implements OrientadorDao
{
	private SessionFactory factory;
	private Transaction transaction;
	
	public void OrientadorDao() 
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure(new File("resources/hibernate.cfg.xml"));
			factory = configuration.buildSessionFactory();
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return;
	}
	
	public Object inserir(Orientador orientador) throws Exception
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(orientador);
		transaction.commit();
		session.close();
		
		return null;
	}

	//@Override
/*	public List<Orientador> getList(String condicao) throws Exception
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Orientador> orientador = session.createQuery(condicao).list();
		transaction.commit();
		session.close();
		return orientador; 
	} */

	@Override
	public Orientador salvar(Long chavePrimaria, String condicao) throws Exception  
	{
		Session session = factory.openSession();
		session.beginTransaction();
		Orientador orientador = session.load(Orientador.class,chavePrimaria);
		transaction.commit();
		session.close();
		return orientador;
		
	}

	@Override
	public void remover(Orientador orientador) throws Exception
	{
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(orientador);
		transaction.commit();
		session.close();
		
	}

	@Override
	public void atualizar(Orientador orientador) throws Exception
	{
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(orientador);
		transaction.commit();
		session.close();
		
	}
	
	public void destroyFactory()
	{
		factory.close();
	}

	@Override
	public List<Orientador> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvar(Orientador orientador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orientador> getList(String condicao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	 

}
