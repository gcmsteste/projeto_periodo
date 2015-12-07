
package br.com.projetoperiodo.util.persistencia.jdbc;

import java.sql.Connection;

public interface ConnectionFactory {

	Connection getConnection();
}
