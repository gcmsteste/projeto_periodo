package br.com.projetoperiodo.util.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver( new 
							com.mysql.jdbc.Driver());
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/"
							+ "projeto_periodo", "root", "");
			connection.setAutoCommit(false);
			return connection;
		}
		catch (SQLException e ) {
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
