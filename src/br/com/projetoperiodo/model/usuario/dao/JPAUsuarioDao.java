package br.com.projetoperiodo.model.usuario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;

public class JPAUsuarioDao implements UsuarioDao {

	@Override
	public void salvar(Usuario usuario) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(usuario);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void atualizar(Usuario usuario) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(usuario);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Usuario usuario) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Object object = entityManager.merge(usuario);
		entityManager.remove(object);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public List<Usuario> listar() {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Usuario> usuarios = entityManager.createQuery("from UsuarioImpl").getResultList();
		entityManager.close();
		return usuarios;
	}

	

	@Override
	public Usuario buscar(String login) {
		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		Query query = entityManager.
				createQuery("select u from UsuarioImpl u "
						  + "where u.login = :login");
		query.setParameter("login", login);
		Usuario usuario = (Usuario)query.getSingleResult();
		entityManager.close();
		return usuario;
	}

	@Override
	public Usuario buscar(long l) {
		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		Usuario usuario = (Usuario) entityManager.find(UsuarioImpl.class, l);
		entityManager.close();
		return usuario;
	}

}
