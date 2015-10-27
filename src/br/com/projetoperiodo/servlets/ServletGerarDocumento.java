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
 * Servlet implementation class ServletGerarDocumento
 */
public class ServletGerarDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MES_RELATORIO = "mes";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGerarDocumento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mesRelatorio = Integer.valueOf(request.getParameter(MES_RELATORIO));
		Monitor monitor = (Monitor) request.getSession(false).getAttribute(Constantes.ATRIBUTO_MONITORIA);
		RelatorioFrequencia relatorio = Fachada.getInstance().buscarRelatorioMensal(monitor, mesRelatorio);
		Fachada.getInstance().gerarDocumentoDeRelatorio(relatorio);
		request.getRequestDispatcher("/enviarDocumento.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
