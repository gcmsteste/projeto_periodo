
package br.com.projetoperiodo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.controller.impl.ControladorUsuarioImpl;
import br.com.projetoperiodo.model.usuario.impl.UsuarioImpl;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ServletLogin extends HttpServlet {

	public static final String FORM_LOGIN = "login";

	public static final String FORM_SENHA = "senha";

	public static final String ATRIBUTO_USUARIO_LOGADO = "usuarioLogado";

	
	@Override
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		ControladorUsuario controladorUsuario = Fachada.getInstance().getControladorUsuario();
		
		if ( !( request.getSession(false) == null ) ) {
			requestDispatcher = request.getRequestDispatcher("/home.do");
			requestDispatcher.forward(request, response);
		} else {
			String login = request.getParameter(FORM_LOGIN);
			String senha = request.getParameter(FORM_SENHA);
			Usuario usuario = (Usuario) controladorUsuario.criarEntidadeNegocio();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			try {
				Usuario usuarioAutenticado = controladorUsuario.autenticarUsuario(usuario);
				HttpSession session = request.getSession();
				session.setAttribute(ATRIBUTO_USUARIO_LOGADO, usuarioAutenticado);
				requestDispatcher = request.getRequestDispatcher("/home.do");
				requestDispatcher.forward(request, response);
			} catch (NegocioException e) {
				request.setAttribute(e.getMessage(), usuario.getLogin());
				requestDispatcher = request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request, response);
			}
		}

	}
}
