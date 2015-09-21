package br.com.projetoperiodo.model.disciplina;

import org.junit.*;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.JPADisciplinaDao;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class TesteDisciplinaDao {

	JPADisciplinaDao dao;
	@BeforeClass
	public void setUp(){
		dao = new JPADisciplinaDao();
	}

	@Test
	public void testeInserirDisciplina(){
		int quantidadeInicio = dao.listar().size();
		dao.salvar(montarObjetoDisciplina());
		int quantidadeFim = dao.listar().size();
		Assert.assertEquals(quantidadeInicio + 1,quantidadeFim);

	}

	@Test
	public void TesteRemoverDisciplina(){
		Disciplina disciplina = new Disciplina();
		dao.salvar(disciplina);
		int quantidadeInicio = dao.listar().size();
		dao.remover(disciplina);
		int quantidadeFim = dao.listar().size();
		Assert.assertEquals(quantidadeInicio - 1, quantidadeFim);
	}

	@Test
	public void TesteAtualizarDisciplina(){
		
	}

	@AfterClass
	public static void tearDown(){
		JPAUtil.closeEntityManagerFactory();
	}

	/*public Disciplina montarObjetoDisciplina(){
		Disciplina disciplina = new Disciplina();
			disciplina.setCurso();
			disciplina.setDescricao("Redes de computadores");
			disciplina.setPagantes();
			
		return disciplina;
	}*/



}