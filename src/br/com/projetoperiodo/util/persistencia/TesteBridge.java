
package br.com.projetoperiodo.util.persistencia;

import javax.persistence.EntityManagerFactory;

import java.sql.Connection;

import br.com.projetoperiodo.util.persistencia.connection.ConnectionFactory;
import br.com.projetoperiodo.util.persistencia.connection.JDBCConnectionFactory;
import br.com.projetoperiodo.util.persistencia.connection.JPAConnectionFactory;
import br.com.projetoperiodo.util.persistencia.persistencia.MySQLDatabaseUnit;
import br.com.projetoperiodo.util.persistencia.persistencia.OracleDatabaseUnit;

public class TesteBridge {

	public static void main(String[] args) {

		/* MySQL */
		ConnectionFactory factory = new JDBCConnectionFactory(new MySQLDatabaseUnit());
		Connection connection = (Connection) factory.getConnection();
		factory = new JPAConnectionFactory(new OracleDatabaseUnit());
		EntityManagerFactory entity = (EntityManagerFactory) factory.getConnection();
		entity.close();

		/* Oracle */
		factory = new JDBCConnectionFactory(new OracleDatabaseUnit());
		connection = (Connection) factory.getConnection();
		factory = new JPAConnectionFactory(new OracleDatabaseUnit());
		entity = (EntityManagerFactory) factory.getConnection();
	}
}
