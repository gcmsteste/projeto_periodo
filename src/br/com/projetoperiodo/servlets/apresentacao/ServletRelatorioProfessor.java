
package br.com.projetoperiodo.servlets.apresentacao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.constantes.enumeracoes.Situacao;

/**
 * Servlet implementation class ServletRelatorioProfessor
 */
public class ServletRelatorioProfessor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String CHAVE_MONITOR = "chaveMonitor";
	public static final String SITUACAO_RELATORIOS_MONITORIA = "situacaoRelatorios";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRelatorioProfessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getSession(false) == null) {
			request.getRequestDispatcher("/acesso.do").forward(request, response);
		}
		
		Monitor monitor = null;
		if ( request.getParameter(CHAVE_MONITOR) != null ) {
			long chavePrimariaMonitor = Long.valueOf(request.getParameter(CHAVE_MONITOR));
			monitor = (Monitor) Fachada.getInstance().buscarMonitoria(chavePrimariaMonitor);
			request.getSession(false).setAttribute(Constantes.ATRIBUTO_MONITORIA, monitor);
		} else {
			monitor = (Monitor) request.getSession(false).getAttribute(Constantes.ATRIBUTO_MONITORIA);
		}
		List<Situacao> listaSituacao = Fachada.getInstance().buscarSituacaoDeRelatorios(monitor);
		request.setAttribute(SITUACAO_RELATORIOS_MONITORIA, listaSituacao);
		request.getRequestDispatcher("/paginaPrincipalRelatoriosProfessor").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
