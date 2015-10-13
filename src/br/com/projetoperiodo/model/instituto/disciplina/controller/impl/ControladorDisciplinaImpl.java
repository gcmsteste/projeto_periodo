package br.com.projetoperiodo.model.instituto.disciplina.controller.impl;

import java.util.HashMap;
import java.util.List;

import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.disciplina.dao.DisciplinaDao;
import br.com.projetoperiodo.model.instituto.disciplina.impl.DisciplinaImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
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

		return dao.listar();
	}
	
	@Override
	public Disciplina buscarDisciplina(String descricao) throws NegocioException {

		HashMap<String, Object> filter = new HashMap<>();
		filter.put(Disciplina.ATRIBUTO_DESCRICAO, descricao);
		
		return (Disciplina) dao.buscar(filter);
	}

}
