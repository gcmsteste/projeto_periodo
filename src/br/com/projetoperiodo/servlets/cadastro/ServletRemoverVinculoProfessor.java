package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.util.Fachada;

/**
 * Servlet implementation class ServletRemoverVinculoProfessor
 */
public class ServletRemoverVinculoProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CHAVE_DISCIPLINA = "chaveDisciplina";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoverVinculoProfessor() {
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
		//long chavePrimariaDisciplina = Long.valueOf(request.getParameter(CHAVE_DISCIPLINA));
	//	Fachada.getInstance().removerMonitoriaDeAluno(chavePrimariaMonitor);
		request.getRequestDispatcher("/aluno.do").forward(request, response);
		doGet(request, response);
	}

}
