package br.com.projetoperiodo.negocio.usuario.impl;

import br.com.projetoperiodo.model.usuario.JPAUsuarioDao;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.UsuarioDao;
import br.com.projetoperiodo.negocio.usuario.ControladorUsuario;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ControladorUsuarioImpl implements ControladorUsuario
{
	private UsuarioDao dao;
	
	public ControladorUsuarioImpl() {
		dao = new JPAUsuarioDao();
	}
	
	@Override
	public Usuario autenticarUsuario(Usuario usuario) throws NegocioException {
		String senha = usuario.getSenha();
		Usuario usuarioAutenticado = dao.buscar(usuario.getLogin());
		if (usuarioAutenticado != null) {
			String senhaCriptografada = Util.criptografarSenha(senha, Util.CONSTANTE_CRIPTOGRAFIA);
			if ( !usuarioAutenticado.getSenha().equals(senhaCriptografada)) {
				throw new NegocioException(Constantes.ERRO_ACESSO_NEGADO);
			}
			return usuarioAutenticado;
		} else {
			throw new NegocioException(Constantes.ERRO_ACESSO_NEGADO);
		}
		
	}

}
