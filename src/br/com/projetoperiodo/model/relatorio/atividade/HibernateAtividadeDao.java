package br.com.projetoperiodo.model.relatorio.atividade;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateAtividadeDao implements AtividadeDao
{

	@Override
	public void salvar(Atividade atividade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(atividade);
			transaction.commit();
		} catch ( HibernateException e ){
			new RuntimeException(e);
		} finally {
			session.close();
		}
		
	}

	@Override
	public void remover(Atividade atividade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(atividade);
			transaction.commit();
		} catch ( HibernateException e ){
			new RuntimeException(e);
		} finally {
			session.close();
		}
		
	}

	@Override
	public void alterar(Atividade atividade) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(atividade);
			transaction.commit();
		} catch ( HibernateException e ){
			new RuntimeException(e);
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Atividade> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			return session.createQuery("from Atividade").list();
		} catch ( HibernateException e ) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Atividade buscar(int primaryKey) {

		// TODO Auto-generated method stub
		return null;
	}

}
