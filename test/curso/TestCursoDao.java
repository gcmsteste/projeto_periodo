package curso;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.CursoDao;
import br.com.projetoperiodo.model.instituto.curso.HibernateCursoDao;
import br.com.projetoperiodo.model.instituto.curso.JPACursoDao;
import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class TestCursoDao 
{
		private CursoDao cursoDao;

		@BeforeClass
		public void setUp() 
		{

			cursoDao = new JPACursoDao();
		}

		@Test
		public void testeInserirCurso() 
		{
			int quantInicio = cursoDao.listar().size();
			cursoDao.salvar(montarObjetoCurso());
			int quantdFim = cursoDao.listar().size();
			Assert.assertEquals(quantInicio + 1, quantdFim);
		}
		

		@Test
		public void testeRemoverCurso() 
		{
			Curso cursoInserido = montarObjetoCurso();
			cursoDao.salvar(cursoInserido);
			
			int quantdInicio = cursoDao.listar().size();
			cursoDao.remover(cursoInserido);
			int quantdFim = cursoDao.listar().size();
			Assert.assertEquals(quantdInicio - 1, quantdFim);
		}

		private Curso montarObjetoCurso() 
		{
			Curso curso = new Curso();
			curso.setDescricao( "Curso do aluno" );
			curso.setDescricaoAbreviada("CDA");
			return curso;
		}

		@AfterClass
		public void close() {
			
		}
	}


