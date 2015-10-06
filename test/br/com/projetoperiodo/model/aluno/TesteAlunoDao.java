package br.com.projetoperiodo.model.aluno;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.dao.JPAAlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.curso.impl.CursoImpl;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;

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
		AlunoImpl alunoInserido = montarObjetoAluno();
		dao.salvar(alunoInserido);
	
		AlunoImpl alunoPesquisado = (AlunoImpl) dao.buscar(alunoInserido.getChavePrimaria());
		String senhaAntiga = alunoPesquisado.getSenha();
		String novaSenha = "admin321";
		alunoPesquisado.setSenha(Util.criptografarSenha(novaSenha, novaSenha, Constantes.CONSTANTE_CRIPTOGRAFIA));
		dao.atualizar(alunoPesquisado);
		String senhaNova = ((AlunoImpl) dao.buscar(alunoPesquisado.getChavePrimaria())).getSenha();
		Assert.assertNotNull(senhaNova);
		Assert.assertNotEquals(senhaAntiga, senhaNova);
	}

	@AfterClass
	public static void tearDown() {
		FabricaJPA.getInstancia().closeEntityManagerFactory();
	}

	public AlunoImpl montarObjetoAluno() {
		AlunoImpl aluno = new AlunoImpl();
		Curso curso = (Curso) FabricaJPA.getInstancia().buscar(CursoImpl.class);
		aluno.setCurso(curso);
		Usuario usuario = (Usuario) aluno;
		aluno.setMatricula("20141Y6-RC0323");
		usuario.setNome("Douglas");
		usuario.setLogin("Doug");
		usuario.setEmail("Douglas@gmail.com");
		String novaSenha = "admin321";
		usuario.setSenha(Util.criptografarSenha(novaSenha, novaSenha, Constantes.CONSTANTE_CRIPTOGRAFIA));
		
		return aluno;
	}

	

}
