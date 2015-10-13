package br.com.projetoperiodo.model.instituto.disciplina.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class JPADisciplinaDao implements DisciplinaDao{

	@Override
	public void salvar(Disciplina disciplina) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(disciplina);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void atualizar(Disciplina disciplina) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(disciplina);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public void remover(Disciplina disciplina) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Disciplina disciplinaAtualizada = (Disciplina)entityManager.merge(disciplina);
		entityManager.remove(disciplinaAtualizada);
		entityTransaction.commit();
		entityManager.close();
	}

	@Override
	public List<Disciplina> listar() {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		List<Disciplina> disciplinas = entityManager.createQuery("from DisciplinaImpl").getResultList();
		entityManager.close();
		
		return disciplinas;
	}

	@Override
	public Disciplina buscar(int primaryK) {
		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Disciplina disciplina = entityManager.find(DisciplinaImpl.class, primaryK);
		entityTransaction.commit();
		entityManager.close();
		
		return disciplina;
	}

	@Override
	public EntidadeNegocio buscar(HashMap<String, Object> filter) throws NegocioException {

		EntityManager entityManager =  JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery  criteria = builder.createQuery(DisciplinaImpl.class);
		Root root = criteria.from(DisciplinaImpl.class);
		
		if ( filter.containsKey(Disciplina.ATRIBUTO_DESCRICAO) ) {
			criteria.where( builder.like(root.get(Disciplina.ATRIBUTO_DESCRICAO), 
							(String)filter.get(Disciplina.ATRIBUTO_DESCRICAO)) );
		}
		Disciplina disciplina;
		try {
			disciplina =  (Disciplina) entityManager.createQuery(criteria).getSingleResult();
		} catch( NoResultException e ) {
			throw new NegocioException(Constantes.ENTIDADE_NAO_ENCONTRADA);
		}
		entityManager.close();
		return disciplina;
	}

}
