package br.com.projetoperiodo.model.instituto.monitor.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.disciplina.controller.ControladorDisciplina;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.Fachada;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;
import br.com.projetoperiodo.util.exception.NegocioException;

public class ControladorMonitorImpl extends ControladorNegocioImpl implements ControladorMonitor {
	private MonitorDao dao;

	public ControladorMonitorImpl() {
		dao = fabrica.criarMonitorDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.projetoperiodo.model.instituto.monitor.controller.impl.
	 * ControladorMonitor#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {
		return new MonitorImpl();
	}

	public Monitor buscarMonitoriasDeAluno(Aluno aluno) throws NegocioException {
		Monitor monitor = dao.buscar(aluno.getChavePrimaria());
		return monitor;
	}

	@Override
	public Monitor cadastrarMonitoria(Aluno aluno, Disciplina disciplina, Modalidade modalidade) throws NegocioException {
		ControladorPeriodo controladorPeriodo = Fachada.getInstance().getControladorPeriodo();
		boolean possuiCadastro = false;
		Monitor monitor = (Monitor) criarEntidadeNegocio();
		monitor.setDisciplina(disciplina);
		monitor.setModalidade(modalidade);
		monitor.setChavePrimaria(aluno.getChavePrimaria());
		Periodo periodoCorrente = controladorPeriodo.gerarNovoPeriodoCorrente();
		monitor.setPeriodo(periodoCorrente);

		possuiCadastro = verificaExistenciaCadastroMonitoria(monitor);
		if (possuiCadastro) {
			throw new NegocioException(ControladorMonitor.MONITORIA_CADASTRADA);
		} 
		dao.salvar(monitor);
		return monitor;
	}

	@Override
	public boolean verificaExistenciaCadastroMonitoria(Monitor monitor) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select from MonitorImpl m");
		builder.append(" where m.periodo.chavePrimaria = ");
		builder.append(monitor.getPeriodo().getChavePrimaria());
		builder.append(" and ");
		builder.append(" m.disciplina.chavePrimaria = ");
		builder.append(monitor.getDisciplina().getChavePrimaria());
		List<Monitor> lista = dao.listar(builder.toString());
		if (lista.isEmpty()) {
			return false;
		}
		return true;
	}

}
