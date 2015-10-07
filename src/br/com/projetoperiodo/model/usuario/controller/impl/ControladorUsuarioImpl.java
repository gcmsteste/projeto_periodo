
package br.com.projetoperiodo.model.usuario.controller.impl;

import java.util.Calendar;
import java.util.HashMap;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ControladorUsuarioImpl extends ControladorNegocioImpl implements ControladorUsuario {

	private final String EMAIL_ASSUNTO = "Senha Sistema de Monitoria TADS";
	
	private final String EMAIL_MENSAGEM_CONTEUDO = "Sua senha é: ";
	
	private UsuarioDao dao;
	
	public ControladorUsuarioImpl() {
		dao = fabrica.criarUsuarioDAO();
	}

	@Override
	public Usuario autenticarUsuario(Usuario usuario) throws NegocioException {

		String senha = usuario.getSenha();
		Usuario usuarioAutenticado = dao.buscar(usuario.getLogin());
		if (usuarioAutenticado != null) {
			String senhaCriptografada = Util.criptografarSenha(senha, senha, Constantes.CONSTANTE_CRIPTOGRAFIA);
			if (!usuarioAutenticado.getSenha().equals(senhaCriptografada)) {
				throw new NegocioException(Constantes.ERRO_ACESSO_NEGADO);
			}
			usuarioAutenticado.setUltimoAcesso(Calendar.getInstance().getTime());
			return usuarioAutenticado;
		} else {
			throw new NegocioException(Constantes.ERRO_ACESSO_NEGADO);
		}

	}

	@Override
	public void envioEmailSenha(Usuario usuario) throws NegocioException {

		Util.enviarEmail(usuario.getEmail(), EMAIL_ASSUNTO, EMAIL_MENSAGEM_CONTEUDO);
	}


	@Override
	public void alterarSenhaUsuario(Usuario usuario) throws NegocioException {

		HashMap<String, Object> filter = new HashMap<>();
		filter.put(Usuario.ATRIBUTO_USUARIO_EMAIL, usuario.getEmail());
		try {
			usuario = dao.buscar(filter);
			String novaSenha = Util.gerarSenhaAleatoria();
			String senhaCriptografada = Util.criptografarSenha(novaSenha, 
							novaSenha, Constantes.CONSTANTE_CRIPTOGRAFIA);
			usuario.setSenha(senhaCriptografada);
			usuario.setSenhaExpirada(Boolean.TRUE);
			dao.atualizar(usuario);
			usuario.setSenha(novaSenha);
			envioEmailSenha(usuario);
		} catch (NegocioException e) {
			throw new NegocioException(EMAIL_NAO_CADASTRADO);
		}
	}

	@Override
	public boolean validarLogon(Usuario usuario) {

		Usuario usuarioLogado = dao.buscar(usuario.getNome());
		if (usuarioLogado.isSenhaExpirada()) {

		}
		return Boolean.TRUE;
	}

	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new UsuarioImpl();
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		
	}

}
