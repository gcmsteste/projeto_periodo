package br.com.projetoperiodo.model.instituto.departamento;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoperiodo.model.instituto.departamento.DepartamentoDao;
import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateDepartamentoDao implements DepartamentoDao
{

	@Override
	public void salvar(Departamento departamento) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(departamento);
			transaction.commit();
		} catch( HibernateException e ) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			return session.createQuery("from Departamento").list();
		} catch( HibernateException e ) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void remover(Departamento departamento) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Departamento departamento) {

		// TODO Auto-generated method stub
		
	}

	
}
