package br.com.projetoperiodo.model.instituto.aluno;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPAAlunoDao implements AlunoDao{

	@Override
	public void salvar(Aluno aluno) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(aluno);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void atualizar(Aluno aluno) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(aluno);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void remover(Aluno aluno) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Aluno alunoAtualizado = (Aluno)entityManager.merge(aluno);
		entityManager.remove(alunoAtualizado);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<Aluno> listar() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Aluno> alunos = entityManager.createQuery("from Aluno").getResultList();
		entityManager.close();
		
		return alunos;
	}

	@Override
	public Aluno buscar(int primaryK) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTrasaction = entityManager.getTransaction();
		entityTrasaction.begin();
		Aluno aluno = entityManager.find(Aluno.class, primaryK);
		entityTrasaction.commit();
		entityManager.close();
		
		return aluno;
	}

}
