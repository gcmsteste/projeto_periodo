package br.com.projetoperiodo.util.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FabricaJPA {

	private static FabricaJPA instancia = null;
	private EntityManagerFactory factory;
	
	private FabricaJPA() {
		factory = Persistence.
				createEntityManagerFactory("mysqllocal");
	}
	
	public static FabricaJPA getInstancia() {
		if ( instancia == null ) {
			instancia = new FabricaJPA();
		}
		return instancia;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
	
	public void closeEntityManagerFactory() {
		factory.close();
	}
	
	public Object buscar(Class entity) {
		EntityManager entityManager = getEntityManagerFactory().
				createEntityManager();
		Query query = entityManager.createQuery("from " + entity.getSimpleName());
		return query.getSingleResult();
	}
}
