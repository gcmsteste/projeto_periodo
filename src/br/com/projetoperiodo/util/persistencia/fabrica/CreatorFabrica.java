package br.com.projetoperiodo.util.persistencia.fabrica;

public class CreatorFabrica {
	
	public static final String FABRICA_JPA = "FABRICA_DAO";
	public static final String FABRICA_JDBC = "FABRICA_JDBC";
	private static FabricaDAO fabrica = null;
	
	public static FabricaDAO criarFabricaDAO(String tipo)  {
		
		if (FABRICA_JDBC.equals(tipo)) {
			fabrica = FabricaJDBC.getInstance();
		} else if ( FABRICA_JPA.equals(tipo)) {
			fabrica =  FabricaJPA.getInstance();
		} else {
			fabrica =  FabricaJPA.getInstance();
		}
		return fabrica;
	}
	
	public static FabricaDAO getFabricaDAO() {
		if( fabrica == null ) {
			return criarFabricaDAO(CreatorFabrica.FABRICA_JPA);
		}
		return fabrica;
	}

}
