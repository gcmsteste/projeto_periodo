package br.com.projetoperiodo.model.instituto.curso.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;
import br.com.projetoperiodo.util.fachada.Fachada;

public class JDBCCursoDao implements CursoDao{

	private Connection connection;
	
	public JDBCCursoDao(Connection cn){
		this.connection = cn;
	}
	
	@Override
	public void salvar(Curso curso) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO PROJETO_PERIODO.CURSO ");
		builder.append(" (GRAU, CURSO_DS) ");
		builder.append(" VALUES(?,?) ");
		PreparedStatement ptmt = null;
		ResultSet generatedKeys = null;
		try{
			
			ptmt = connection.prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);	
			ptmt.setString(1, curso.getModalidade().name());
			ptmt.setString(2, curso.getDescricao());
			ptmt.executeUpdate();
			connection.commit();
			generatedKeys = ptmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				curso.setChavePrimaria(generatedKeys.getLong(1));
			}
		}catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ee) {
				throw new RuntimeException(ee);
			}
		} finally {
			try {
				ptmt.close();
				generatedKeys.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}	
		
	@Override
	public void remover(Curso curso) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(" DELETE FROM PROJETO_PERIODO.CURSO ");
		builder.append(" WHERE CURSO_ID = ? ");
		PreparedStatement ptmt = null;
		try{

			ptmt = connection.prepareStatement(builder.toString());
			ptmt.setLong(1, curso.getChavePrimaria());
			ptmt.executeUpdate();
			connection.commit();	
		}catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ee) {
				throw new RuntimeException(ee);
			}
		} finally {
			try {
				if (ptmt != null) ptmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}

	@Override
	public void atualizar(Curso curso) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE PROJETO_PERIODO.CURSO ");
		builder.append(" SET GRAU = ?, CURSO_DS = ? ");
		builder.append(" WHERE CURSO_ID = ? ");
		PreparedStatement ptmt = null;
		try{
			
			ptmt = connection.prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);	
			ptmt.setString(1, curso.getModalidade().name());
			ptmt.setString(2, curso.getDescricao());
			ptmt.setLong(3, curso.getChavePrimaria());
			ptmt.executeUpdate();
			connection.commit();
		}catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ee) {
				throw new RuntimeException(ee);
			}
		} finally {
			try {
				if (ptmt != null) ptmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Curso buscar(long primaryKey) {

		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT * FROM PROJETO_PERIODO.CURSO ");
		builder.append(" WHERE CURSO_ID = ? ");
		PreparedStatement ptmt = null;
		ResultSet result = null;
		Curso curso = null;
		try{
			
			ptmt = connection.prepareStatement(builder.toString());
			ptmt.setLong(1, primaryKey);
			result = ptmt.executeQuery();
			
			if(result.next()){
				curso = (Curso) Fachada.getInstance().criarCurso();
				curso.setChavePrimaria(result.getLong("CURSO_ID"));
				curso.setModalidade(Grau.valueOf(result.getString("GRAU")));// TODO verificar se isto é correto - ter um método auxiliar Static! R: Tem o método valueOf
				curso.setDescricao(result.getString("CURSO_DS"));
				curso.setUltimaAlteracao(result.getDate("ULTIMA_ALTERACAO"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (ptmt != null) ptmt.close();
				if (result != null) result.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return curso;
	}
	// TODO: Fazer listar -> SELECT * FROM CURSO
	@Override
	public List<Curso> listar() {
		
		return null;
	}

	

}
