package br.com.projetoperiodo.model.aluno;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.AlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.JPAAlunoDao;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;
import br.com.projetoperiodo.util.persistencia.JPAUtil;

public class TesteAlunoDao {

	private static AlunoDao dao;

	@BeforeClass
	public static void setUp() {
		dao = new JPAAlunoDao();

	}

	@Test
	public void testeInserirAluno() {
		int quantidadeInicio = dao.listar().size();
		dao.salvar(montarObjetoAluno());
		int quantidadeFim = dao.listar().size();
		Assert.assertEquals(quantidadeInicio + 1, quantidadeFim);
	}

	@Test
	public void testeRemoverAluno() {
		Aluno aluno = montarObjetoAluno();
		dao.salvar(aluno);
		int quantidadeInicio = dao.listar().size();
		dao.remover(aluno);
		int quantidadeFim = dao.listar().size();
		Assert.assertEquals(quantidadeInicio - 1, quantidadeFim);
	}

	@Test
	public void testeAtualizarAluno() {
		Aluno alunoInserido = montarObjetoAluno();
		dao.salvar(alunoInserido);

		Aluno alunoPesquisado = dao.buscar(alunoInserido.getId());
		String senhaAntiga = alunoPesquisado.getSenha();
		alunoPesquisado.setSenha(Util.criptografarSenha("admin321", Util.CONSTANTE_CRIPTOGRAFIA));
		dao.atualizar(alunoPesquisado);
		String senhaNova = dao.buscar(alunoPesquisado.getId()).getSenha();
		Assert.assertNotNull(senhaNova);
		Assert.assertNotEquals(senhaAntiga, senhaNova);
	}

	@AfterClass
	public static void tearDown() {
		JPAUtil.closeEntityManagerFactory();
	}

	public Aluno montarObjetoAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula("20141Y6-RC0323");
		aluno.setNome("Douglas");
		aluno.setLogin("Doug");
		aluno.setEmail("Douglas@gmail.com");
		aluno.setSenha(Util.criptografarSenha("admin123", Util.CONSTANTE_CRIPTOGRAFIA));
		Curso curso = (Curso) FabricaJPA.getInstancia().buscar(Curso.class);
		aluno.setCurso(curso);
		return aluno;
	}

	

}
