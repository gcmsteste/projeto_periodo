
package br.com.projetoperiodo.model.instituto.monitor.controller;

import br.com.projetoperiodo.model.instituto.monitor.Monitor;
import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;

public interface ControladorMonitor extends ControladorNegocio
{

	void cadastrarMonitor(Monitor monitor);

}