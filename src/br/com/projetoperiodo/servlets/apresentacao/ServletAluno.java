package br.com.projetoperiodo.servlets.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.exception.NegocioException;

/**
 * Servlet implementation class ServletAluno
 */
public class ServletAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ATRIBUTO_MONITORIA = "monitoria";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorMonitor controladorMonitor = Fachada.getInstance().getControladorMonitor();
		Aluno alunoLogado = (Aluno)request.getSession().getAttribute(Constantes.ATRIBUTO_USUARIO_LOGADO);
		try {
			Monitor monitor = controladorMonitor.buscarMonitoriasDeAluno(alunoLogado);
			request.setAttribute(ATRIBUTO_MONITORIA, monitor);
			request.getRequestDispatcher("/principalMonitor.do").forward(request, response);
		} catch (NegocioException e) {
			// TODO Tratar erro
			request.setAttribute("", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
