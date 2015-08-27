
package br.com.projetoperiodo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetoperiodo.model.relatorio.RelatorioFrequencia;

public class RemoverRelatorioFrequencia extends RelatorioFrequencia {

	private Object[] colunas = new Object[10]; // conto de 1 a 10

	private int totalObjetos = 10;

	private boolean posicaoRemovida(int posicao) {

		return posicao >= 0 && posicao <= this.totalObjetos;
	}

	public void remover(int posicao) {

		if (!this.posicaoRemovida(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}

		for (int i = posicao; i < this.totalObjetos - 1; i++) {
			this.colunas[i] = this.colunas[i + 1];
		}
		//mes.setInt(0);
		//ano.setInt(0);
		//cargaHorariaMensal.setInt(0);
		//semanas.setInt(0);
		// edital
		// orientador
		// funcionario

		this.totalObjetos--;
	}

	public static void main(String[] args) {

		Connection con = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/test";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, "usuario", "senha");

			con.setAutoCommit(false);

			pstmt = con.prepareStatement("DELETE FROM users WHERE id = ?");

			pstmt.setLong(1, new Long(args[0]));

			pstmt.executeUpdate();

			con.commit();

		}

		catch (ClassNotFoundException ex) {

		}

		catch (SQLException ex) {

		}

		finally {

			//ex.printStackTrace();

			try {

				con.rollback();

			}

			catch (SQLException ex1) {

				ex1.printStackTrace();

			}

			try {

				if (rs != null) rs.close();

				if (pstmt != null) pstmt.close();

				if (con != null) con.close();

			}

			catch (SQLException ex) {

				ex.printStackTrace();

			}

		}

	}

}
