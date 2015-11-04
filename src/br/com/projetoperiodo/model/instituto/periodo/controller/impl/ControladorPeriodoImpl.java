package br.com.projetoperiodo.model.instituto.periodo.controller.impl;

import java.util.Calendar;
import java.util.List;

import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo;
import br.com.projetoperiodo.model.instituto.periodo.dao.PeriodoDao;
import br.com.projetoperiodo.model.instituto.periodo.impl.PeriodoImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.Constantes;
import br.com.projetoperiodo.util.constantes.enumeracoes.Semestre;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ControladorPeriodoImpl extends ControladorNegocioImpl implements ControladorPeriodo {
	private PeriodoDao dao;

	public ControladorPeriodoImpl() {
		dao = fabrica.criarPeriodoDao();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.projetoperiodo.model.instituto.periodo.controller.
	 * ControladorPeriodo#criarEntidadeNegocio()
	 */

	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new PeriodoImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.projetoperiodo.model.instituto.periodo.controller.
	 * ControladorPeriodo#gerarNovoPeriodo()
	 */
	// TODO quebrar essa função em mais de uma
	@Override
	public Periodo gerarNovoPeriodoCorrente() {
		Periodo periodo = (Periodo) criarEntidadeNegocio();
		Calendar dataAtual = Calendar.getInstance();
		int anoAtual = dataAtual.get(Calendar.YEAR);
		Calendar inicioSegundoSemestre = Calendar.getInstance();
		inicioSegundoSemestre.set(anoAtual, 7, 1);
		if (dataAtual.after(inicioSegundoSemestre)) {
			periodo.setSemestre(Semestre.SEGUNDO);
		} else {
			periodo.setSemestre(Semestre.PRIMEIRO);
		}
		periodo.setAno(anoAtual);
		
		try {
			periodo = buscarPeriodo(periodo.getAno(), periodo.getSemestre());
		} catch (NegocioException e) {
			periodo = cadastrarPeriodo(periodo);
		}
		return periodo;
	}

	@Override
	public Periodo cadastrarPeriodo(Periodo periodo) {
		dao.salvar(periodo);
		return periodo;
	}

	@Override
	public Periodo buscarPeriodo(int ano, Semestre semestre) throws NegocioException {
		StringBuilder builder = new StringBuilder();
		builder.append(" select p from ");
		builder.append(this.getNomeClasseEntidade());
		builder.append(" p ");
		builder.append(" where p.ano =  ");
		builder.append(ano);
		builder.append(" and ");
		builder.append(" p.semestre = ");
		builder.append(semestre.semestre);
		List<Periodo> listaDePeriodos = dao.listar(builder.toString());
		if (listaDePeriodos.isEmpty()) {
			throw new NegocioException(Constantes.ENTIDADE_NAO_ENCONTRADA);
		}
		return listaDePeriodos.get(0);
	}

	@Override
	public String getNomeClasseEntidade() {
		
		return PeriodoImpl.class.getSimpleName();
	}

}
