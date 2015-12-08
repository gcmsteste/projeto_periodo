package br.com.projetoperiodo.util.persistencia.unidade;

import java.sql.Driver;
import java.sql.SQLException;

public class OracleDatabaseUnit implements DatabaseUnit {

	@Override
	public String getDialetoPersistenceUnit() {
		return "org.hibernate.dialect.OracleDialect";
	}

	@Override
	public String getConnectionURL() {
		return "jdbc:oracle:thin:@localhost:1521/XE";
	}

	@Override
	public String getDriverClass() {
		return "oracle.jdbc.OracleDriver";
	}

	@Override
	public Driver getDriver() throws SQLException {
		return new oracle.jdbc.OracleDriver();
	}

	@Override
	public String getUser() {
		return "PROJETO_PERIODO";
	}

	@Override
	public String getSenha() {
		return "PROJETO_PERIODO";
	}

}
