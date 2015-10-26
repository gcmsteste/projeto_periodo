package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.curso.Curso;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.util.Fachada;

/**
 * Servlet implementation class ServletCadastroMonitor
 */
public class ServletCadastroAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String LISTA_DISCIPLINAS = "listaDisciplinas";
    private static final ControladorDisciplina controladorDisciplina = Fachada.getInstance().getControladorDisciplina();
	private static final List<Disciplina> listaDisciplinas = controladorDisciplina.listarDisciplinasCadastradas();
	
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroAluno() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(LISTA_DISCIPLINAS, listaDisciplinas);
		request.getRequestDispatcher("/formCadastroAluno").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ControladorAluno controladorAluno = Fachada.getInstance().getControladorAluno();
		ControladorDisciplina controladorDisciplina = Fachada.getInstance().getControladorDisciplina();
		Aluno aluno = (Aluno)controladorAluno.criarEntidadeNegocio();
		aluno.setMatricula(request.getParameter("matricula"));
		aluno.setNome(request.getParameter("nome"));
		aluno.setSobrenome(request.getParameter("sobrenome"));
		aluno.setLogin(request.getParameter("login"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setSenha(request.getParameter("senha"));
		
		String[] materias = request.getParameterValues("disciplinas");
			
		for(int x = 0; x < materias.length; x++){
			Disciplina disciplina = (Disciplina)controladorDisciplina.criarEntidadeNegocio();
			Disciplina disciplinaRetornada = (Disciplina)controladorDisciplina.criarEntidadeNegocio();
			disciplina.setDescricao(materias[x]);
			
			disciplinaRetornada = comparaDisciplinas(disciplina);
			aluno.setDisciplinas(disciplinaRetornada);
		}
		Curso curso = (Curso) Fachada.getInstance().buscarCursoPadraoDeAluno();
		aluno.setCurso(curso);
		controladorAluno.cadastrarAluno(aluno);
		
		request.getRequestDispatcher("/acesso.do").forward(request, response);
	
		
		
	}

	protected Disciplina comparaDisciplinas(Disciplina disc){
		Disciplina objDisciplina = null;	
		
			for(int i=0; i < listaDisciplinas.size(); i++){
				if(listaDisciplinas.get(i).getDescricao().equals(disc.getDescricao()))
				{
					objDisciplina = listaDisciplinas.get(i); 
				}
			}
		
		
		return objDisciplina;
	}
}
