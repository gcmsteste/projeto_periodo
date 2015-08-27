package br.com.projetoperiodo.model.instituto.aluno;

import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class HibernateAlunoDao implements AlunoDao{

	 	
	@Override
	public void inserir(Aluno aluno) {
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = session.beginTransaction();
		try{
			session.save(aluno);
			transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		
	}

	@Override
	public void atualizar(Aluno aluno) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = session.beginTransaction();
		try{
			session.update(aluno);
			transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		
	}

	@Override
	public void remover(Aluno aluno) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = session.beginTransaction();
		try{
			session.delete(aluno);
			transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Aluno> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try{
			List<Aluno> alunos = session.createQuery("from Aluno").list();
			return alunos;
		}catch(HibernateException e){
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		
	}

}
