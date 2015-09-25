package br.com.projetoperiodo.model.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.projetoperiodo.util.persistencia.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

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
		List<Usuario> usuarios = entityManager.createQuery("from Usuario").getResultList();
		entityManager.close();
		return usuarios;
	}

	@Override
	public Usuario buscar(int primaryKey) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		Usuario usuario = entityManager.find(Usuario.class, primaryKey);
		entityManager.close();
		return usuario;
	}

	@Override
	public Usuario buscar(String nome) {
		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		Usuario usuario = (Usuario) entityManager.
				createQuery("select u from Usuario u "
						  + "where u.login := login").getSingleResult();
		entityManager.close();
		return usuario;
	}

}
