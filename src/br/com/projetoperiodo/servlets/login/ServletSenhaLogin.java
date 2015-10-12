package br.com.projetoperiodo.servlets.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.model.usuario.controller.impl.ControladorUsuarioImpl;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.exception.NegocioException;

/**
 * Servlet implementation class ServletSenhaLogin
 */
public class ServletSenhaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String FORM_EMAIL = "email";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSenhaLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter(FORM_EMAIL);
		Usuario usuario = (Usuario) Fachada.getInstance().getControladorUsuario().criarEntidadeNegocio();
		ControladorUsuario controlador = new ControladorUsuarioImpl();
		try {
			controlador.alterarSenhaUsuario(usuario);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/login.do").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
