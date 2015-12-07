package br.com.projetoperiodo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.persistencia.fabrica.CreatorFabrica;

/**
 * Servlet implementation class ServletAlteraFabrica
 */
public class ServletAlteraFabrica extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ESTRATEGIA_PERSISTENCIA = "persistencia";
    private static final String JPA = "JPA";
    private static final String JDBC = "JDBC";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlteraFabrica() {
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
		String tipoDeEstrategia = request.getParameter(ESTRATEGIA_PERSISTENCIA);
		if ( tipoDeEstrategia.equals(JDBC) ) {
			Fachada.getInstance().alterarEstrategiaDePersistencia(CreatorFabrica.FABRICA_JDBC);
		} else if ( tipoDeEstrategia.equals(JPA)){
			Fachada.getInstance().alterarEstrategiaDePersistencia(CreatorFabrica.FABRICA_JPA);
		}
	}

}
