
package br.com.projetoperiodo.util.persistencia.unidade;

import java.sql.Driver;
import java.sql.SQLException;

public class MySQLPersistenceUnit implements DatabaseUnit {

	@Override
	public String getDialetoPersistenceUnit() {

		return "org.hibernate.dialect.MySQLDialect";
	}

	@Override
	public String getConnectionURL() {

		return "jdbc:mysql://localhost:3306/projeto_periodo";
	}

	@Override
	public String getDriverClass() {

		return "com.mysql.jdbc.Driver";
	}

	@Override
	public Driver getDriver() throws SQLException {

		return new com.mysql.jdbc.Driver();
	}

	@Override
	public String getUser() {
		return "projeto_periodo";
	}

	@Override
	public String getSenha() {
		return "projeto_periodo";
	}

}
