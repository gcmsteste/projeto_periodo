package br.com.projetoperiodo.util.persistencia;

import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.dao.FabricaDAO;
import br.com.projetoperiodo.util.persistencia.jdbc.FabricaJDBC;
import br.com.projetoperiodo.util.persistencia.jpa.FabricaJPA;

public class CreatorFabrica {
	
	public static final String FABRICA_JPA = "FABRICA_DAO";
	public static final String FABRICA_JDBC = "FABRICA_JDBC";
	
	public static FabricaDAO createFactory(String tipo)  {
		
		if (FABRICA_JDBC.equals(tipo)) {
			return new FabricaJDBC();
		} else if ( FABRICA_JPA.equals(tipo)) {
			return new FabricaJPA();
		} else {
			return new FabricaJPA();
		}
		
	}
}
