package br.com.projetoperiodo.util.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAUtil {
	private static EntityManagerFactory factory;
	static {
		try {
			factory = Persistence.
							createEntityManagerFactory("mysqllocal");
		} catch( Throwable e) {
			e.printStackTrace();
		
		}
		
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
	
	public static void closeEntityManagerFactory() {
		factory.close();
	}
	
	
}
