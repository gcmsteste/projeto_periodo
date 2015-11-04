package br.com.projetoperiodo.model.instituto.disciplina.controller.impl;

import java.util.HashMap;
import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ControladorDisciplinaImpl extends ControladorNegocioImpl implements ControladorDisciplina
{
	private DisciplinaDao dao;
	
	
	public ControladorDisciplinaImpl() {
		dao = fabrica.criarDisciplinaDAO();
	}
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new DisciplinaImpl();
	}

	@Override
	public List<Disciplina> listarDisciplinasCadastradas() {
		StringBuilder builder = new StringBuilder();
		builder.append(" from ");
		builder.append(" DisciplinaImpl ");
		return dao.listar(builder.toString());
	}
	@Override
	public List<Disciplina> listarDisciplinasDeAluno(Aluno aluno) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select d from ");
		builder.append(" DisciplinaImpl d ");
		builder.append(" inner join d.pagantes p ");
		builder.append(" where p.chavePrimaria = " );
		builder.append(aluno.getChavePrimaria());
		return dao.listar(builder.toString());
	}
	@Override
	public Disciplina buscarDisciplina(String descricao) throws NegocioException {

		HashMap<String, Object> filter = new HashMap<>();
		filter.put(Disciplina.ATRIBUTO_DESCRICAO, descricao);
		
		return (Disciplina) dao.buscar(filter);
	}
	
	@Override
	public String getNomeClasseEntidade() {
		
		return DisciplinaImpl.class.getSimpleName();
	}
	
	

}
