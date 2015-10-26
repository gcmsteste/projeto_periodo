package br.com.projetoperiodo.servlets.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.exception.NegocioException;

/**
 * Servlet implementation class ServletEsqueceuSenha
 */
public class ServletEsqueceuSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FORM_LOGIN = "login";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEsqueceuSenha() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

	}

	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher;
		ControladorUsuario controladorUsuario = Fachada.getInstance()
				.getControladorUsuario();

		if (!(request.getSession(false) == null)) {
			requestDispatcher = request.getRequestDispatcher("/aluno.do");
			requestDispatcher.forward(request, response);
		} else {
			String loginUsuario = request.getParameter(FORM_LOGIN);
			Usuario usuario = (Usuario) controladorUsuario
					.criarEntidadeNegocio();
			usuario.setLogin(loginUsuario);

			Usuario usuarioBuscado = controladorUsuario
					.verificarExistenciaUsuario(usuario);

			try {
				controladorUsuario.alterarSenhaUsuario(usuarioBuscado);
				request.getRequestDispatcher("/acesso.do").forward(request, response);

			} catch (NegocioException e) {
				e.printStackTrace();
			}

		}
	}

}
