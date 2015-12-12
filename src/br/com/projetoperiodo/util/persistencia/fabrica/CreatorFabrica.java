package br.com.projetoperiodo.util.persistencia.fabrica;

import br.com.projetoperiodo.util.persistencia.persistencia.DatabaseUnit;

public class CreatorFabrica {
	
	public static final String FABRICA_JPA = "FABRICA_DAO";
	public static final String FABRICA_JDBC = "FABRICA_JDBC";
	
	public static FabricaDAO criarFabricaDAO(String tipo, DatabaseUnit unit, FabricaDAO dao)  {
		
		if (FABRICA_JDBC.equals(tipo)) {
			return  new AdapterFabricaJDBC(unit, dao);
		} else if ( FABRICA_JPA.equals(tipo)) {
			return  new FabricaJPA(unit);
		} 
		return null;
	}
	
	

}
