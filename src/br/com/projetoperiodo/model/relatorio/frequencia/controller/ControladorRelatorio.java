package br.com.projetoperiodo.model.relatorio.frequencia.controller;

import java.util.List;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public interface ControladorRelatorio extends ControladorNegocio{
	
	List<RelatorioFrequencia> buscarRelatoriosDeMonitor(Monitor monitor);
	
	List<RelatorioFrequencia> prepararRelatoriosMonitor(Monitor monitor);
}
