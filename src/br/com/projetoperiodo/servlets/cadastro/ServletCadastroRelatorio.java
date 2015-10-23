package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.semana.Semana;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;

/**
 * Servlet implementation class ServletCadastroRelatorio
 */
public class ServletCadastroRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String MES_RELATORIO = "mes";
    private static final String RELATORIO_MENSAL = "relatorio";
    
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
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mesRelatorio = Integer.valueOf(request.getParameter(MES_RELATORIO));
		Monitor monitor = (Monitor) request.getSession(false).getAttribute(Constantes.ATRIBUTO_MONITORIA);
		RelatorioFrequencia relatorio = Fachada.getInstance().buscarRelatorioMensal(monitor, mesRelatorio);
		request.getSession(false).setAttribute(RELATORIO_MENSAL, relatorio);
		request.getRequestDispatcher("/formCadastroRelatorio").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RelatorioFrequencia relatorio = (RelatorioFrequencia) request.getSession(false).getAttribute(RELATORIO_MENSAL);
		Semana primeiraSemana = relatorio.getSemanas(0);
		primeiraSemana.setDescricao(request.getParameter("semanadescricao1"));
		Fachada.getInstance().atualizarRelatorio(relatorio);
		request.getRequestDispatcher("/relatorio.do").forward(request, response);
	}

}
