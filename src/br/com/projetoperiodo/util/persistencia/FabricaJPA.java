package br.com.projetoperiodo.util.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
