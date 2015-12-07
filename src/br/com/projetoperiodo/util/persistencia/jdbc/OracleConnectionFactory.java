package br.com.projetoperiodo.util.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class OracleConnectionFactory  {

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:mkyong", "projeto_periodo", "projeto_periodo");
			connection.setAutoCommit(false);
			return connection;
		}
		catch (SQLException e ) {
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {

		ConnectionFactory connection = new AdapterConnectionFactory();
		try {
			connection.getConnection().getSchema();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
