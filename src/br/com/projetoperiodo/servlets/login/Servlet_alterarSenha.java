package br.com.projetoperiodo.servlets.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.model.usuario.controller.ControladorUsuario;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.Util;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;

/**
 * Servlet implementation class Servlet_alterarSenha
 */
public class Servlet_alterarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_alterarSenha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ControladorUsuario controladorUsuario = Fachada.getInstance().getControladorUsuario();

		String loginUsuario = request.getParameter(login1);
		String senhaAntiga = request.getParameter(senhaAntiga);
		String senhaNova = request.getParameter(senhaNova);
		
		Usuario usuario = (Usuario) controladorUsuario.criarEntidadeNegocio();
		usuario.setLogin(loginUsuario);
		Usuario usuarioBuscado = controladorUsuario.verificarExistenciaUsuario(usuario);
		
		try
		{
			controladorUsuario.alterarSenha(usuarioBuscado, senhaAntiga, senhaNova);
			request.getRequestDispatcher("/ControladorUsuarioImpl.do").forward(request, response); 
			
		}
		catch (NegocioException e)
		{
			e.printStackTrace();
		}
		
	}

}
