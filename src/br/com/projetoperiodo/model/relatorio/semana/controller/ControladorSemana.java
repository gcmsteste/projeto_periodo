
package br.com.projetoperiodo.model.relatorio.semana.controller;

import br.com.projetoperiodo.model.negocio.controlador.ControladorNegocio;
import br.com.projetoperiodo.model.negocio.entidade.EntidadeNegocio;
import br.com.projetoperiodo.model.relatorio.frequencia.RelatorioFrequencia;

public interface ControladorSemana extends ControladorNegocio {

	EntidadeNegocio criarEntidadeNegocio();
	
	void cadastrarSemanasComRelatorio(RelatorioFrequencia relatorio);

}