package br.com.projetoperiodo.util.persistencia.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnectionFactory {
	private static final String PERSISTENCE_UNIT_NAME_MYSQL = "mysqllocal";
	private static final String PERSISTENCE_UNIT_NAME_ORACLE = "oraclelocal";
	
	private EntityManagerFactory factory;
	private static JPAConnectionFactory instance = null;
	
	private JPAConnectionFactory() {
		factory = Persistence.
						createEntityManagerFactory(PERSISTENCE_UNIT_NAME_MYSQL);
	}
	
	public static JPAConnectionFactory getInstance() {
		if ( instance == null ) {
			instance = new JPAConnectionFactory();
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
