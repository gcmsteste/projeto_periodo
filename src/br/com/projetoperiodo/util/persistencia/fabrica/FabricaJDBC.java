
package br.com.projetoperiodo.util.persistencia.fabrica;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.JDBCCursoDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.JDBCPeriodoDao;
import br.com.projetoperiodo.model.instituto.periodo.dao.PeriodoDao;
import br.com.projetoperiodo.model.usuario.dao.JDBCUsuarioDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.util.persistencia.connection.JDBCConnectionFactory;
import br.com.projetoperiodo.util.persistencia.persistencia.DatabaseUnit;

public abstract class FabricaJDBC extends FabricaDAO {
	
	private Connection connection;
	
	public FabricaJDBC(DatabaseUnit unit) {
		super.connectionFactory = new JDBCConnectionFactory(unit);
		connection = (Connection) super.connectionFactory.getConnection();
	}


	@Override
	public UsuarioDao criarUsuarioDAO() {

		return new JDBCUsuarioDao(this.connection);
	}

	
	@Override
	public CursoDao criarCursoDAO() {

		return new JDBCCursoDao(this.connection);
	}
	
	@Override
	public PeriodoDao criarPeriodoDao() {
	
		return new JDBCPeriodoDao(this.connection);
	}
	
	@Override
	public void fecharFabrica() {
	
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
