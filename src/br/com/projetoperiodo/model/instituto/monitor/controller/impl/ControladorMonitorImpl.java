package br.com.projetoperiodo.model.instituto.monitor.controller.impl;

import br.com.projetoperiodo.model.instituto.aluno.Aluno;
import br.com.projetoperiodo.model.instituto.disciplina.Disciplina;
import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.util.constantes.enumeracoes.Modalidade;

public class ControladorMonitorImpl extends ControladorNegocioImpl implements ControladorMonitor
{
	private MonitorDao dao;

	public ControladorMonitorImpl() {
		dao = fabrica.criarMonitorDAO();
	}
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.controller.impl.ControladorMonitor#criarEntidadeNegocio()
	 */
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {
		return new MonitorImpl();
	}


	@Override
	public Monitor cadastrarMonitoria(Aluno aluno, Disciplina disciplina, Modalidade modalidade) {

		Monitor monitor = (Monitor) criarEntidadeNegocio();
		monitor.setDisciplina(disciplina);
		monitor.setModalidade(modalidade);
		monitor.setChavePrimaria(aluno.getChavePrimaria());
		dao.salvar(monitor);
		return monitor;
	}

}
