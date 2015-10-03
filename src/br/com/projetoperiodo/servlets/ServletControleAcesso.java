package br.com.projetoperiodo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletControleAcesso extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		RequestDispatcher rd;
		if ( session == null ) {
			rd = request.getRequestDispatcher("/login.do");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/home.do");
			rd.forward(request, response);
		}
	}

}
