
package br.com.projetoperiodo.util.persistencia.fabrica;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projetoperiodo.model.documento.dao.DocumentDao;
import br.com.projetoperiodo.model.documento.dao.JDBCDocumentDao;
import br.com.projetoperiodo.model.instituto.curso.dao.CursoDao;
import br.com.projetoperiodo.model.instituto.curso.dao.JDBCCursoDao;
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
	public DocumentDao criarDocumentDao() {

		return new JDBCDocumentDao(this.connection);
	}
	
	@Override
	public void fecharFabrica() {
	
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
