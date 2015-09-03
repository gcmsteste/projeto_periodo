package br.com.projetoperiodo.model.instituto.funcionario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPAFuncionarioDao implements FuncionarioDao{

	@Override
	public List<Funcionario> listar() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		List<Funcionario> funcionarios = entityManager.createQuery("from Funcionario").getResultList();
		entityManager.close();
		
		return funcionarios;
	}

	@Override
	public void salvar(Funcionario funcionario) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(funcionario);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Funcionario funcionario) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Funcionario funcionarioAtualizado = (Funcionario)entityManager.merge(funcionario);
		entityManager.remove(funcionarioAtualizado);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(funcionario);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public Funcionario buscar(int primaryK) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Funcionario funcionario = entityManager.find(Funcionario.class, primaryK);
		entityTransaction.commit();
		entityManager.close();
		
		return funcionario;
	}

}
