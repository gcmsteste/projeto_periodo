package br.com.projetoperiodo.usuario;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.projetoperiodo.model.usuario.HibernateUsuarioDao;
import br.com.projetoperiodo.model.usuario.JPAUsuarioDao;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.UsuarioDao;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.persistencia.HibernateUtil;


public class TesteUsuarioDao {

	
	UsuarioDao dao;
	@Before
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
		int qtdInicio = dao.listar().size();
		dao.remover(usuario);
		int qtdFim = dao.listar().size();
		Assert.assertEquals(qtdInicio - 1, qtdFim );
	}
	
	@Test
	public void testeAtualizarUsuario() {
	/*
		Usuario usuarioInserido = montarObjetoUsuario();
		dao.salvar(usuarioInserido);
		String senhaAntesAlteracao = usuario.getSenha();
		usuarioPesquisado.setSenha(Util.criptografarSenha("admin321", Util.CONSTANTE_CRIPTOGRAFIA));
		dao.atualizar(usuarioPesquisado);
		String senhaPosAlteracao = session.get(Usuario.class, usuario.getLogin()).getSenha();
		Assert.assertNotNull(senhaPosAlteracao);
		Assert.assertNotEquals(senhaAntesAlteracao, senhaPosAlteracao); */
	}
	
	@After
	public void close() {
		//HibernateUtil.getSessionFactory().close();
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
