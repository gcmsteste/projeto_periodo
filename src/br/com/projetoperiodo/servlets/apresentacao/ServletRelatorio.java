package br.com.projetoperiodo.servlets.apresentacao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.util.Fachada;

/**
 * Servlet implementation class ServletRelatorio
 */
public class ServletRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String RELATORIOS_MONITOR = "relatoriosMonitor";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRelatorio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long chavePrimariaMonitor = Long.valueOf(request.getParameter("chaveMonitor"));
		List<RelatorioFrequencia> listaRelatorios = Fachada.getInstance().buscarRelatorios(chavePrimariaMonitor);
		request.setAttribute(RELATORIOS_MONITOR, listaRelatorios);
		request.getRequestDispatcher("/paginaPrincipalRelatorios").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
