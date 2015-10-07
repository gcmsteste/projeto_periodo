package br.com.projetoperiodo.model.instituto.aluno;

import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import br.com.projetoperiodo.model.instituto.aluno.dao.AlunoDao;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;
import br.com.projetoperiodo.util.persistencia.jpa.JPAUtil;

public class TesteAlunoDao {

	private static AlunoDao dao = CreatorFabrica.
					createFactory(CreatorFabrica.FABRICA_JPA).criarAlunoDAO();

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
	
		Aluno alunoPesquisado = (Aluno) dao.buscar(alunoInserido.getChavePrimaria());
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
		JPAUtil.destroyInstance();
	}

	public Aluno montarObjetoAluno() {
		Aluno aluno = new AlunoImpl();
		Usuario usuario = (Usuario) aluno;
		aluno.setMatricula("20141Y6-RC0323");
		usuario.setNome("Douglas");
		usuario.setLogin("Doug");
		usuario.setEmail("Douglas@gmail.com");
		String novaSenha = "admin321";
		usuario.setSenha(Util.criptografarSenha(novaSenha, novaSenha, Constantes.CONSTANTE_CRIPTOGRAFIA));
		usuario.setUltimaAlteracao( Calendar.getInstance().getTime() );
		return aluno;
	}

	

}
