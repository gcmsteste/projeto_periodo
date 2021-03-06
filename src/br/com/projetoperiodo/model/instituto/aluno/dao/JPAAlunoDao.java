
package br.com.projetoperiodo.model.instituto.aluno.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;

public class JPAAlunoDao implements AlunoDao {

	private EntityManagerFactory entityManagerFactory;
	
	public JPAAlunoDao(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}
	
	@Override
	public Aluno salvar(Aluno aluno) {

		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(aluno);
		entityTransaction.commit();
		entityManager.close();
		return aluno;
	}

	@Override
	public void atualizar(Aluno aluno) {

		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(aluno);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void remover(Aluno aluno) {

		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Aluno alunoAtualizado = (Aluno) entityManager.merge(aluno);
		entityManager.remove(alunoAtualizado);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public List<Aluno> listar() {

		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		List<Aluno> alunos = entityManager.createQuery("from AlunoImpl").getResultList();
		entityManager.close();

		return alunos;
	}

	@Override
	public Aluno buscar(long primaryK) {

		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction entityTrasaction = entityManager.getTransaction();
		entityTrasaction.begin();
		Aluno aluno = entityManager.find(AlunoImpl.class, primaryK);
		entityTrasaction.commit();
		entityManager.close();

		return aluno;
	}

	@Override
	public Aluno buscarPelaMatricula(String matricula){
		
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction entityTrasaction = entityManager.getTransaction();
		entityTrasaction.begin();
		Aluno aluno = entityManager.find(AlunoImpl.class, matricula);
		entityTrasaction.commit();
		entityManager.close();

		return aluno;

	}
	
	@Override
	public Long buscarQuantidadeAlunos(long chave) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select count(*) ");
		builder.append(" from AlunoImpl a ");
		builder.append(" where a.chavePrimaria = ");
		builder.append(chave);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Long quantidade = (Long) entityManager.createQuery(builder.toString()).getSingleResult();
		entityManager.close();

		return quantidade;
	}

}
