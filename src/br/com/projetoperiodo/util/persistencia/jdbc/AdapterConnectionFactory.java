package br.com.projetoperiodo.util.persistencia.jdbc;

import java.sql.Connection;

public class AdapterConnectionFactory extends MySQLConnectionFactory implements ConnectionFactory{
	
	public AdapterConnectionFactory() { }
	public Connection getConnection() {
		return super.getConnection();
	}
	
}
