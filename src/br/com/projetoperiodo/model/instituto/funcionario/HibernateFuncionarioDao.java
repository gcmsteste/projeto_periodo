package br.com.projetoperiodo.model.instituto.funcionario;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateFuncionarioDao implements FuncionarioDao
{

	@Override
	public void salvar(Funcionario funcionario) {

		Session session = HibernateUtil.getSessionFactory().
						getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			session.save(funcionario);
		} catch( HibernateException e ) {
			throw e;
		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listar() {

		Session session = HibernateUtil.getSessionFactory().
						getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			return session.createQuery("from Funcionario").list();
		} catch( HibernateException e ) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void remover(Funcionario funcionario) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Funcionario funcionario) {

		// TODO Auto-generated method stub
		
	}

}
