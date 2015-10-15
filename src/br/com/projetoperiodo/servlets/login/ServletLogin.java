
package br.com.projetoperiodo.servlets.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ServletLogin extends HttpServlet {

	private static final String FORM_LOGIN = "login";

	private static final String FORM_SENHA = "senha";


	
	@Override
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		ControladorUsuario controladorUsuario = Fachada.getInstance().getControladorUsuario();
		ControladorAluno controladorAluno = Fachada.getInstance().getControladorAluno();
		
		if ( !( request.getSession(false) == null ) ) {
			requestDispatcher = request.getRequestDispatcher("/aluno.do");
			requestDispatcher.forward(request, response);
		} else {
			String login = request.getParameter(FORM_LOGIN);
			String senha = request.getParameter(FORM_SENHA);
			Usuario usuario = (Usuario) controladorUsuario.criarEntidadeNegocio();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			try {
				Usuario usuarioAutenticado = controladorUsuario.autenticarUsuario(usuario);
				Aluno aluno = controladorAluno.buscarUsuarioAluno(usuarioAutenticado);
				HttpSession session = request.getSession();
				session.setAttribute(Constantes.ATRIBUTO_USUARIO_LOGADO, aluno);
				requestDispatcher = request.getRequestDispatcher("/aluno.do");
				requestDispatcher.forward(request, response);
			} catch (NegocioException e) {
				request.setAttribute(e.getMessage(), usuario.getLogin());
				requestDispatcher = request.getRequestDispatcher("/login.do");
				requestDispatcher.forward(request, response);
			}
		}

	}
}
