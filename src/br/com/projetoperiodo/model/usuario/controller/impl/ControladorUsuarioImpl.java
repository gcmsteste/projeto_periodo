package br.com.projetoperiodo.model.usuario.controller.impl;

import java.util.Calendar;

import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.dao.JPAUsuarioDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.model.usuario.impl.Usuario;
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
			String senhaCriptografada = Util.criptografarSenha(senha, senha, Constantes.CONSTANTE_CRIPTOGRAFIA);
			if ( !usuarioAutenticado.getSenha().equals(senhaCriptografada)) {
				throw new NegocioException(Constantes.ERRO_ACESSO_NEGADO);
			}
			usuarioAutenticado.setUltimoAcesso( Calendar.getInstance().getTime() );
			return usuarioAutenticado;
		} else {
			throw new NegocioException(Constantes.ERRO_ACESSO_NEGADO);
		}
		
	}

}
