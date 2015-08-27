package br.com.projetoperiodo.model.usuario;

import java.util.List;

import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateUsuarioDao implements UsuarioDao{

	@Override
	public void insert(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(usuario);
			transaction.commit();
		}catch(HibernateException e)
		{
			e.printStackTrace();
			e throw;
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
			e.printStackTrace();
			e throw;
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
			e throw;
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
			List<Usuario> usuarios = session.createQuery("from Usurio").list();
			return usuarios;
		}catch(HibernateException e)
		{
			e.printStackTrace();
			e throw;
		}finally
		{
			session.close();
		}
		
	}

}
