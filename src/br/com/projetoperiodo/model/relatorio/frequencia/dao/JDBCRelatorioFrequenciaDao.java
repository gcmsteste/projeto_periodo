package br.com.projetoperiodo.model.relatorio.frequencia.dao;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.projetoperiodo.model.relatorio.atividade.Atividade;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.util.constantes.enumeracoes.Situacao;


public class JDBCRelatorioFrequenciaDao implements RelatorioFrequenciaDao {

	Connection connection;

	public JDBCRelatorioFrequenciaDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public RelatorioFrequencia salvar(RelatorioFrequencia relatorio) {

		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO PROJETO_PERIODO.RELATORIO_FREQUENCIA ");
		builder.append(" (RELATORIO_MES, RELATORIO_CARGA_HORARIA, MONITOR_ID) ");
		builder.append(" VALUES(?, ?, ?) ");
		PreparedStatement ptmt = null;
		ResultSet generatedKeys = null;
		try {
			
			ptmt = connection.prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
			ptmt.setInt(1, relatorio.getMes());
			ptmt.setInt(2, relatorio.getCargaHorariaMensal());
			ptmt.setLong(3, relatorio.getMonitor().getChavePrimaria());
			ptmt.executeUpdate();
			connection.commit();
			generatedKeys = ptmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				relatorio.setChavePrimaria(generatedKeys.getLong(1));
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ee) {
				throw new RuntimeException(ee);
			}
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return relatorio;
	}

	

	@Override
	public RelatorioFrequencia atualizar(RelatorioFrequencia relatorio) {


		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE PROJETO_PERIODO.RELATORIO_FREQUENCIA ");
		builder.append(" SET RELATORIO_MES = ?, RELATORIO_CARGA_HORARIA = ?, MONITOR_ID = ? ");
		builder.append(" WHERE RELATORIO_ID = ? ");
		PreparedStatement ptmt = null;
		ResultSet generatedKeys = null;
		try {
			
			ptmt = connection.prepareStatement(builder.toString());
			ptmt.setInt(1, relatorio.getMes());
			ptmt.setInt(2, relatorio.getCargaHorariaMensal());
			ptmt.setLong(3, relatorio.getMonitor().getChavePrimaria());
			ptmt.setLong(4, relatorio.getChavePrimaria());
			ptmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException ee) {
				throw new RuntimeException(ee);
			}
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return relatorio;
	}

	@Override
	public void remover(RelatorioFrequencia relatorio) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RelatorioFrequencia> listar(String condicao) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RelatorioFrequencia buscar(long primaryKey) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String condicao) {

		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Situacao> listarSituacaoDosRelatorios(String condicao) {

		// TODO Auto-generated method stub
		return null;
	}
}