package br.com.projetoperiodo.model.relatorio.frequencia.controller;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;
import br.com.projetoperiodo.model.usuario.Usuario;
import br.com.projetoperiodo.util.constantes.enumeracoes.Situacao;
import br.com.projetoperiodo.util.exception.NegocioException;

public interface ControladorRelatorio extends ControladorNegocio{
	
	List<RelatorioFrequencia> buscarRelatoriosDeMonitor(Monitor monitor);
	
	void prepararRelatoriosDoMonitor(Monitor monitor);
	
	RelatorioFrequencia buscarRelatoriosDeMonitorPorMes(Monitor monitor, int mes);

	void atualizarRelatorio(RelatorioFrequencia relatorio);
	
	byte[] gerarDocumentoDeRelatorio(RelatorioFrequencia relatorio, Usuario requisitante) throws NegocioException;

	void removerRelatoriosDeMonitoria(Monitor monitor);

	RelatorioFrequencia aprovarRelatorio(RelatorioFrequencia relatorio);

	List<Situacao> buscaSituacaoDosRelatoriosDeMonitoria(Monitor monitor); 
}
