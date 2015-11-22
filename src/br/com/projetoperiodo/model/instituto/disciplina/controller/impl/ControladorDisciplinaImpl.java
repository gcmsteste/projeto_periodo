package br.com.projetoperiodo.model.instituto.disciplina.controller.impl;

import java.util.HashMap;
import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.instituto.professor.Professor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.exception.NegocioException;
import br.com.projetoperiodo.util.persistencia.CreatorFabrica;

public class ControladorDisciplinaImpl extends ControladorNegocioImpl implements ControladorDisciplina
{
	
	
	
	public ControladorDisciplinaImpl() {
		
	}
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new DisciplinaImpl();
	}

	@Override
	public List<Disciplina> listarDisciplinasCadastradas() {
		StringBuilder builder = new StringBuilder();
		builder.append(" from ");
		builder.append(this.getNomeClasseEntidade());
		return  CreatorFabrica.getFabricaDAO().criarDisciplinaDAO().listar(builder.toString());
	}
	
	@Override
	public List<Disciplina> listarDisciplinasDeProfessor(Professor professor) {
		StringBuilder builder = new StringBuilder();
		builder.append(" from ");
		builder.append( this.getNomeClasseEntidade() );
		builder.append(" d ");
		builder.append(" where d.professor.chavePrimaria = ");
		builder.append(professor.getChavePrimaria());
		return CreatorFabrica.getFabricaDAO().criarDisciplinaDAO().listar(builder.toString());
	}
	
	@Override
	public List<Disciplina> listarDisciplinasDeAluno(Aluno aluno) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select d from ");
		builder.append(this.getNomeClasseEntidade());
		builder.append(" d ");
		builder.append(" inner join d.pagantes p ");
		builder.append(" where p.chavePrimaria = " );
		builder.append(aluno.getChavePrimaria());
		return CreatorFabrica.getFabricaDAO().criarDisciplinaDAO().listar(builder.toString());
	}
	@Override
	public List<Disciplina> buscarDisciplinasSemProfessor() {
		StringBuilder builder = new StringBuilder();
		builder.append(" from ");
		builder.append(this.getNomeClasseEntidade());
		builder.append(" d ");
		builder.append(" where d.professor is null ");
		return CreatorFabrica.getFabricaDAO().criarDisciplinaDAO().listar(builder.toString());
	}
	
	@Override
	public Disciplina buscarDisciplina(String descricao) throws NegocioException {

		HashMap<String, Object> filter = new HashMap<>();
		filter.put(Disciplina.ATRIBUTO_DESCRICAO, descricao);
		
		return (Disciplina) CreatorFabrica.getFabricaDAO().criarDisciplinaDAO().buscar(filter);
	}
	
	@Override
	public Disciplina buscarDisciplina(long chavePrimaria) {
		return CreatorFabrica.getFabricaDAO().criarDisciplinaDAO().buscar(chavePrimaria);
	}
	@Override
	public String getNomeClasseEntidade() {
		
		return DisciplinaImpl.class.getSimpleName();
	}
	
	
	
	

}
