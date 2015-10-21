package br.com.projetoperiodo.servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.controller.ControladorAluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.util.Fachada;

/**
 * Servlet implementation class ServletCadastroMonitor
 */
public class ServletCadastroAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String LISTA_DISCIPLINAS = "listaDisciplinas";
    private static final ControladorDisciplina controladorDisciplina = Fachada.getInstance().getControladorDisciplina();
	List<Disciplina> listaDisciplinas = controladorDisciplina.listarDisciplinasCadastradas();
	
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String[] disciplinas_selecionadas = request.getParameterValues("select option");
        
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet3</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("Selected Values...");    
            for(int i=0;i<disciplinas_selecionadas.length;i++)
           {
               out.println("<li>"+disciplinas_selecionadas[i]+"</li>");
           }
            
            
            out.println("</body>");
            out.println("</html>");
        }
        
        
    }*/
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
		//ControladorDisciplina controladorDisciplina = Fachada.getInstance().getControladorDisciplina();
		//List<Disciplina> listaDisciplinas = controladorDisciplina.listarDisciplinasCadastradas();
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
		//aluno.setCurso(/*objeto curso*/); 
		String[] materias = request.getParameterValues("disciplinas");
			
		for(int x = 0; x < materias.length; x++){
			Disciplina disciplina = (Disciplina)controladorDisciplina.criarEntidadeNegocio();
			Disciplina disciplinaRetornada = (Disciplina)controladorDisciplina.criarEntidadeNegocio();
			disciplina.setDescricao(materias[x]);
			
			disciplinaRetornada = comparaDisciplinas(disciplina);
			aluno.setDisciplinas((DisciplinaImpl)disciplinaRetornada);
		}
		
		controladorAluno.cadastrarAluno(aluno);
		
		RequestDispatcher view = request.getRequestDispatcher("/aluno.do");  
        view.forward(request, response);
		
        controladorAluno.cadastrarAluno(aluno);
		// controladorDisciplina -> busca a disciplina
		// controladorCurso -> busca o curso
		
		
		
	}

	protected Disciplina comparaDisciplinas(Disciplina disc){
		Disciplina objDisciplina = null;	
		
			for(int i=0; i < listaDisciplinas.size(); i++){
				if(listaDisciplinas.get(i).getDescricao().equals(disc.getDescricao()))
				{
					objDisciplina = listaDisciplinas.get(i); 
				}else{
					objDisciplina = null;
				}
			}
		
		
		return objDisciplina;
	}
}
