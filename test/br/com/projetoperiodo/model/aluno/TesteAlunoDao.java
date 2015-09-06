package br.com.projetoperiodo.model.aluno;

import org.junit.*;
import org.junit.Assert;


import br.com.projetoperiodo.model.instituto.aluno.*;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.persistencia.JPAUtil;


public class TesteAlunoDao{

	AlunoDao dao;
	@BeforeClass
	public void setUp(){
		dao = new JPAAlunoDao();
		
	}
	
	@Test
	public void testeInserirAluno(){
		int quantidadeInicio = dao.listar().size();
		dao.salvar(montarObjetoAluno());
		int quantidadeFim = dao.listar().size();
		Assert.assertEquals(quantidadeInicio + 1,quantidadeFim);
	}
	
	@Test
	public void testeRemoverAluno(){
		Aluno aluno = new Aluno();
		dao.salvar(aluno);
		int quantidadeInicio = dao.listar().size();
		dao.remover(aluno);
		int quantidadeFim = dao.listar().size();
		Assert.assertEquals(quantidadeInicio -1 , quantidadeFim );
	}

	@Test
	public void testeAtualizarAluno(){
		Aluno alunoInserido = new Aluno();
		dao.salvar(alunoInserido);
		
		Aluno alunoPesquisado = dao.buscar(alunoInserido.getId());
		String senhaAntiga = alunoPesquisado.getSenha();
		alunoPesquisado.setSenha(Util.criptografarSenha("admin321", Util.CONSTANTE_CRIPTOGRAFIA));
		dao.atualizar(alunoPesquisado);
		String senhaNova = alunoPesquisado.getSenha();
		Assert.assertNotNull(senhaNova);
		Assert.assertNotEquals(senhaAntiga,senhaNova);
	}
	
	@AfterClass
	public static void tearDown(){
		JPAUtil.closeEntityManagerFactory();
	}
	
	
	public Aluno montarObjetoAluno() {
		Aluno aluno = new Aluno();
		aluno.setNome("Douglas");
		aluno.setLogin("Doug");
		aluno.setEmail("Douglas@gmail.com");
		aluno.setSenha(Util.criptografarSenha("admin123", 
						Util.CONSTANTE_CRIPTOGRAFIA));
		
		return aluno;
	}
	
	
	
}
