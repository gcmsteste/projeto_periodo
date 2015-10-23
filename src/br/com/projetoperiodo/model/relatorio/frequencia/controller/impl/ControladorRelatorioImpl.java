package br.com.projetoperiodo.model.relatorio.frequencia.controller.impl;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocioImpl;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.relatorio.frequencia.controller.ControladorRelatorio;
import br.com.projetoperiodo.model.relatorio.frequencia.dao.RelatorioFrequenciaDao;
import br.com.projetoperiodo.model.relatorio.frequencia.impl.RelatorioFrequenciaImpl;
import br.com.projetoperiodo.model.relatorio.semana.controller.ControladorSemana;
import br.com.projetoperiodo.util.Fachada;

public class ControladorRelatorioImpl extends ControladorNegocioImpl implements ControladorRelatorio
{
	private RelatorioFrequenciaDao dao;

	
	public ControladorRelatorioImpl() {
		dao = fabrica.criarRelatorioFrequenciaDAO();
	}
	@Override
	public EntidadeNegocio criarEntidadeNegocio() {

		return new RelatorioFrequenciaImpl();
	}

	@Override
	public List<RelatorioFrequencia> buscarRelatoriosDeMonitor(Monitor monitor) {
		StringBuilder builder = new StringBuilder();
		builder.append(" from RelatorioFrequenciaImpl r ");
		builder.append(" where r.monitor.chavePrimaria = ");
		builder.append(monitor.getChavePrimaria());
		return dao.listar(builder.toString());
	}
	@Override
	public Monitor prepararRelatoriosDoMonitor(Monitor monitor) {

		ControladorSemana controladorSemana = Fachada.getInstance().getControladorSemana();
		RelatorioFrequencia relatorio;
		for ( int mes = 1; mes <= 12; mes += 1) {
			relatorio = (RelatorioFrequencia) this.criarEntidadeNegocio();
			relatorio.setMes(mes);
			relatorio = controladorSemana.preCadastrarSemanaDeRelatorio(relatorio);
			relatorio.setMonitor(monitor);
			dao.salvar(relatorio);
		}
		return monitor;
	}
	@Override
	public RelatorioFrequencia buscarRelatoriosDeMonitorPorMes(Monitor monitor, int mes) {

		StringBuilder builder = new StringBuilder();
		builder.append(" select r from ");
		builder.append(" RelatorioFrequenciaImpl r ");
		builder.append(" where r.monitor.chavePrimaria =  ");
		builder.append(monitor.getChavePrimaria());
		builder.append(" and r.mes = ");
		builder.append(mes);
		RelatorioFrequencia relatorio = dao.listar(builder.toString()).get(0);
		return relatorio;
	}
	@Override
	public void atualizarRelatorio(RelatorioFrequencia relatorio) {
		dao.atualizar(relatorio);
	}
	
	
	
	
}
