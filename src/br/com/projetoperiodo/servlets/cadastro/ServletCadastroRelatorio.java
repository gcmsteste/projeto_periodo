package br.com.projetoperiodo.servlets.cadastro;

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
 * Servlet implementation class ServletCadastroRelatorio
 */
public class ServletCadastroRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String RELATORIO_MES = "mes";
    private static final String RELATORIO = "relatorio";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroRelatorio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mesRelatorio = Integer.valueOf(request.getParameter(RELATORIO_MES));
		Monitor monitor = (Monitor) request.getSession(false).getAttribute(Constantes.ATRIBUTO_MONITORIA);
		RelatorioFrequencia relatorio = Fachada.getInstance().buscarRelatorioPorMes(monitor, mesRelatorio);
		request.setAttribute(RELATORIO, relatorio);
		request.getRequestDispatcher("/formCadastroRelatorio").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
