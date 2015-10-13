
package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;
import br.com.projetoperiodo.util.exception.NegocioException;

/**
 * Servlet implementation class ServletCadastroMonitoria
 */
public class ServletCadastroMonitoria extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String LISTA_DISCIPLINAS = "listaDisciplinas";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastroMonitoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorDisciplina controladorDisciplina = Fachada.getInstance().getControladorDisciplina();
		List<Disciplina> listaDisciplinas = controladorDisciplina.listarDisciplinasCadastradas();
		request.setAttribute(LISTA_DISCIPLINAS, listaDisciplinas);
		request.getRequestDispatcher("/formCadastroMonitoria").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ControladorMonitor controladorMonitor = Fachada.getInstance().getControladorMonitor();
		ControladorDisciplina controladorDisciplina = Fachada.getInstance().getControladorDisciplina();
		Aluno aluno = (Aluno) request.getSession().getAttribute(Constantes.ATRIBUTO_USUARIO_LOGADO);
		Disciplina disciplina = null;
		try {
			disciplina = controladorDisciplina.buscarDisciplina(request.getParameter("descricao"));
		} catch (NegocioException e) {
			// TODO Redirecionar para página de erro
			request.getRequestDispatcher("").forward(request, response);
		}
	    controladorMonitor.cadastrarMonitoria(
						aluno, disciplina, Modalidade.valueOf(request.getParameter("modalidade")));

	}

}
