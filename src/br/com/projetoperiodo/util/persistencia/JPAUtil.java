package br.com.projetoperiodo.util.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	static {
		try {
			factory = Persistence.
							createEntityManagerFactory("mysqllocal");
			System.out.println("novo");
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
