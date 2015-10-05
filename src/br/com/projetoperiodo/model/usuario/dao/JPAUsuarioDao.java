
package br.com.projetoperiodo.model.usuario.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;

public class JPAUsuarioDao implements UsuarioDao {

	@Override
	public void salvar(Usuario usuario) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(usuario);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public void atualizar(Usuario usuario) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(usuario);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Usuario usuario) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Object object = entityManager.merge(usuario);
		entityManager.remove(object);
		entityTransaction.commit();
		entityManager.close();

	}

	@Override
	public List<Usuario> listar() {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Usuario> usuarios = entityManager.createQuery("from UsuarioImpl").getResultList();
		entityManager.close();
		return usuarios;
	}

	@Override
	public Usuario buscar(String login) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory().createEntityManager();
		Query query = entityManager.createQuery("select u from UsuarioImpl u " + "where u.login = :login");
		query.setParameter("login", login);
		Usuario usuario = (Usuario) query.getSingleResult();
		entityManager.close();
		return usuario;
	}

	@Override
	public Usuario buscar(long l) {

		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory().createEntityManager();
		Usuario usuario = (Usuario) entityManager.find(UsuarioImpl.class, l);
		entityManager.close();
		return usuario;
	}

	@Override
	public Usuario buscar(HashMap<String, Object> filter) throws NegocioException {
		EntityManager entityManager = FabricaJPA.getInstancia().getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery  criteria = builder.createQuery(UsuarioImpl.class);
		Root root = criteria.from(UsuarioImpl.class);
		
		if ( filter.containsKey(Usuario.ATRIBUTO_USUARIO_EMAIL) ) {
			criteria.where( builder.like(root.get(Usuario.ATRIBUTO_USUARIO_EMAIL), 
							(String)filter.get(Usuario.ATRIBUTO_USUARIO_EMAIL)) );
		}
		Usuario usuario;
		try {
			usuario =  (Usuario) entityManager.createQuery(criteria).getSingleResult();
		} catch( NoResultException e ) {
			throw new NegocioException(Constantes.ENTIDADE_NAO_ENCONTRADA);
		}
		entityManager.close();
		return usuario;
	}
	
}
