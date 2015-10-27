package br.com.projetoperiodo.model.documentos;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.projetoperiodo.util.persistencia.jdbc.ConnectionFactory;

public class JDBCPdfDao implements DocumentDao {

	@Override
	public void salvar(String fileName) {
		int len;
        String query;
       PreparedStatement pstmt;
        Connection cn = new ConnectionFactory().getConnection();
         
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            len = (int)file.length();
            query = ("insert into PROJETO_PERIODO.DOCUMENTOS VALUES(?,?)");
            pstmt = cn.prepareStatement(query);
            pstmt.setString(1,file.getName());
            pstmt.setInt(2, len);
             
            //method to insert a stream of bytes
            pstmt.setBinaryStream(3, fis, len); 
            pstmt.executeUpdate();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public OutputStream buscar() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		
	}
	
}
