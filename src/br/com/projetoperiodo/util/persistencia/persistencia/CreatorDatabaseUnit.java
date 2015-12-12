package br.com.projetoperiodo.util.persistencia.persistencia;

public class CreatorDatabaseUnit {

	public static final String MYSQL_LOCAL_UNIT = "MYSQL_LOCAL_UNIT";
	public static final String ORACLE_LOCAL_UNIT = "ORACLE_LOCAL_UNIT";
	
	public static DatabaseUnit criarDatabaseUnit(String tipo)  {
		
		if (MYSQL_LOCAL_UNIT.equals(tipo)) {
			return new MySQLDatabaseUnit();
		} else if ( ORACLE_LOCAL_UNIT.equals(tipo)) {
			return new OracleDatabaseUnit();
		}
		return null;
	}
}
