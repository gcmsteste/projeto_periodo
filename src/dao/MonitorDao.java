package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import model.Monitor;
import util.constantes.Modalidade;

public class MonitorDao implements DAO
{
	Connection connection;
	
	public void MonitorDao(Connection connection) {
		this.connection = connection;
	}
	@Override
	public void inserir(Object object) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Object object) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Object object) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Object> listar() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object buscar(Object object) {

		final String SQL = "SELECT * "
						 + "FROM MONITOR AS M "
						 + "INNER JOIN ALUNO AS A ON A.ALUNO_MATRICULA = M.ALUNO_MATRICULA "
						 + "INNER JOIN USUARIO AS U ON U.USUARIO_LOGIN = A.USUARIO_LOGIN "
						 + "WHERE M.ALUNO_MATRICULA = ?";
		String matricula = (String)object;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		Monitor monitor = null;
		try {
			ptmt = connection.prepareStatement(SQL);
			ptmt.setString( 1, matricula );
			rs = ptmt.executeQuery();
			while ( rs.next() ) {
				monitor = new Monitor();
				monitor.setNome(rs.getString("USUARIO_NOME"));
				monitor.setLogin(rs.getString("USUARIO_LOGIN"));
				monitor.setSenha(rs.getString("USUARIO_SENHA"));
				monitor.setEmail(rs.getString("USUARIO_EMAIL"));
				monitor.setMatricula(rs.getString("ALUNO_MATRICULA"));
				monitor.setModalidade(Modalidade.valueOf(rs.getString("MODALIDADE")));
			}
		} catch( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e ) {
				throw new RuntimeException(e);
			}
		}
		return monitor;
	}

}
