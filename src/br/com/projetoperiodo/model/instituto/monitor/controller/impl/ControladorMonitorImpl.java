package br.com.projetoperiodo.model.instituto.monitor.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.aluno.impl.AlunoImpl;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.instituto.periodo.Periodo;
import br.com.projetoperiodo.model.instituto.periodo.controller.ControladorPeriodo;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
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
	@Override
	public Monitor buscarMonitoriasDeAluno(Aluno aluno) throws NegocioException {
		Monitor monitor = dao.buscar(aluno.getChavePrimaria());
		return monitor;
	}

	@Override
	public Monitor criarMonitoriaDeAluno(Aluno aluno, Disciplina disciplina, Modalidade modalidade) {
		ControladorPeriodo controladorPeriodo = Fachada.getInstance().getControladorPeriodo();
		Monitor monitor = (Monitor) criarEntidadeNegocio();
		monitor.setDisciplina(disciplina);
		monitor.setModalidade(modalidade);
		monitor.setAluno(aluno);
		monitor.setHabilitado(Boolean.TRUE);
		Periodo periodoCorrente = controladorPeriodo.gerarNovoPeriodoCorrente();
		monitor.setPeriodo(periodoCorrente);

		return monitor;
	}
	@Override
	public Monitor cadastrarMonitoria(Monitor monitor) {
		return dao.salvar(monitor);
	}
	@Override
	public boolean validarCadastroMonitoria(Monitor monitor) {
		boolean cadastroValido = Boolean.TRUE;
		boolean possuiCadastro;
		int qtdMonitoriasEmProgresso;

		possuiCadastro = verificaExistenciaCadastroMonitoria(monitor);
		qtdMonitoriasEmProgresso = buscarQuantidadeMonitoriasEmProgressoDeAluno(monitor);

		if (possuiCadastro || qtdMonitoriasEmProgresso > 0) {
			cadastroValido = Boolean.FALSE;
		}
		return cadastroValido;
	}
	@Override
	public boolean verificaExistenciaCadastroMonitoria(Monitor monitor) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select m from MonitorImpl m");
		builder.append(" where m.periodo.chavePrimaria = ");
		builder.append(monitor.getPeriodo().getChavePrimaria());
		builder.append(" and  m.disciplina.chavePrimaria = ");
		builder.append(monitor.getDisciplina().getChavePrimaria());
		builder.append( " and m.aluno.chavePrimaria = " );
		builder.append( monitor.getAluno().getChavePrimaria());
		builder.append(" and  m.habilitado = ");
		builder.append(Boolean.TRUE);
		List<Monitor> lista = dao.listar(builder.toString());
		if (lista.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private int buscarQuantidadeMonitoriasEmProgressoDeAluno(Monitor monitor) {
		StringBuilder builder = new StringBuilder();
		builder.append(" from MonitorImpl m");
		builder.append(" where m.habilitado = ");
		builder.append(Boolean.TRUE);
		builder.append( " and m.aluno.chavePrimaria = ");
		builder.append( monitor.getAluno().getChavePrimaria());
		List<Monitor> lista = dao.listar(builder.toString());
		return lista.size();
	}
	

	@Override
	public List<Monitor> listarMonitorias(Aluno aluno) {

		StringBuilder builder = new StringBuilder();
		builder.append(" from MonitorImpl m ");
		builder.append( " where m.aluno.chavePrimaria = " );
		builder.append(aluno.getChavePrimaria());
		return dao.listar(builder.toString());
	}
	
	@Override
	public Monitor buscarMonitoria( long chavePrimaria ) {

		return dao.buscar(chavePrimaria);
	}
	
	@Override
	public void removerMonitoria(long chavePrimaria) {
		
		Monitor monitor = (Monitor) this.criarEntidadeNegocio();
		monitor.setChavePrimaria(chavePrimaria);
		Fachada.getInstance().getControladorRelatorio().removerRelatoriosDeMonitoria(monitor);
		dao.remover(monitor);
	}

	@Override
	public String getNomeClasseEntidade() {
		
		return MonitorImpl.class.getSimpleName();
	}
}
