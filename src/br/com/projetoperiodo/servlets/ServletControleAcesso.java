package br.com.projetoperiodo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletControleAcesso extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5189852811554330041L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd;
		if ( request.getSession(Boolean.FALSE) == null ) {
			
			rd = request.getRequestDispatcher("login.do");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/aluno.do");
			rd.forward(request, response);
		}
	}

}
