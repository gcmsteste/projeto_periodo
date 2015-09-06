package br.com.projetoperiodo.model.usuario;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.persistencia.JPAUtil;


public class TesteUsuarioDao {

	
	UsuarioDao dao;
	@BeforeClass
	public void setUp() {
		dao = new JPAUsuarioDao();
	}
	
	@Test
	public void testeInserirUsuario() {
		int qtdInicio = dao.listar().size();
		dao.salvar(montarObjetoUsuario());
		int qtdFim  = dao.listar().size();
		Assert.assertEquals(qtdInicio + 1, qtdFim);
	}
	
	@Test
	public void testeRemoverUsuario() {
		Usuario usuario = montarObjetoUsuario();
		dao.salvar(usuario);
		int qtdInicio = dao.listar().size();
		dao.remover(usuario);
		int qtdFim = dao.listar().size();
		Assert.assertEquals(qtdInicio - 1, qtdFim );
	}
	
	@Test
	public void testeAtualizarUsuario() {
	
		Usuario usuarioInserido = montarObjetoUsuario();
		dao.salvar(usuarioInserido);
		
		Usuario usuarioPesquisado = dao.buscar(usuarioInserido.getId());
		String senhaAntesAlteracao = usuarioPesquisado.getSenha();
		usuarioPesquisado.setSenha(Util.criptografarSenha("admin321", Util.CONSTANTE_CRIPTOGRAFIA));
		dao.atualizar(usuarioPesquisado);
		String senhaPosAlteracao = dao.buscar(usuarioPesquisado.getId()).getSenha();
		Assert.assertNotNull(senhaPosAlteracao);
		Assert.assertNotEquals(senhaAntesAlteracao, senhaPosAlteracao); 
	}
	
	@AfterClass
	public static void tearDown() {
		JPAUtil.closeEntityManagerFactory();
	}
	
	public Usuario montarObjetoUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("admin");
		usuario.setLogin("admin");
		usuario.setEmail("admin@email.com");
		usuario.setSenha(Util.criptografarSenha("admin123", 
						Util.CONSTANTE_CRIPTOGRAFIA));
		return usuario;
	}
}
