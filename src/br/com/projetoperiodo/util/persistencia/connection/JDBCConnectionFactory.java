
package br.com.projetoperiodo.util.persistencia.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import br.com.projetoperiodo.util.persistencia.unidade.DatabaseUnit;

public class JDBCConnectionFactory implements ConnectionFactory {

	private DatabaseUnit databaseUnit;

	private JDBCConnectionFactory() {
	}

	public JDBCConnectionFactory(DatabaseUnit unit) {
		this.databaseUnit = unit;
	}

	@Override
	public Object getConnection() {
		try {		
			Class.forName(databaseUnit.getDriverClass());
			DriverManager.registerDriver(databaseUnit.getDriver());
			Connection connection = DriverManager.getConnection(databaseUnit.getConnectionURL(), databaseUnit.getUser(),
							databaseUnit.getSenha());
			connection.setAutoCommit(false);
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
