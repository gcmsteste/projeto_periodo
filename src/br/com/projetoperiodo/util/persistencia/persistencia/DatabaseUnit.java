package br.com.projetoperiodo.util.persistencia.persistencia;

import java.sql.Driver;
import java.sql.SQLException;

public interface DatabaseUnit {

	String getDialetoPersistenceUnit();
	String getConnectionURL();
	String getDriverClass();
	Driver getDriver() throws SQLException;
	String getUser();
	String getSenha();
	
}
