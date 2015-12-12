package br.com.projetoperiodo.model.documento.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDocumentDao implements DocumentDao {

	private Connection connection;
	
	public JDBCDocumentDao(Connection cn) {
		this.connection = cn;
	}
	@Override
	public void salvar(String fileName) {
		int len;
		String query;
		PreparedStatement pstmt;
		try {
	
			URL url = getClass().getResource(fileName);
			File file = new File(url.getPath());
			FileInputStream fis = new FileInputStream(file);
			len = (int) file.length();
			query = ("insert into PROJETO_PERIODO.TEMPLATE_DOCUMENTO (TEMPLATE_NOME, TEMPLATE_CONTENT) VALUES(?,?)");
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, file.getName());
			pstmt.setBinaryStream(2, fis, len);
			pstmt.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public InputStream buscar() {
		InputStream is = null;
		String sql = "SELECT TEMPLATE_CONTENT FROM PROJETO_PERIODO.TEMPLATE_DOCUMENTO";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				is = resultSet.getBinaryStream(1);
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return is;
	}
	
}
