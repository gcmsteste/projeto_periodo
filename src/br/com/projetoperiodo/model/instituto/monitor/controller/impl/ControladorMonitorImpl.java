package br.com.projetoperiodo.model.instituto.monitor.controller.impl;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.instituto.monitor.controller.ControladorMonitor;
import br.com.projetoperiodo.model.instituto.monitor.dao.MonitorDao;
import br.com.projetoperiodo.model.instituto.monitor.impl.MonitorImpl;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

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
	
	/* (non-Javadoc)
	 * @see br.com.projetoperiodo.model.instituto.monitor.controller.impl.ControladorMonitor#cadastrarMonitor(br.com.projetoperiodo.model.instituto.monitor.Monitor)
	 */
	@Override
	public void cadastrarMonitor(Monitor monitor) {
		dao.salvar(monitor);
	}

}
