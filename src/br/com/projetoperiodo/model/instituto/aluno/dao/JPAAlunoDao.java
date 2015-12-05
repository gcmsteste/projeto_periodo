
package br.com.projetoperiodo.model.instituto.aluno.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.util.persistencia.jpa.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class JPAAlunoDao implements AlunoDao {

	@Override
	public void salvar(Aluno aluno) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(aluno);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void atualizar(Aluno aluno) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(aluno);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void remover(Aluno aluno) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Aluno alunoAtualizado = (Aluno) entityManager.merge(aluno);
		entityManager.remove(alunoAtualizado);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public List<Aluno> listar(String condicao) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		List<Aluno> alunos = entityManager.createQuery(condicao).getResultList();
		entityManager.close();

		return alunos;
	}

	@Override
	public Aluno buscar(long primaryK) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTrasaction = entityManager.getTransaction();
		entityTrasaction.begin();
		Aluno aluno = entityManager.find(AlunoImpl.class, primaryK);
		entityTrasaction.commit();
		entityManager.close();

		return aluno;
	}

	@Override
	public Aluno buscarPelaMatricula(String matricula){
		
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTrasaction = entityManager.getTransaction();
		entityTrasaction.begin();
		Aluno aluno = entityManager.find(AlunoImpl.class, matricula);
		entityTrasaction.commit();
		entityManager.close();

		return aluno;

	}
	
	@Override
	public Long buscarQuantidadeAlunos(String condicao) {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		Long quantidade = (Long) entityManager.createQuery(condicao).getSingleResult();
		entityManager.close();

		return quantidade;
	}

}
