package br.com.projetoperiodo.servlets.exception;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppExceptionHandler
 */
public class AppExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppExceptionHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request, response);
	}
	
	private void processError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String errorMessage = (String)request.getAttribute("javax.servlet.error.message");
		if ( 404 == statusCode ) {
			request.getRequestDispatcher("/WEB-INF/jsp/PaginaErro.jsp").forward(request, response);
		}
		
	}
	
	

}
