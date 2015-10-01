package br.com.projetoperiodo.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoperiodo.model.usuario.JPAUsuarioDao;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.UsuarioDao;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.persistencia.FabricaJPA;

public class ControladorAcesso extends HttpServlet {
	
	private UsuarioDao dao;
	public static final String USUARIO_LOGADO = "usuario";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new JPAUsuarioDao();
		super.init(config);
	}
	@Override
	public void destroy() {
		FabricaJPA.getInstancia().closeEntityManagerFactory();
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(Boolean.FALSE);
		if (session == null) {
			request.getRequestDispatcher("/login.do");
		} else {
			request.getRequestDispatcher("/inicial.do");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setSenha(senha);
		usuario.setLogin(login);
		if ( autenticarUsuario(usuario, request) ) {
			request.getRequestDispatcher("/inicial.do");
		} else {
			request.getRequestDispatcher("/invalido.do");
		}

	}

	private boolean autenticarUsuario(Usuario usuarioLogado, HttpServletRequest request) {
		boolean permissao = Boolean.FALSE;
		String senha = usuarioLogado.getSenha();
		Usuario usuarioAutenticado = dao.buscar(usuarioLogado.getLogin());
		if (usuarioAutenticado != null) {
			String senhaCriptografada = Util.criptografarSenha(senha, Util.CONSTANTE_CRIPTOGRAFIA);
			if (usuarioAutenticado.getSenha().equals(senhaCriptografada)) {
				permissao = Boolean.TRUE;
				request.getSession().setAttribute(USUARIO_LOGADO, usuarioAutenticado);
			}
		}
		return permissao;
	}
	
	
}
