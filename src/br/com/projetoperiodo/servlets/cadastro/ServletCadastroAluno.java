package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.util.Fachada;

/**
 * Servlet implementation class ServletCadastroMonitor
 */
public class ServletCadastroAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String LISTA_DISCIPLINAS = "listaDisciplinas";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet3</title>");            
            out.println("</head>");
            
            String[] disciplinas_selecionadas = request.getParameterValues("select option");
            out.println("Selected Values...");    
            for(int i=0;i<disciplinas_selecionadas.length;i++)
           {
               out.println("<li>"+disciplinas_selecionadas[i]+"</li>");
           }
            out.println("<h1>Servlet Servlet3 at " + request.getContextPath() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
        
        
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroAluno() {
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
		aluno.setLogin(request.getParameter("login"));
		aluno.setEmail(request.getParameter("email"));
		aluno.setSenha(request.getParameter("senha"));
		
		
		

        
      
       
		controladorAluno.cadastrarAluno(aluno);
		// controladorDisciplina -> busca a disciplina
		// controladorCurso -> busca o curso
		
		
		
	}

}
