package br.com.projetoperiodo.model.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class JPAUsuarioDao implements UsuarioDao
{

	@Override
	public void salvar(Usuario usuario) {

		EntityManager entityManager = 
						JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(usuario);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public void atualizar(Usuario usuario) {

		EntityManager entityManager = 
						JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(usuario);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Usuario usuario) {

		EntityManager entityManager = 
						JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(usuario);
		entityTransaction.commit();
		entityManager.close();
		
	}

	@Override
	public List<Usuario> listar() {

		EntityManager entityManager = 
						JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Usuario> usuarios = entityManager.createQuery("from Usuario").getResultList();
		entityManager.close();
		return usuarios;
	}

}
