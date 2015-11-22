
package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.util.Fachada;

/**
 * Servlet implementation class ServletCadastroProfessor
 */
public class ServletCadastroProfessor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String LISTA_DISCIPLINAS = "listaDisciplinas";

	// TODO: Controle de concorrencia
	private static final List<Disciplina> listaDisciplinas = Fachada.getInstance().listarDisciplinasSemProfessor();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastroProfessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		if (request.getSession(false) != null) {
			request.getRequestDispatcher("/acesso.do").forward(request, response);
		}
		request.setAttribute(LISTA_DISCIPLINAS, listaDisciplinas);
		request.getRequestDispatcher("/WEB-INF/jsp/CadastroProfessor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getSession(false) != null) {
			request.getRequestDispatcher("/acesso.do").forward(request, response);
		}
		Professor professor = (Professor) Fachada.getInstance().criarProfessor();
		professor.setLogin(request.getParameter("login"));
		professor.setNome(request.getParameter("nome"));
		professor.setSobrenome(request.getParameter("sobrenome"));
		professor.setEmail(request.getParameter("email"));
		professor.setSenha(request.getParameter("senha"));

		String[] materias = request.getParameterValues("disciplinas");
		if (materias != null) {
			for (int x = 0; x < materias.length; x++) {
				Disciplina disciplina = (Disciplina) Fachada.getInstance().criarDisciplina();
				Disciplina disciplinaRetornada = (Disciplina) Fachada.getInstance().criarDisciplina();
				disciplina.setDescricao(materias[x]);

				disciplinaRetornada = comparaDisciplinas(disciplina);
				professor.setDisciplina(disciplinaRetornada);
			}
		}

		Fachada.getInstance().cadastrarProfessor(professor);

		request.getRequestDispatcher("/acesso.do").forward(request, response);

	}

	protected Disciplina comparaDisciplinas(Disciplina disc) {

		Disciplina objDisciplina = null;

		for (int i = 0; i < listaDisciplinas.size(); i++) {
			if (listaDisciplinas.get(i).getDescricao().equals(disc.getDescricao())) {
				objDisciplina = listaDisciplinas.get(i);
			}
		}

		return objDisciplina;
	}

}
