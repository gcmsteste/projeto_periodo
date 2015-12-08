package br.com.projetoperiodo.model.instituto.curso.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.Connection;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.enumeracoes.Grau;
import br.com.projetoperiodo.util.persistencia.connection.JDBCConnectionFactory;
import br.com.projetoperiodo.util.persistencia.unidade.MySQLDatabaseUnit;

public class TesteJDBCCursoDao {
	
	Curso curso = null;
	
	@BeforeClass
	public void inicializa(){
		curso = (Curso) Fachada.getInstance().criarCurso();
		curso.setModalidade(Grau.SUPERIOR);
		curso.setDescricao("Gestão Ambiental");
	}
	
	
	@Test
	public void testaSalvar(){
		
		MySQLDatabaseUnit mySQL = new MySQLDatabaseUnit();
		Connection con = (Connection) new JDBCConnectionFactory(mySQL);
		JDBCCursoDao jdbc = new JDBCCursoDao(con);
		
		jdbc.salvar(curso);
	}
	
	@Test
	public void testaAtualizar(){
		
		Long n = (long) 2; 
		curso.setChavePrimaria(n);
		curso.setDescricao("Gestão em turismo");
		
		
		MySQLDatabaseUnit mySQL = new MySQLDatabaseUnit();
		Connection con = (Connection) new JDBCConnectionFactory(mySQL);
		JDBCCursoDao jdbc = new JDBCCursoDao(con);
		
		jdbc.atualizar(curso);
	}
	
	@Test
	public void testaRemover(){
		
		Long n = (long) 2; 
		curso.setChavePrimaria(n);
		
		MySQLDatabaseUnit mySQL = new MySQLDatabaseUnit();
		Connection con = (Connection) new JDBCConnectionFactory(mySQL);
		JDBCCursoDao jdbc = new JDBCCursoDao(con);
		
		
		jdbc.remover(curso);
	}
	
	
}
