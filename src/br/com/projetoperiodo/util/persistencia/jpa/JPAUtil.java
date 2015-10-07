package br.com.projetoperiodo.util.persistencia.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "mysqllocal";
	private EntityManagerFactory factory;
	private static JPAUtil instance = null;
	
	private JPAUtil() {
		factory = Persistence.
						createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public static JPAUtil getInstance() {
		if ( instance == null ) {
			instance = new JPAUtil();
		}
		return instance;
	}
	
	
	public EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
	
	private void destroyFactory() {
		factory.close();
	}
	
	public static void destroyInstance() {
		if( instance != null ) {
			instance.destroyFactory();
			instance = null;
		}
	}
	
	
}
