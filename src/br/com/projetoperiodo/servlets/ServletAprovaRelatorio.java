package br.com.projetoperiodo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;

/**
 * Servlet implementation class ServletAprovaRelatorio
 */
public class ServletAprovaRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MES_RELATORIO = "mes";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAprovaRelatorio() {
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
		if (request.getSession(false) == null) {
			request.getRequestDispatcher("/acesso.do").forward(request, response);
		}
		int mesRelatorio = Integer.valueOf(request.getParameter(MES_RELATORIO));
		Monitor monitor = (Monitor) request.getSession(false).getAttribute(Constantes.ATRIBUTO_MONITORIA);
		RelatorioFrequencia relatorio = Fachada.getInstance().buscarRelatorioMensal(monitor, mesRelatorio);
		Fachada.getInstance().aprovarRelatorio(relatorio);
		request.getRequestDispatcher("/relatorioProfessor.do").forward(request, response);
	}

}
