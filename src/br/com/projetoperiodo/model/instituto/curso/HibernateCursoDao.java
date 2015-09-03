package br.com.projetoperiodo.model.instituto.curso;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.sql.Delete;

import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateCursoDao implements CursoDao
{

		private SessionFactory factory;
		private Transaction transaction;
		
		public void CursoDao() 
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
		@Override
		public void inserir(Curso curso) 
		{
			
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(curso);
			transaction.commit();
			session.close();
			
		
		}

		@Override
		public List<Curso> listar(String condicao)
		{
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			List<Curso> curso = session.createQuery(condicao).list();
			transaction.commit();
			session.close();
			return curso; 
		} 

		@Override
		public Curso salvar(String descricao, String condicao) throws Exception  
		{
			Session session = factory.openSession();
			session.beginTransaction();
			Curso curso = session.load(Curso.class,descricao);
			transaction.commit();
			session.close();
			return curso;
			
		}

		@Override
		public void remover(Curso curso) throws Exception
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.delete(curso);
			transaction.commit();
			session.close();
			
		}

		@Override
		public void atualizar(Curso curso) throws Exception
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.update(curso);
			transaction.commit();
			session.close();
			
		}
		
		public void destroyFactory()
		{
			factory.close();
		}

		

		

		
}
