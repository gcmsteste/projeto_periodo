package orientador;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.orientador.Orientador;
import br.com.projetoperiodo.model.instituto.orientador.OrientadorDao;
import br.com.projetoperiodo.model.instituto.orientador.HibernateOrientadorDao;
import br.com.projetoperiodo.model.instituto.orientador.JPAOrientadorDao;
import br.com.projetoperiodo.util.persistencia.HibernateUtil;

public class TestOrientadorDao 
{
			private JPAOrientadorDao orientadorDao;

			@BeforeClass
			public void setUp() 
			{

				orientadorDao = new JPAOrientadorDao();
			}

			@Test
			public void testeInserirOrientador() 
			{
				int quantInicio = orientadorDao.listar().size();
				orientadorDao.salvar(montarObjetoOrientador());
				int quantdFim = orientadorDao.listar().size();
				Assert.assertEquals(quantInicio + 1, quantdFim);
			}
			

			@Test
			public void testeRemoverOrientador() 
			{
				Orientador orientadorInserido = montarObjetoOrientador();
				orientadorDao.salvar(orientadorInserido);
				
				int quantdInicio = orientadorDao.listar().size();
				orientadorDao.remover(orientadorInserido);
				int quantdFim = orientadorDao.listar().size();
				Assert.assertEquals(quantdInicio - 1, quantdFim);
			}

			private Orientador montarObjetoOrientador() 
			{
				Orientador orientador = new Orientador();
				orientador.setDescricao( "Orientador do aluno" );
				orientador.setDescricaoAbreviada("ODA");
				return orientador;
			}

			@AfterClass
			public void close() 
			{
				
			}
		}

