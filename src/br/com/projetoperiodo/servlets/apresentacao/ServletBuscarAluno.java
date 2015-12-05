package br.com.projetoperiodo.servlets.apresentacao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;

/**
 * Servlet implementation class ServletBuscarAluno
 */
public class ServletBuscarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String OBJ_ALUNO = "obj_alunos";
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/BuscarAlunos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Professor professorLogado = (Professor) request.getSession().getAttribute(Constantes.ATRIBUTO_USUARIO_LOGADO);	
		String matricula = request.getParameter("matricula");
		Aluno aluno = (Aluno) Fachada.getInstance().buscarAluno(matricula);
		
		request.setAttribute(OBJ_ALUNO, aluno);
		request.getRequestDispatcher("/WEB-INF/jsp/ExibeDadosAlunos.jsp").forward(request, response);
		
	}

}
