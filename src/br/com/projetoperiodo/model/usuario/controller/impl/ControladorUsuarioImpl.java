package br.com.projetoperiodo.model.usuario.controller.impl;

import java.util.Calendar;

import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.dao.JPAUsuarioDao;
import br.com.projetoperiodo.model.usuario.dao.UsuarioDao;
import br.com.projetoperiodo.model.usuario.impl.Usuario;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.Fachada;
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

	@Override
	public void envioEmailSenha(Usuario usuario) throws NegocioException {
		StringBuilder builder = new StringBuilder();
		builder.append("Login: \n");
		builder.append(usuario.getLogin());
		builder.append("\nSenha: \n");
		builder.append(usuario.getSenha());
		String conteudo = builder.toString();
		String assunto = "Sistema de Monitoria - Nova senha";
		Util.enviarEmail(usuario.getEmail(), assunto , conteudo);
	}
	
	public static void main(String[] args) throws NegocioException {

		ControladorUsuario controlador = new ControladorUsuarioImpl();
		Usuario usuario = Fachada.getInstance().criarUsuario();
		usuario.setEmail("emgs@a.recife.ifpe.edu.br");
		usuario.setLogin("admin");
		usuario.setSenha("admin123");
		controlador.envioEmailSenha(usuario);
	}

	@Override
	public void alterarSenhaUsuario(Usuario usuario) {

		
		
	}

	@Override
	public void validarLogon(Usuario usuario) {

		// TODO Auto-generated method stub
		
	}

}
