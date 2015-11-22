
package br.com.projetoperiodo.model.usuario.controller;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorUsuario extends ControladorNegocio {

	final String EMAIL_NAO_CADASTRADO = "EMAIL_NAO_CADASTRADO";

	final String USUARIO_NAO_CADASTRADO = "USUARIO_NAO_CADASTRADO";

	Usuario autenticarUsuario(Usuario usuario) throws NegocioException;

	void envioEmailSenha(Usuario usuario) throws NegocioException;

	void encaminharSenhaParaUsuario(Usuario usuario) throws NegocioException;

	Usuario cadastrarUsuario(Usuario usuario);

	Usuario verificarExistenciaUsuario(Usuario usuario);

	Usuario alterarSenha(Usuario usuario, String senhaNova);

	boolean compararSenhas(String senha, Usuario usuario);
}
