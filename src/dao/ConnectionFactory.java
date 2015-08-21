package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver( new 
							com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/"
							+ "projeto_periodo", "root", "eddiemanoel234@@");
		}
		catch (SQLException e ) {
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
