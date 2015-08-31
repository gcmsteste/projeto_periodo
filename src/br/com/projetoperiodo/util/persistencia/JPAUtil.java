package br.com.projetoperiodo.util.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.
						createEntityManagerFactory("mysqllocal");
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
