
package br.com.projetoperiodo.model.usuario.controller.impl;

import java.util.Calendar;
import java.util.HashMap;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.fabrica.CreatorFabrica;

public class ControladorUsuarioImpl extends ControladorNegocioImpl implements ControladorUsuario {

	private final String EMAIL_ASSUNTO = "Senha Sistema de Monitoria TADS";

	private final String EMAIL_MENSAGEM_CONTEUDO = "Sua senha é: ";

	public ControladorUsuarioImpl() {
		super();
	}

	@Override
	public Usuario autenticarUsuario(Usuario usuario) throws NegocioException {

		String senha = usuario.getSenha();
		Usuario usuarioAutenticado = CreatorFabrica.getFabricaDAO().criarUsuarioDAO().buscar(usuario.getLogin());
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
	public Usuario alterarSenha(Usuario usuario, String senhaNova) {

		String senhaNovaCriptografada = Util.criptografarSenha(senhaNova, senhaNova, Constantes.CONSTANTE_CRIPTOGRAFIA);
		usuario.setSenha(senhaNovaCriptografada);
		CreatorFabrica.getFabricaDAO().criarUsuarioDAO().atualizar(usuario);
		return usuario;
	}

	@Override
	public void envioEmailSenha(Usuario usuario) throws NegocioException {

		String novaSenha = usuario.getSenha();
		novaSenha = EMAIL_MENSAGEM_CONTEUDO.concat(novaSenha);
		Util.enviarEmail(usuario.getEmail(), EMAIL_ASSUNTO, novaSenha);
	}

	@Override
	public void encaminharSenhaParaUsuario(Usuario usuario) throws NegocioException {

		HashMap<String, Object> filter = new HashMap<>();
		filter.put(Usuario.ATRIBUTO_USUARIO_EMAIL, usuario.getEmail());
		try {
			usuario = (Usuario) CreatorFabrica.getFabricaDAO().criarUsuarioDAO().buscar(filter);
			String novaSenha = Util.gerarSenhaAleatoria();
			alterarSenha(usuario, novaSenha);
			usuario.setSenha(novaSenha);
			envioEmailSenha(usuario);
		} catch (NegocioException e) {
			throw new NegocioException(EMAIL_NAO_CADASTRADO);
		}
	}



	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new UsuarioImpl();
	}

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) {

		String senhaCriptografada = Util.criptografarSenha(usuario.getSenha(), usuario.getSenha(), Constantes.CONSTANTE_CRIPTOGRAFIA);
		usuario.setSenha(senhaCriptografada);
		CreatorFabrica.getFabricaDAO().criarUsuarioDAO().salvar(usuario);
		return usuario;
	}

	@Override
	public Usuario verificarExistenciaUsuario(Usuario usuario) {

		Usuario usuarioRequerente = CreatorFabrica.getFabricaDAO().criarUsuarioDAO().buscar(usuario.getLogin());
		return usuarioRequerente;
	}

	@Override
	public String getNomeClasseEntidade() {

		return UsuarioImpl.class.getSimpleName();
	}

	@Override
	public boolean compararSenhas(String senha, Usuario usuario) {

		boolean isEqual = Boolean.TRUE;
		senha = Util.criptografarSenha(senha, senha, Constantes.CONSTANTE_CRIPTOGRAFIA);
		if (!senha.equals(usuario.getSenha())) {
			isEqual = Boolean.FALSE;
		}
		return isEqual;
	}

}
