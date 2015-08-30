package br.com.projetoperiodo.model.usuario;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateUsuarioDao implements UsuarioDao{

	@Override
	public void salvar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(usuario);
			transaction.commit();
		}catch(HibernateException e)
		{
			throw e;
		}finally
		{
			session.close();
		}
		
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.update(usuario);
			transaction.commit();
		}catch(HibernateException e)
		{
			throw e;
		}finally
		{
			session.close();
		}
	}

	@Override
	public void remover(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(usuario);
			transaction.commit();
		}catch(HibernateException e)
		{
			e.printStackTrace();
			throw e;
		}finally
		{
			session.close();
		}
	}

	@Override
	public List<Usuario> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			/* Coloquei o retorno imediato*/
			return session.createQuery("from Usuario").list();
		}catch(HibernateException e)
		{
			throw e;
		}finally
		{
			session.close();
		}
		
	}

}
